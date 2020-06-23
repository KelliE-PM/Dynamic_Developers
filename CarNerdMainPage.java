package CarNerd;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class Cant extends JPanel {
    public Cant() {
    	super(new GridLayout(1, 1));
        

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ImageIcon icon = createImageIcon("");

        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Car", icon, panel1,
                "Does nothing");
        panel1.setPreferredSize(new Dimension(300,300));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
    // INFO TAB - ALYSSA
        JComponent panel2 = makeTextPanel("Panel #2");
        // Makes it that it doesn't take up the entire area.  Still adjusting
        panel2.setLayout(new FlowLayout());
        tabbedPane.addTab("Info", icon, panel2,
                "Does twice as much nothing");
        
        JComponent tbCarName = new JTextField("Enter Name");
        panel2.add(tbCarName);
        tbCarName.setSize(200, 20);
        JComponent tbCarYear = new JTextField("Enter Year");
        panel2.add(tbCarYear);
        
        JComponent tbCarMake = new JTextField("Enter Make");
        panel2.add(tbCarMake);
        
        JComponent tbCarModel = new JTextField("Enter Model");
        panel2.add(tbCarModel);
        
        JComponent tbCarTrim = new JTextField("Enter Trim if Applicable");
        panel2.add(tbCarTrim);
        
        JComponent tbCarVIN = new JTextField("Enter VIN");
        panel2.add(tbCarVIN);
        
        JComponent carPlateNum = new JTextField("Enter Plate Number");
        panel2.add(carPlateNum);
        
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Log", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel("Panel 4");
        tabbedPane.addTab("Mileage", icon, panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
	    
	public class swingMileage extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingMileage frame = new swingMileage();
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
	
	public swingMileage() {
		
		int startMileage = -1;
		int currentMileage = 0;
		int lastOilChange = 0;
		int nextChangeMileage = 0;
		boolean synthetic;
		boolean changeDue;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{121, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{14, 14, 0, 0, 0, 0, 0, 0, 14, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Starting Mileage: " + startMileage);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.EAST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_1 = new JLabel("Current Mileage: " + currentMileage);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.EAST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Update");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		lblNewLabel_4 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_2 = new JLabel("Last oil change was at Mileage: " + lastOilChange);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.EAST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_2 = new JButton("Update");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 3;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		lblNewLabel_5 = new JLabel("Did you use synthetic oil?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 4;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		lblNewLabel_3 = new JLabel("Next oil change is due at mileage: " + (lastOilChange + 3000));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
	}
}

        JComponent panel5 = makeTextPanel("Panel #5");
        String[] reminders = {"Reminder1", "Reminder2", "Reminder3", "Reminder4", "Reminder5", "Reminder6", "Reminder7"};
        tabbedPane.addTab("Reminders", icon, panel5,
                "Reminders");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
	panel5.setLayout(new BorderLayout());	
		JList list = new JList(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		panel5.add(scrollPane, BorderLayout.WEST);
		scrollPane.setPreferredSize(new Dimension(250, 80));
		scrollPane.setMaximumSize(new Dimension(360, 120));
		scrollPane.setSize(new Dimension(250, 80));
		scrollPane.revalidate();

        
        JComponent panel6 = makeTextPanel("Panel #6");
        tabbedPane.addTab("Documents", icon, panel6,
                "Still does nothing");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
        
        JComponent panel7 = makeTextPanel("Panel #7");
        tabbedPane.addTab("Settings", icon, panel7,
                "Still does nothing");
        tabbedPane.setMnemonicAt(6, KeyEvent.VK_7);

        JComponent panel8 = makeTextPanel("Panel #8");
        tabbedPane.addTab("Quit", icon, panel8,
                "Still does nothing");
        tabbedPane.setMnemonicAt(7, KeyEvent.VK_8);

        add(tabbedPane);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Cant.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CarNerd");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Cant(), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}
