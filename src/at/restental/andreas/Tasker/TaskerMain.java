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
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			
		} catch (ClassNotFoundException e) {
			
		} catch (InstantiationException e) {
			
		} catch (IllegalAccessException e) {
			
		}

		tsk = new TaskerXMLParser(args[0]).readTasks();

		test.updateGUITasks();

		TaskerXMLWriter out = new TaskerXMLWriter(args[0]);

		test.addWindowListener(new TaskerWindowListener(out));
	}

	

}
