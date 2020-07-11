package CarNerd;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.text.ParseException;

@SuppressWarnings("serial")
public class CarNerdMainPage extends JPanel {
    public CarNerdMainPage(JFrame mainFrame) throws ParseException, FileNotFoundException {
    	
// ****SIZE OF MAIN WINDOW******       
        int x = 750, y = 750;
        mainFrame.setPreferredSize(new Dimension(x, y));
        
// ******CAR TAB******
        int r = 191, g = 136, b = 255;
        mainFrame.getContentPane().setBackground(new Color(r, g, b));
        mainFrame.setLayout(null);
        MainUI MainUI = new MainUI();
        
        MainUI.selectCar(mainFrame);	
        MainUI.loadCarInfo(mainFrame);
        MainUI.loadNotes(mainFrame);
        MainUI.loadSettings(mainFrame);
        MainUI.loadMileage(mainFrame); 
    }

    private static void createAndShowGUI(String text) throws ParseException, FileNotFoundException {
        JFrame frame = new JFrame(text);

// TODO We may be able to set save state here
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CarNerdMainPage(frame), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try { createAndShowGUI("Car-Nerd"); } 
        catch (ParseException | FileNotFoundException e) { e.printStackTrace(); }
            }
        });
    }
}
