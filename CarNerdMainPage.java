package CarNerd;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;

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
        
        CarUI.selectCar(panel0);
        CarUI.loadCarInfo(panel0);
        CarUI.loadNotes(panel0);
        CarUI.loadSettings(panel0);
        CarUI.loadMileage(panel0);
        
        panel0.setPreferredSize(new Dimension(x, y));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        
/*        
// ******INFO TAB****** - ALYSSA
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Info", null, panel1, null);
        panel1.setBackground(new Color(r, g, b));
        panel1.setLayout(null);
        
        
        
        
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_1);

        // pretend code UI for alert
        // TODO call delete
        // pretend code "This is where the note would be deleted."
// ******LOG TAB******
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Log", null, panel2, null);
        panel2.setLayout(null);
        panel2.setBackground(new Color(r, g, b));
        
        
		
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_2);  
		
// ******MILEAGE TAB******        
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Mileage", icon, panel3, null);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);      
        panel3.setBackground(new Color(r, g, b));
        panel3.setLayout(null);
        
        
// ******SETTINGS TAB******        
        JComponent panel4 = makeTextPanel("Panel #4");
        tabbedPane.addTab("Settings", icon, panel4, null);
        panel4.setBackground(new Color(r, g, b));
        panel4.setLayout(null);
        
       
        
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);
        
// ******EXTRA TAB - FOR DEVELOPMENT******
 
        JComponent panel6 = makeTextPanel("Panel #4");
        tabbedPane.addTab("Settings", icon, panel6, null);
        
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);
        
   
// ******APPLIES TO ENTIRE WINDOW******
*/
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
