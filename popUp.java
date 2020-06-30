package Program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class popUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtMmddyyyy;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popUp frame = new popUp();
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
	public popUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][54.00][][53.00,left]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("ENTER NEW MILEAGE:  ");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setText("0000000");
		contentPane.add(textField, "cell 1 0,alignx center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" DATE: ");
		contentPane.add(lblNewLabel_1, "cell 2 0,alignx trailing");
		
		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("mm/dd/yyyy");
		contentPane.add(txtMmddyyyy, "cell 3 0,alignx left,aligny center");
		txtMmddyyyy.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Oil Change?");
		contentPane.add(chckbxNewCheckBox, "cell 0 1,alignx right");
		
		chckbxNewCheckBox_1 = new JCheckBox("Synthetic oil?");
		contentPane.add(chckbxNewCheckBox_1, "cell 1 1 2 1,growx");
		
		btnNewButton = new JButton("Update");
		contentPane.add(btnNewButton, "cell 3 1");
		
		lblNewLabel_2 = new JLabel("            Next oil change at 0003000 miles    ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_2, "cell 0 2 3 1,alignx left");
		
		btnNewButton_1 = new JButton("   Exit   ");
		contentPane.add(btnNewButton_1, "cell 3 2");
	}

}
