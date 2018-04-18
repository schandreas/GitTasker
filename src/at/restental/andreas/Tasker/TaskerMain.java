package at.restental.andreas.Tasker;

import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import at.restental.andreas.Tasker.gui.TaskerGUI;
import at.restental.andreas.Tasker.gui.TaskerWindowListener;
import at.restental.andreas.Tasker.io.TaskerXMLParser;
import at.restental.andreas.Tasker.io.TaskerXMLWriter;

public class TaskerMain {

	public static Vector<Task> tsk;
	private static TaskerGUI test = new TaskerGUI();

	public static void main(String args[]) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

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