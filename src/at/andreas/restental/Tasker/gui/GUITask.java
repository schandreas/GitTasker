package at.andreas.restental.Tasker.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import at.andreas.restental.Tasker.Task;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class GUITask extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2414342546930428071L;

	public GUITask (Task tsk) {
		super();
		this.setMaximumSize(new Dimension(40000,120));
		this.setVisible(true);
		this.setPreferredSize(new Dimension(400,120));
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, new JSeparator());
		this.add(BorderLayout.SOUTH, new JSeparator());
		
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblName = new JLabel("Name: " + tsk.getName());
		panel.add(lblName);
		
		JLabel lblDesc = new JLabel("Description: " + tsk.getDescription());
		panel.add(lblDesc);
		
		JLabel lblCreator = new JLabel("Creator: " + tsk.getCreator());
		panel.add(lblCreator);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPrio = new JLabel("Priority: " + tsk.getPriority() + "   ");
		panel_1.add(lblPrio, BorderLayout.WEST);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(separator, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JCheckBox chckbxcomplete = new JCheckBox("Complete?");
		panel_2.add(chckbxcomplete, BorderLayout.EAST);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		panel_2.add(separator_1, BorderLayout.WEST);
	}

}
