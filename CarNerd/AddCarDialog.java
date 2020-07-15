package CarNerd;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JTextField;

public class AddCarDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public JTextField tfCarName = new JTextField();
	public JTextField tfCarYear = new JTextField("");
	public JTextField tfCarMake = new JTextField("");
	public JTextField tfCarModel = new JTextField("");
	public JTextField tfCarTrim = new JTextField("");
	public JTextField tfCarVIN = new JTextField("");
	public JTextField tfCarPlate = new JTextField("");
	
	AddCarDialog() {}
	
	AddCarDialog(JDialog jd){
		jd.setPreferredSize(new Dimension(400, 400));
    	setBackground(new Color(191,136,255));

		
	}
	
}
