package CarNerd;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JFrame;

public class NEW_POPUP_WINDOW_NAME {
	public NEW_POPUP_WINDOW_NAME(JFrame frame) throws ParseException {
		// ****SIZE OF POPUP WINDOW******       
		int x = 400, y = 400;
		frame.setPreferredSize(new Dimension(x, y));

        int r = 191, g = 136, b = 255;
		frame.getContentPane().setBackground(new Color(r, g, b));
		        
	}
}