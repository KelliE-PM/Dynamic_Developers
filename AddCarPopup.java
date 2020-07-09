

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCarPopup extends JPanel {
	private static final long serialVersionUID = 1L;

	public AddCarPopup(JFrame frame) throws ParseException {
        

// ****SIZE OF POPUP WINDOW******       
        int x = 400, y = 400;
        frame.setPreferredSize(new Dimension(x, y));

        int r = 191, g = 136, b = 255;
        frame.getContentPane().setBackground(new Color(r, g, b));
        
// TODO grab current label information
        JTextField tfCarName = new JTextField("");
        JTextField tfCarYear = new JTextField("");
        JTextField tfCarMake = new JTextField("");
        JTextField tfCarModel = new JTextField("");
        JTextField tfCarTrim = new JTextField("");
//TODO create a check to make sure you would like to edit the VIN
        JTextField tfCarVIN = new JTextField("");
        JTextField tfPlateNum = new JTextField("");
        JButton btnUpdate = new JButton("");
        
        JLabel lblCarName = new JLabel("Name");
        JLabel lblCarYear = new JLabel("Year");
        JLabel lblCarMake = new JLabel("Make");
        JLabel lblCarModel = new JLabel("Model");
        JLabel lblCarTrim = new JLabel("Trim");
        JLabel lblCarVIN = new JLabel("VIN");
        JLabel lblPlateNum = new JLabel("Plate");
        
        lblCarName.setBounds(10, 10, 100, 30);
		lblCarYear.setBounds(10, 50, 100, 30);
        lblCarMake.setBounds(10, 90, 100, 30);
        lblCarModel.setBounds(10, 130, 100, 30);
		lblCarTrim.setBounds(10, 170, 100, 30);
        lblCarVIN.setBounds(10, 210, 150, 30);
        lblPlateNum.setBounds(10, 250, 150, 30);
        
        tfCarName.setBounds(75, 10, 100, 30);
		tfCarYear.setBounds(75, 50, 100, 30);
        tfCarMake.setBounds(75, 90, 100, 30);
        tfCarModel.setBounds(75, 130, 100, 30);
		tfCarTrim.setBounds(75, 170, 100, 30);
        tfCarVIN.setBounds(75, 210, 150, 30);
        tfPlateNum.setBounds(75, 250, 150, 30);
        btnUpdate.setBounds(150, 290, 100, 30);
        
         frame.add(tfCarName);
		frame.add(tfCarYear);
        frame.add(tfCarMake);
        frame.add(tfCarModel);
        frame.add(tfCarTrim);
        frame.add(tfCarVIN);
        frame.add(tfPlateNum);
        frame.add(btnUpdate);
//TODO create an onclick listener and update information
        
        frame.add(lblCarName);
		frame.add(lblCarYear);
        frame.add(lblCarMake);
        frame.add(lblCarModel);
        frame.add(lblCarTrim);
        frame.add(lblCarVIN);
        frame.add(lblPlateNum);
    }
}




