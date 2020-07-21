
package CarNerd;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;

public class MainUI {
	static JFrame mainFrame;
	public JFrame makeFrame() {
	
		mainFrame = new JFrame();

		return mainFrame;
	}
	
	public static void reload() {
		mainFrame.dispose();
    	
    	try { CarNerdMainPage.createAndShowGUI(); } 
        catch (ParseException | IOException e1) { e1.printStackTrace(); }
    	
	}
}