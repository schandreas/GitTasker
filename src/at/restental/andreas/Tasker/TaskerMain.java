package at.restental.andreas.Tasker;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
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

		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);

		TaskerXMLWriter out;

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (!fc.getSelectedFile().exists()) {
				try {
					fc.getSelectedFile().createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			tsk = new TaskerXMLParser(fc.getSelectedFile().getAbsolutePath()).readTasks();
			out = new TaskerXMLWriter(args[0]);
		} else {
			if (!new File("tasks.xml").exists()) {
				try {
					new File("tasks.xml").createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			tsk = new TaskerXMLParser("tasks.xml").readTasks();
			out = new TaskerXMLWriter("tasks.xml");
		}

		test.updateGUITasks();

		test.addWindowListener(new TaskerWindowListener(out));
	}

}
