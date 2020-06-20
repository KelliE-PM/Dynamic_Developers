package car_nerds_ui_stage1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogPage2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtEvent;
	private JTextField txtRemindDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogPage2 frame = new LogPage2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setBounds(46, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTrim = new JLabel("TRIM:");
		lblTrim.setBounds(201, 11, 46, 14);
		contentPane.add(lblTrim);
		
		JLabel lblNewLabel_1_1 = new JLabel("YEAR:");
		lblNewLabel_1_1.setBounds(355, 11, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MAKE:");
		lblNewLabel_1_2.setBounds(531, 11, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MODEL:");
		lblNewLabel_1_3.setBounds(726, 11, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtTitle = new JTextField();
		txtTitle.setText("Title");
		txtTitle.setBounds(246, 66, 86, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtEvent = new JTextField();
		txtEvent.setText("Event");
		txtEvent.setColumns(10);
		txtEvent.setBounds(405, 66, 86, 20);
		contentPane.add(txtEvent);
		
		txtRemindDate = new JTextField();
		txtRemindDate.setText("Remind Date");
		txtRemindDate.setColumns(10);
		txtRemindDate.setBounds(562, 66, 86, 20);
		contentPane.add(txtRemindDate);
		
		JTextPane txtpnEnterNotesHere = new JTextPane();
		txtpnEnterNotesHere.setText("Enter Notes Here");
		txtpnEnterNotesHere.setBounds(246, 109, 402, 238);
		contentPane.add(txtpnEnterNotesHere);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(312, 358, 89, 34);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(488, 358, 89, 34);
		contentPane.add(btnCancel);
		
		JButton btnNewButton_1 = new JButton("CAR");
		btnNewButton_1.setBounds(20, 434, 89, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("LOG");
		btnNewButton_1_1.setBounds(142, 434, 89, 38);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("INFO");
		btnNewButton_1_1_1.setBounds(270, 434, 89, 38);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("MILEAGE");
		btnNewButton_1_1_2.setBounds(392, 434, 89, 38);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_3 = new JButton("REMIND");
		btnNewButton_1_1_3.setBounds(515, 434, 89, 38);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_4 = new JButton("DOCS");
		btnNewButton_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_4.setBounds(639, 434, 89, 38);
		contentPane.add(btnNewButton_1_1_4);
		
		JButton btnNewButton_1_1_5 = new JButton("SETTINGS");
		btnNewButton_1_1_5.setBounds(769, 434, 89, 38);
		contentPane.add(btnNewButton_1_1_5);
	}
}
