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
import java.util.ArrayList;


public class CarNerdMainPage extends JPanel {
	static AddCarMethods addCar = new AddCarMethods();
	static MainUI mainUI = new MainUI();
	
	private static final long serialVersionUID = 1L;
	public CarNerdMainPage() {}
	public CarNerdMainPage(JFrame mainFrame) throws ParseException, FileNotFoundException {
    	
// ****SIZE OF MAIN WINDOW******       
        int x = 750, y = 750;
        mainFrame.setPreferredSize(new Dimension(x, y));
        
// ******CAR TAB******
        int r = 191, g = 136, b = 255;
        mainFrame.getContentPane().setBackground(new Color(r, g, b));
        mainFrame.setLayout(null);
        createMainFrame(mainFrame);
    }

    public static void createAndShowGUI() throws ParseException, FileNotFoundException {
    	
        //JFrame mainFrame = new JFrame();
    	JFrame mainFrame = mainUI.makeFrame();

// TODO We may be able to set save state here
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add(new CarNerdMainPage(mainFrame), BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public static void createMainFrame(JFrame mainFrame) throws FileNotFoundException, ParseException {
    	MainUI MainUI = new MainUI();
    	MainUI.selectCar();
        MainUI.loadCarInfo("", "", "", "", "", "", "");
        MainUI.loadNotes();
        MainUI.loadSettings();
        //MainUI.loadMileage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try { createAndShowGUI(); } 
        catch (ParseException | FileNotFoundException e) { e.printStackTrace(); }
            }
        });
    }
}