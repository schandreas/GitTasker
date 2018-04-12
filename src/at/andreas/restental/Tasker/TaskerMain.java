package at.andreas.restental.Tasker;


import java.util.Vector;

import at.andreas.restental.Tasker.gui.TaskerGUI;
import at.andreas.restental.Tasker.io.TaskerXMLParser;
import at.andreas.restental.Tasker.io.TaskerXMLWriter;

public class TaskerMain {

    public static void main(String args[]){
        Vector<Task> tsk = new TaskerXMLParser(args[0]).readTasks();
        TaskerGUI test = new TaskerGUI();
        for(int i = 0; i < tsk.size(); i++) {
        	test.addGUITask(tsk.elementAt(i));
        }
        TaskerXMLWriter out = new TaskerXMLWriter(args[0]);
        for(int i = 0; i < tsk.size(); i++) {
        	out.writeTask(tsk.get(i));
        }
        out.close();
    }


}
