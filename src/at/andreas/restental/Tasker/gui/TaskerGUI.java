package at.andreas.restental.Tasker.gui;

import javax.swing.*;

import at.andreas.restental.Tasker.Task;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TaskerGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5997990811036948155L;

	JPanel panel_1;
	
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
		
		panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 1));
		scrollPane.setViewportView(panel_1);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public void addGUITask(Task tsk) {
		panel_1.add(new GUITask(tsk));
	}



}
