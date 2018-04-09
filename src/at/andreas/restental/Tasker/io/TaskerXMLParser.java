package at.andreas.restental.Tasker.io;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import at.andreas.restental.Tasker.Task;

public class TaskerXMLParser {

    SAXParser sp;
    TaskHandler th;
    File in;

    public TaskerXMLParser(String filepath) {

        try {
            in = new File(filepath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            sp = factory.newSAXParser();
            th = new TaskHandler();
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        }
    }

    public Task[] readTasks(){
        try {
            sp.parse(in, th);
            return th.getTasks();
        }catch(IOException e1){
            e1.printStackTrace();
        }catch(SAXException e2){
            e2.printStackTrace();
        }
        return null;
    }


    class TaskHandler extends DefaultHandler {

        Vector<Task> tasks;
        int current_task;
        String temp;

        public TaskHandler(){
            tasks = new Vector<Task>();
            current_task = 0;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equalsIgnoreCase("task")){
                tasks.add(new Task());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch(qName){
                case "task":
                    current_task++;
                    break;
                case "name":
                    tasks.elementAt(current_task).setName(temp);
                    break;
                case "description":
                    tasks.elementAt(current_task).setDescription(temp);
                    break;
                case "creator":
                    tasks.elementAt(current_task).setCreator(temp);
                    break;
                case "priority":
                    tasks.elementAt(current_task).setPriority(Integer.parseInt(temp));
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            temp = new String(ch, start, length);
        }

        public Task[] getTasks() {
            Task ret[] = new Task[tasks.size()];
            for(int i = 0; i < tasks.size(); i++){
                ret[i] = tasks.get(i);
            }
            return ret;
        }
    }

}
