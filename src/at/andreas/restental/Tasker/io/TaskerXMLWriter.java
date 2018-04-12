package at.andreas.restental.Tasker.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import at.andreas.restental.Tasker.Task;

public class TaskerXMLWriter {

	XMLStreamWriter out;
	FileOutputStream outstream;

	public TaskerXMLWriter(String filepath) {
		XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
		try {
			outstream = new FileOutputStream(filepath);
			out = outFactory.createXMLStreamWriter(outstream);
			out.writeStartDocument();
			out.writeStartElement("tasks");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	public void writeTask(Task tsk) {
		try {
			out.writeStartElement("task");
			out.writeStartElement("name");
			out.writeCharacters(tsk.getName());
			out.writeEndElement();
			out.writeStartElement("description");
			out.writeCharacters(tsk.getDescription());
			out.writeEndElement();
			out.writeStartElement("priority");
			out.writeCharacters("" + tsk.getPriority());
			out.writeEndElement();
			out.writeStartElement("creator");
			out.writeCharacters(tsk.getCreator());
			out.writeEndElement();
			out.writeEndElement();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
		out.writeEndElement();
		out.writeEndDocument();
		out.flush();
		out.close();
		outstream.flush();
		outstream.close();
		}catch(XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
