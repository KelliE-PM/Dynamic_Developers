package CarNerd;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CarNerdMainPage extends JPanel {
    public CarNerdMainPage() {
    	super(new GridLayout(1, 1));


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ImageIcon icon = createImageIcon("");
// ****BACKGROUND COLORS FOR TABS******        
        int r = 191, g = 136, b = 187;
        
// ******CAR TAB******
        JComponent panel0 = makeTextPanel("Panel #0");
        tabbedPane.addTab("Car", icon, panel0, null);
        panel0.setBackground(new Color(r, g, b));
        panel0.setPreferredSize(new Dimension(900, 900));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        
        
// ******INFO TAB****** - ALYSSA
        JComponent panel1 = makeTextPanel("Panel #1");
        // Makes it that it doesn't take up the entire area.  Still adjusting
        //panel1.setLayout(new FlowLayout());
        tabbedPane.addTab("Info", null, panel1, null);
        panel1.setBackground(new Color(r, g, b));
        panel1.setLayout(null);
        
        JLabel lblCarName = new JLabel("Name");
        JLabel lblCarYear = new JLabel("Year");
		JLabel lblCarMake = new JLabel("Make");
        JLabel lblCarModel = new JLabel("Model");
        JLabel lblCarTrim = new JLabel("Trim if Applicable");
		JLabel lblCarVIN = new JLabel("VIN");
        JLabel lblPlateNum = new JLabel("Plate Number");
        JButton btnEdit = new JButton("Edit");
        
        
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEdit.setForeground(new Color(0, 0, 205));
        
        
        lblCarName.setBounds(10, 50, 500, 14);
		lblCarYear.setBounds(10, 70, 0, 0);
        lblCarMake.setBounds(170, 70, 118, 25);
        lblCarModel.setBounds(270, 70, 118, 25);
		lblCarTrim.setBounds(370, 70, 118, 25);
        lblCarVIN.setBounds(10, 90, 118, 25);
        lblPlateNum.setBounds(170, 90, 118, 25);
        btnEdit.setBounds(400, 200, 118, 25);
        
        panel1.add(lblCarName);
		panel1.add(lblCarYear);
        panel1.add(lblCarMake);
        panel1.add(lblCarModel);
        panel1.add(lblCarTrim);
        panel1.add(lblCarVIN);
        panel1.add(lblPlateNum);
        panel1.add(btnEdit);
        
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_1);

// ******LOG TAB******
        JComponent panel2 = makeTextPanel("Panel #2");
        //Panel panel2 = new Panel();
        tabbedPane.addTab("Log", null, panel2, null);
        panel2.setLayout(null);
        panel2.setBackground(new Color(r, g, b));
        JLabel lblNewLabel = new JLabel("NAME, YEAR MAKE MODEL: CURRENT CAR");
        lblNewLabel.setBounds(55, 15, 500, 14);
        panel2.add(lblNewLabel);
        
        JTextArea txtrEnterTextHere = new JTextArea();
        txtrEnterTextHere.setText("Enter text here");
        txtrEnterTextHere.setBounds(222, 97, 407, 241);
        panel2.add(txtrEnterTextHere);
        
        JTextField txtTitle = new JTextField();
        txtTitle.setText("Title");
        txtTitle.setBounds(196, 66, 86, 20);
        panel2.add(txtTitle);
        txtTitle.setColumns(10);
        
        JTextField txtEvent = new JTextField();
        txtEvent.setText("Event");
        txtEvent.setColumns(10);
        txtEvent.setBounds(379, 66, 86, 20);
        panel2.add(txtEvent);
        
        JTextField txtRemindDate = new JTextField();
        txtRemindDate.setText("Remind Date");
        txtRemindDate.setColumns(10);
        txtRemindDate.setBounds(569, 66, 86, 20);
        panel2.add(txtRemindDate);
        
        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(268, 349, 89, 45);
        panel2.add(btnSave);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.setBounds(501, 349, 89, 45);
        panel2.add(btnClear);
              
 
        String[] reminders = {"Reminder1", "Reminder2", "Reminder3", "Reminder4", "Reminder5", "Reminder6", "Reminder7"};
        //panel2.setLayout(new BorderLayout());	
		JList list = new JList(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		panel2.add(scrollPane, BorderLayout.WEST);
		
		scrollPane.setBounds(10, 40, 170, 400);
		//scrollPane.setPreferredSize(new Dimension(100, 80));
		/*
		scrollPane.setMaximumSize(new Dimension(360, 120));
		scrollPane.setSize(new Dimension(250, 80));
		*/
		//scrollPane.revalidate();
		
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_2);  
		
// ******MILEAGE TAB******        
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Mileage", icon, panel3, null);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);      
        

        
// ******REMINDER TAB - BEING MERGED WITH LOG******        
        //JComponent panel5 = makeTextPanel("Panel #5");
        //String[] reminders = {"Reminder1", "Reminder2", "Reminder3", "Reminder4", "Reminder5", "Reminder6", "Reminder7"};
        //tabbedPane.addTab("Reminders", icon, panel5, "Reminders");
        //tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
        //panel5.setLayout(new BorderLayout());	
		//JList list = new JList(reminders);
		//JScrollPane scrollPane = new JScrollPane(list);
		//panel5.add(scrollPane, BorderLayout.WEST);
		//scrollPane.setPreferredSize(new Dimension(250, 80));
		//scrollPane.setMaximumSize(new Dimension(360, 120));
		//scrollPane.setSize(new Dimension(250, 80));
		//scrollPane.revalidate();

		
// ******SETTINGS TAB******        
        JComponent panel6 = makeTextPanel("Panel #6");
        tabbedPane.addTab("Settings", icon, panel6, null);
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_6);
        add(tabbedPane);

        
        
// ******EXTRA TAB - FOR DEVELOPMENT******
      /*         
        JComponent panel6 = makeTextPanel("Panel #4");
        tabbedPane.addTab("Settings", icon, panel6, null);
        
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);
        
        */        
// ******APPLIES TO ENTIRE WINDOW******
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
        java.net.URL imgURL = CarNerdMainPage2.class.getResource(path);
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

        frame.getContentPane().add(new CarNerdMainPage2(), BorderLayout.CENTER);

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
