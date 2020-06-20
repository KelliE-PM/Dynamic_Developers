package car_nerds_ui_stage1;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
 
public class test extends JPanel {
	private JTextField txtTitle;
	private JTextField txtEvent;
	private JTextField txtRemindDate;
    public test() {
        super(new GridLayout(1, 6));
         
        JTabbedPane tabbedPane = new JTabbedPane();
//        ImageIcon icon = createImageIcon("");
//         
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Car", null, panel1,
                "Does nothing");
        panel1.setPreferredSize(new Dimension(1000,1000));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Info", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Log", null, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_3);
         
        JComponent panel4 = makeTextPanel("Panel 4");
        tabbedPane.addTab("Mileage", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_4);
         
        JComponent panel5 = makeTextPanel("Panel #5");
        tabbedPane.addTab("Reminder", null, panel5,
                "Still does nothing");
        tabbedPane.setMnemonicAt(6, KeyEvent.VK_5);
        
        JComponent panel6 = makeTextPanel("Panel #6");
        tabbedPane.addTab("Documents", null, panel6,
                "Still does nothing");
        tabbedPane.setMnemonicAt(7, KeyEvent.VK_6);
        
        JComponent panel7 = makeTextPanel("Panel #7");
        tabbedPane.addTab("Settings", null, panel7,
                "Still does nothing");
        tabbedPane.setMnemonicAt(8, KeyEvent.VK_7);
        
        JComponent panel8 = makeTextPanel("Panel #8");
        tabbedPane.addTab("Quit", null, panel8,
                "Still does nothing");
        tabbedPane.setMnemonicAt(9, KeyEvent.VK_8);
        

        add(tabbedPane);
         

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        Panel panel = new Panel();
        tabbedPane.addTab("Log", null, panel, null);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("NAME:");
        lblNewLabel.setBounds(24, 11, 46, 14);
        panel.add(lblNewLabel);
        
        JLabel lblMake = new JLabel("MAKE:");
        lblMake.setBounds(107, 11, 46, 14);
        panel.add(lblMake);
        
        JLabel lblModel = new JLabel("MODEL:");
        lblModel.setBounds(203, 11, 46, 14);
        panel.add(lblModel);
        
        JLabel lblYear = new JLabel("YEAR:");
        lblYear.setBounds(292, 11, 46, 14);
        panel.add(lblYear);
        
        JLabel lblTrim = new JLabel("TRIM:");
        lblTrim.setBounds(373, 11, 46, 14);
        panel.add(lblTrim);
        
        JTextArea txtrEnterTextHere = new JTextArea();
        txtrEnterTextHere.setText("Enter text here");
        txtrEnterTextHere.setBounds(91, 72, 231, 107);
        panel.add(txtrEnterTextHere);
        
        txtTitle = new JTextField();
        txtTitle.setText("Title");
        txtTitle.setBounds(34, 41, 86, 20);
        panel.add(txtTitle);
        txtTitle.setColumns(10);
        
        txtEvent = new JTextField();
        txtEvent.setText("Event");
        txtEvent.setColumns(10);
        txtEvent.setBounds(157, 41, 86, 20);
        panel.add(txtEvent);
        
        txtRemindDate = new JTextField();
        txtRemindDate.setText("Remind Date");
        txtRemindDate.setColumns(10);
        txtRemindDate.setBounds(289, 41, 86, 20);
        panel.add(txtRemindDate);
        
        JButton btnNewButton = new JButton("SAVE");
        btnNewButton.setBounds(91, 190, 89, 23);
        panel.add(btnNewButton);
        
        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(233, 190, 89, 23);
        panel.add(btnCancel);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
     

//    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = test.class.getResource(path);
//        if (imgURL != null) {
//            return new ImageIcon(imgURL);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
//    }
     

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CarNerd");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         

        frame.getContentPane().add(new test(), BorderLayout.CENTER);
         

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
