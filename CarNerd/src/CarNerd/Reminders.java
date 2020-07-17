package CarNerd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class Reminders {
	
	String[] reminders = {"Reminder1", "Reminder2", "Reminder3", "Reminder4", "Reminder5", "Reminder6", "Reminder7"};
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reminders window = new Reminders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reminders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(new BorderLayout());
		
		JList list = new JList(reminders);
		
		
		
		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setPreferredSize(new Dimension(250, 80));
		
		JLabel label1 = new JLabel("New label");
		panel.add(label1, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("New label");
		panel.add(label2, BorderLayout.SOUTH);
		
		JLabel label3 = new JLabel("New label");
		panel.add(label3, BorderLayout.EAST);
		
		JLabel label4 = new JLabel("New label");
		panel.add(label4, BorderLayout.WEST);
		
		JLabel label5 = new JLabel("New label");
		panel.add(label5, BorderLayout.BEFORE_LINE_BEGINS);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
	}

}