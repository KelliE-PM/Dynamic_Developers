import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DocumentTab {

	private JFrame frame;
	private final JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentTab window = new DocumentTab();
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
	public DocumentTab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 160, 221));
		frame.setBounds(100, 100, 561, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:          Make:          Model:          Year:          ");
		lblNewLabel.setBounds(0, 0, 364, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(128, 0, 128));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane_1.setBounds(0, 42, 489, 35);
		frame.getContentPane().add(tabbedPane_1);
        // add tab with title
        tabbedPane_1.addTab("Documents", tabbedPane);
        
        JButton btnInsurance = new JButton("Insurance");
        btnInsurance.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnInsurance.setForeground(new Color(0, 0, 205));
        btnInsurance.setBounds(12, 109, 118, 25);
        frame.getContentPane().add(btnInsurance);
        
        JButton btnRegistration = new JButton("Registration");
        btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRegistration.setForeground(new Color(0, 0, 205));
        btnRegistration.setBounds(12, 206, 118, 25);
        frame.getContentPane().add(btnRegistration);
        
        JButton btnLicense = new JButton("License");
        btnLicense.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnLicense.setForeground(new Color(0, 0, 205));
        btnLicense.setBounds(12, 156, 118, 25);
        frame.getContentPane().add(btnLicense);
	}
}
