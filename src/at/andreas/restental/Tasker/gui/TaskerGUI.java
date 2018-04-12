package at.andreas.restental.Tasker.gui;

import javax.swing.*;

import at.andreas.restental.Tasker.Task;
import at.andreas.restental.Tasker.TaskerMain;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskerGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5997990811036948155L;

	JPanel ViewportWrapper;

	public TaskerGUI() {
		super("Tasker");
		this.setSize(400, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel = new JLabel("Task List");
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("New Task");
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		btnNewButton.addActionListener(this);

		ViewportWrapper = new JPanel();
		ViewportWrapper.setLayout(new BoxLayout(ViewportWrapper, BoxLayout.PAGE_AXIS));
		scrollPane.setViewportView(ViewportWrapper);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setVisible(true);
	}

	public void addGUITask(Task tsk) {
		ViewportWrapper.add(new GUITask(tsk));
		this.setVisible(true);
	}
	
	public void removeAllGUITasks() {
		ViewportWrapper.removeAll();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = (String) JOptionPane.showInputDialog(this, "Enter Name for new Task", "Name Picker (Step 1/4)",
				JOptionPane.INFORMATION_MESSAGE, null, null, "new_Task");
		if (name == null || name.length() == 0) {
			JOptionPane.showMessageDialog(this, "Invalid Input. Aborting", "Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String creator = (String) JOptionPane.showInputDialog(this, "Enter Creator for new Task",
				"Name Picker (Step 2/4)", JOptionPane.INFORMATION_MESSAGE, null, null, "new_Task");
		if (creator == null || creator.length() == 0) {
			JOptionPane.showMessageDialog(this, "Invalid Input. Aborting", "Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String description = (String) JOptionPane.showInputDialog(this, "Enter Description for new Task",
				"Name Picker (Step 3/4)", JOptionPane.INFORMATION_MESSAGE, null, null, "new_Task");
		if (description == null || description.length() == 0) {
			JOptionPane.showMessageDialog(this, "Invalid Input. Aborting", "Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String priority_s = (String) JOptionPane.showInputDialog(this, "Enter Priority for new Task",
				"Name Picker (Step 4/4)", JOptionPane.INFORMATION_MESSAGE, null, null, "new_Task");
		if (priority_s == null || priority_s.length() == 0) {
			JOptionPane.showMessageDialog(this, "Invalid Input. Aborting", "Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			Task toadd = new Task(name, description, creator, new Integer(priority_s));
			TaskerMain.tsk.add(toadd);
			TaskerMain.updateGUITasks();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid Input. Aborting", "Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

	}

}
