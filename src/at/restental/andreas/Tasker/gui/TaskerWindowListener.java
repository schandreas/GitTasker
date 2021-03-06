package at.restental.andreas.Tasker.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import at.restental.andreas.Tasker.TaskerMain;
import at.restental.andreas.Tasker.io.TaskerXMLWriter;

public class TaskerWindowListener implements WindowListener {

	TaskerXMLWriter toclose;

	public TaskerWindowListener(TaskerXMLWriter toclose) {
		this.toclose = toclose;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		for (int i = 0; i < TaskerMain.tsk.size(); i++) {
			toclose.writeTask(TaskerMain.tsk.get(i));
		}
		toclose.close();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
