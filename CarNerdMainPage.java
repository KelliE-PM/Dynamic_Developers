package CarNerd;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class CarNerdMainPage extends JPanel {
    public CarNerdMainPage() throws ParseException {
    	super(new GridLayout(1, 1));


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ImageIcon icon = createImageIcon("");
// ****BACKGROUND COLORS FOR TABS******        
        int r = 191, g = 136, b = 255;
// ****SIZE OF MAIN WINDOW******       
        int x = 700, y = 700;
        
// ******CAR TAB******
        JComponent panel0 = makeTextPanel("Panel #0");
        tabbedPane.addTab("Car", icon, panel0, null);
        panel0.setBackground(new Color(r, g, b));
        panel0.setLayout(null);
       
        String[] cars = {"Miata", "F150", "Jeep", "Mazda 3", "350z"};
        
        JButton btnAddCar = new JButton("Add Car");
        JComboBox<String> spChooseCar = new JComboBox<String>(cars);
        
        JLabel lblCarSelected0 = new JLabel("Mira, 2000 Mazda MX-5/LS");
        lblCarSelected0.setBounds(55, 15, 500, 14);
        panel0.add(lblCarSelected0);
        
        btnAddCar.setBounds((x / 2) - (100 / 2), (y / 2) - 30 / 2, 100, 30);
        spChooseCar.setBounds((x / 2) - (150 + 30) / 2, (y / 2) - (20 + 30) , 150, 20);
        
        panel0.add(btnAddCar);
        panel0.add(spChooseCar);
        
        panel0.setPreferredSize(new Dimension(x, y));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        
        
// ******INFO TAB****** - ALYSSA
        JComponent panel1 = makeTextPanel("Panel #1");
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
       
        
        lblCarName.setBounds(300, 200, 100, 20);
		lblCarYear.setBounds(130, 230, 100, 20);
        lblCarMake.setBounds(230, 230, 100, 20);
        lblCarModel.setBounds(330, 230, 100, 20);
		lblCarTrim.setBounds(430, 230, 100, 20);
        lblCarVIN.setBounds(250, 260, 100, 20);
        lblPlateNum.setBounds(350, 260, 100, 20);
        btnEdit.setBounds(275, 390, 150, 30);
        
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
        tabbedPane.addTab("Log", null, panel2, null);
        panel2.setLayout(null);
        panel2.setBackground(new Color(r, g, b));
        
        JLabel lblCarSelected2 = new JLabel("NAME, YEAR MAKE MODEL: CURRENT CAR");
        lblCarSelected2.setBounds(55, 15, 500, 14);
        panel2.add(lblCarSelected2);
        
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
              
 
        String[] reminders = {"   NoteTitle1", "**NoteTitle2", "    NoteTitle3", "   NoteTitle4", "**NoteTitle5", "   NoteTitle6", "**NoteTitle7"};
        JList list = new JList(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		panel2.add(scrollPane, BorderLayout.WEST);
		scrollPane.setBounds(10, 40, 170, 400);
		
		
        JLabel lblNote = new JLabel("Any Notes marked with ** have reminders.");
        lblNote.setBounds(10, 450, 700, 20);
        panel2.add(lblNote);
		
		
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_2);  
		
		
// ******MILEAGE TAB******        
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Mileage", icon, panel3, null);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);      
        panel3.setBackground(new Color(r, g, b));
        panel3.setLayout(null);
        
        JLabel lblCarSelected3 = new JLabel("NAME, YEAR MAKE MODEL: CURRENT CAR");
        lblCarSelected3.setBounds(55, 15, 500, 14);
        panel3.add(lblCarSelected3);
        
        int lastOilMile = 157249;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date lastOilDate = (dateFormat.parse("04/29/2020"));
        int lastMile = 155924;
        Date lastMileDate = (dateFormat.parse("06/04/2020"));
        
        
        
        JLabel lblLastMile = new JLabel("Last Reported Mileage: " + lastMile);
        JLabel lblLastMileDate = new JLabel("Reported on: 06/04/2020"); 
		JLabel lblLastOilMile = new JLabel("Last Reported Oil Change Mileage: " + (lastOilMile));
        JLabel lblLastOilDate = new JLabel("Reported on: 04/29/2020");
        JLabel lblNextOilMile = new JLabel("Next Oil Change Mileage: " + String.valueOf(lastOilMile + 3000));
		JLabel lblNextOilDate = new JLabel("Suggested Next Oil Change Date: 10/26/2020");
        JButton btnAddMile = new JButton("Add Mileage");
        
        
        lblLastMile.setBounds(175, 200, 350, 20);
		lblLastMileDate.setBounds(175, 230, 350, 20);
        lblLastOilMile.setBounds(175, 260, 350, 20);
        lblLastOilDate.setBounds(175, 290, 350, 20);
		lblNextOilMile.setBounds(175, 320, 350, 20);
        lblNextOilDate.setBounds(175, 350, 350, 20);
        btnAddMile.setBounds(275, 380, 150, 30);
        
        panel3.add(lblLastMile);
		panel3.add(lblLastMileDate);
        panel3.add(lblLastOilMile);
        panel3.add(lblLastOilDate);
        panel3.add(lblNextOilMile);
        panel3.add(lblNextOilDate);
        panel3.add(btnAddMile);
        
        
        
        
// ******SETTINGS TAB******        
        JComponent panel4 = makeTextPanel("Panel #4");
        tabbedPane.addTab("Settings", icon, panel4, null);
        panel4.setBackground(new Color(r, g, b));
        panel4.setLayout(null);
        
        JLabel lblCarSelected4 = new JLabel("NAME, YEAR MAKE MODEL: CURRENT CAR");
        lblCarSelected4.setBounds(55, 15, 500, 14);
        panel4.add(lblCarSelected4);
        
        JButton btnExportMile = new JButton("Export Mileage");
        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");
        
        btnExportMile.setBounds(275, 200, 150, 30);
        btnLogout.setBounds(275, 300, 150, 30);
        btnExit.setBounds(275, 400 , 150, 30);
        
        panel4.add(btnExportMile);
        panel4.add(btnLogout);
        panel4.add(btnExit);
        
        panel0.setPreferredSize(new Dimension(x, y));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);
        
        
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
        java.net.URL imgURL = CarNerdMainPage.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private static void createAndShowGUI() throws ParseException {
        JFrame frame = new JFrame("CarNerd");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new CarNerdMainPage(), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try {
			createAndShowGUI();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
        });
    }
}
