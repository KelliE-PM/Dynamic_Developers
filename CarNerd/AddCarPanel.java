package CarNerd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddCarPanel extends JPanel{
	public JTextField tfCarName = new JTextField();
	public JTextField tfCarYear = new JTextField("");
	public JTextField tfCarMake = new JTextField("");
	public JTextField tfCarModel = new JTextField("");
	public JTextField tfCarTrim = new JTextField("");
	public JTextField tfCarVIN = new JTextField("");
	public JTextField tfCarPlate = new JTextField("");
	public JButton btnUpdate = new JButton("Update");
	public JLabel lblCarName = new JLabel("Name");
	public JLabel lblCarYear = new JLabel("Year");
	public JLabel lblCarMake = new JLabel("Make");
	public JLabel lblCarModel = new JLabel("Model");
	public JLabel lblCarTrim = new JLabel("Trim");
	public JLabel lblCarVIN = new JLabel("VIN");
	public JLabel lblPlateNum = new JLabel("Plate");
	
	private static final long serialVersionUID = 1L;
	AddCarPanel(JPanel panel, JDialog dialog, JFrame mainFrame) {
// ****SIZE OF POPUP WINDOW******       
		int x = 400, y = 400;
        panel.setPreferredSize(new Dimension(x, y));
    	setBackground(new Color(191,136,255));
        
// TODO grab current label information
        
// TODO create a check to make sure you would like to edit the VIN
		
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
        tfCarPlate.setBounds(75, 250, 150, 30);
        btnUpdate.setBounds(150, 290, 100, 30);
        
        panel.add(tfCarName);
		panel.add(tfCarYear);
		panel.add(tfCarMake);
		panel.add(tfCarModel);
		panel.add(tfCarTrim);
		panel.add(tfCarVIN);
		panel.add(tfCarPlate);
		
        panel.add(lblCarName);
        panel.add(lblCarYear);
        panel.add(lblCarMake);
        panel.add(lblCarModel);
        panel.add(lblCarTrim);
        panel.add(lblCarVIN);
        panel.add(lblPlateNum);
        panel.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	AddCarMethods addCar = new AddCarMethods();
	        	MainUI mainUI = new MainUI();
	        	addCar.addNewCar(tfCarName.getText(), tfCarYear.getText(), tfCarMake.getText(), tfCarModel.getText(), tfCarTrim.getText(), tfCarVIN.getText(), tfCarPlate.getText());
	        	
	        	mainUI.setDropDown();
	        	
	        	dialog.dispose();
	        	//mainFrame.invalidate();
	        	//mainFrame.validate();
	        	//mainFrame.repaint();
	        	//SwingUtilities.updateComponentTreeUI(mainFrame);
	        	/*
	        	mainFrame.dispose();
	        	*/
	        	//try { CarNerdMainPage.createAndShowGUI(); } 
	            //catch (ParseException | FileNotFoundException e1) { e1.printStackTrace(); }
	        	
	        }
	    });
       
	}
}