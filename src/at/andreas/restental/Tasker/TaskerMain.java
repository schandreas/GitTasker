package at.andreas.restental.Tasker;

import java.util.Vector;

import at.andreas.restental.Tasker.gui.TaskerGUI;
import at.andreas.restental.Tasker.gui.TaskerWindowListener;
import at.andreas.restental.Tasker.io.TaskerXMLParser;
import at.andreas.restental.Tasker.io.TaskerXMLWriter;

public class TaskerMain {

	public static Vector<Task> tsk;
	private static TaskerGUI test = new TaskerGUI();
	
	public static void main(String args[]) {
		tsk = new TaskerXMLParser(args[0]).readTasks();
		
		updateGUITasks();
		
		TaskerXMLWriter out = new TaskerXMLWriter(args[0]);

		test.addWindowListener(new TaskerWindowListener(out));
	}

	public static void updateGUITasks() {
		test.removeAllGUITasks();
		for (int i = 0; i < tsk.size(); i++) {
			test.addGUITask(tsk.elementAt(i));
		}
	}
	
	
}
