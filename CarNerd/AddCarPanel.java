package CarNerd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCarPanel extends JPanel{
	public JTextField tfCarName = new JTextField();
	public JTextField tfCarYear = new JTextField("");
	public JTextField tfCarMake = new JTextField("");
	public JTextField tfCarModel = new JTextField("");
	public JTextField tfCarTrim = new JTextField("");
	public JTextField tfCarVIN = new JTextField("");
	public JTextField tfCarPlate = new JTextField("");
	public JButton btnUpdate = new JButton();
	public JLabel lblCarName = new JLabel("Name");
	public JLabel lblCarYear = new JLabel("Year");
	public JLabel lblCarMake = new JLabel("Make");
	public JLabel lblCarModel = new JLabel("Model");
	public JLabel lblCarTrim = new JLabel("Trim");
	public JLabel lblCarVIN = new JLabel("VIN");
	public JLabel lblCarPlate = new JLabel("Plate");
	
	private static final long serialVersionUID = 1L;
	AddCarPanel(String btnTxt, JPanel panel, JDialog dialog, String name, String year, String make, String model, String trim, String vin, String plate) {
// ****SIZE OF POPUP WINDOW******       
		int x = 400, y = 400;
        panel.setPreferredSize(new Dimension(x, y));
    	setBackground(new Color(191,136,255));

    	tfCarName.setText(name);
    	tfCarYear.setText(year);
    	tfCarMake.setText(make);
    	tfCarModel.setText(model);
    	tfCarTrim.setText(trim);
    	tfCarVIN.setText(vin);
    	tfCarPlate.setText(plate);
    	btnUpdate.setText(btnTxt);
    	
        lblCarName.setBounds(10, 10, 100, 30);
		lblCarYear.setBounds(10, 50, 100, 30);
        lblCarMake.setBounds(10, 90, 100, 30);
        lblCarModel.setBounds(10, 130, 100, 30);
		lblCarTrim.setBounds(10, 170, 100, 30);
        lblCarVIN.setBounds(10, 210, 150, 30);
        lblCarPlate.setBounds(10, 250, 150, 30);
        
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
        panel.add(lblCarPlate);
        panel.add(btnUpdate);
        


        btnUpdate.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	AddCarMethods addCar = new AddCarMethods();
	        	MainUI mainUI = new MainUI();
	        	String newVIN = vin;
	        	
		        // ERROR HANDLING cannot have "," ANYWHERE in the car inputs.
		        if (tfCarName.getText().contains(",") == true) { tfCarName.setText(tfCarName.getText().replaceAll(",", "")); }
		        if (tfCarYear.getText().contains(",") == true) { tfCarYear.setText(tfCarYear.getText().replaceAll(",", "")); }
		        if (tfCarMake.getText().contains(",") == true) { tfCarMake.setText(tfCarMake.getText().replaceAll(",", "")); }
		        if (tfCarModel.getText().contains(",") == true) { tfCarModel.setText(tfCarModel.getText().replaceAll(",", "")); }
		        if (tfCarTrim.getText().contains(",") == true) { tfCarTrim.setText(tfCarTrim.getText().replaceAll(",", "")); }
		        if (tfCarVIN.getText().contains(",") == true) { tfCarVIN.setText(tfCarVIN.getText().replaceAll(",", "")); }
		        if (tfCarPlate.getText().contains(",") == true) { tfCarPlate.setText(tfCarPlate.getText().replaceAll(",", "")); }	    
        
	        	if (vin.compareTo(tfCarVIN.getText()) != 0 && vin.compareTo("") != 0) {
	        		int result = JOptionPane.showConfirmDialog(panel,"Are you sure you want to change the VIN?", "Change VIN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION){ 
		            	newVIN = tfCarVIN.getText();
		            	JOptionPane.showMessageDialog(null, tfCarName.getText() + "'s VIN has been changed.");
		            }
					else if (result == JOptionPane.NO_OPTION){ }
	        	}
				addCar.addNewCar(tfCarName.getText(), tfCarYear.getText(), tfCarMake.getText(), tfCarModel.getText(), tfCarTrim.getText(), newVIN, tfCarPlate.getText());
	        	mainUI.setDropDown();
	        	try { addCar.writeToFile(); } 
	        	catch (IOException e2) { e2.printStackTrace(); }
	        	dialog.dispose();
	        	//mainFrame.invalidate();
	        	//mainFrame.validate();
	        	//mainFrame.repaint();
	        	//SwingUtilities.updateComponentTreeUI(mainFrame);
	        	//NerdList.listCars = null;
	        	MainUI.mainFrame.dispose();
	        	
	        	try { CarNerdMainPage.createAndShowGUI(); } 
	            catch (ParseException | IOException e1) { e1.printStackTrace(); }
// TODO popup that car has been loaded
	    }});
	}
}
