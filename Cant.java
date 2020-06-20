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

        JComponent panel5 = makeTextPanel("Panel #5");
        tabbedPane.addTab("Reminder", icon, panel5,
                "Still does nothing");
        //tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

        JComponent panel6 = makeTextPanel("Panel #6");
        tabbedPane.addTab("Documents", icon, panel6,
                "Still does nothing");
        //tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

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
