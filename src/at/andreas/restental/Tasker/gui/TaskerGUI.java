package at.andreas.restental.Tasker.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TaskerGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5997990811036948155L;

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
		this.setVisible(true);
	}



}
