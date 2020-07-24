package CarNerd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCarPopup extends JPanel{
	public JTextField tfCarName = new JTextField();
	public JTextField tfCarVIN = new JTextField("");
	public JTextField tfCarPlate = new JTextField("");
	public JButton btnUpdate = new JButton();
	public JLabel lblCarName = new JLabel("Name");
	
	ArrayList<String> yearList = new ArrayList<String>();
	ArrayList<String> makeList = new ArrayList<String>();
	ArrayList<String> modelList = new ArrayList<String>();
	ArrayList<String> trimList = new ArrayList<String>();
	
	public JComboBox<String> cbCarYear = new JComboBox<String>();
	public JComboBox<String> cbCarMake = new JComboBox<String>();
	public JComboBox<String> cbCarModel = new JComboBox<String>();
	public JComboBox<String> cbCarTrim = new JComboBox<String>();
	
	public JLabel lblCarVIN = new JLabel("VIN");
	public JLabel lblCarPlate = new JLabel("Plate");
	
	private static final long serialVersionUID = 1L;
	
	public AddCarPopup() { }
	
	AddCarPopup(String btnTxt, JPanel aPanel, JDialog aDialog, String name, String year, String make, String model, String trim, String vin, String plate) {
		AddCarMethods addCar = new AddCarMethods();
    	setBackground(new Color(191,136,255));

    	tfCarName.setText(name);
    	cbCarYear.setSelectedItem(year);
    	cbCarMake.setSelectedItem(make);
    	cbCarModel.setSelectedItem(model);
    	cbCarTrim.setSelectedItem(trim);
    	tfCarVIN.setText(vin);
    	tfCarPlate.setText(plate);
    	btnUpdate.setText(btnTxt);
    	
        lblCarName.setBounds(10, 10, 100, 30);
        cbCarYear.setBounds(10, 50, 70, 30);
        cbCarMake.setBounds(90, 50, 90, 30);
        cbCarModel.setBounds(190, 50, 110, 30);
        cbCarTrim.setBounds(310, 50, 90, 30);
        
        lblCarVIN.setBounds(10, 100, 150, 30);
        lblCarPlate.setBounds(10, 140, 150, 30);
        
        tfCarName.setBounds(75, 10, 100, 30);
        tfCarVIN.setBounds(75, 100, 150, 30);
        tfCarPlate.setBounds(75, 140, 150, 30);
        btnUpdate.setBounds(150, 190, 100, 30);

        aPanel.add(tfCarName);
		aPanel.add(tfCarVIN);
		aPanel.add(tfCarPlate);
        aPanel.add(lblCarName);
        aPanel.add(cbCarYear);
        aPanel.add(cbCarMake);
        aPanel.add(cbCarModel);
        aPanel.add(cbCarTrim);
        aPanel.add(lblCarVIN);
        aPanel.add(lblCarPlate);
        aPanel.add(btnUpdate);
        
        cbCarYear.addItem("Select");
		//set 25 years of car years
		//TODO fix it that 2020 is a variable that is this year.
        for (int y = 0; y < 25; y++) {
    		cbCarYear.addItem(Integer.toString(2020 - y));
    	}
        
		cbCarYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbCarMake.removeAllItems();
				
				cbCarMake.addItem("Select");
				
				if (cbCarYear.getSelectedItem() != null && !cbCarYear.getSelectedItem().equals("Select")) {
					try {
						makeList = addCar.readCarMake(cbCarYear.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					for (int mk = 0; mk < makeList.size(); mk++) {
						cbCarMake.addItem(makeList.get(mk).toString());
					}
				}
			}

		});
        
        cbCarMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbCarModel.removeAllItems();
				
				cbCarModel.addItem("Select");
				
				if (cbCarMake.getSelectedItem() != null && !cbCarMake.getSelectedItem().equals("Select")) {
					try {
						modelList = addCar.readCarModel(cbCarMake.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					for (int md = 0; md < modelList.size(); md++) {
						cbCarModel.addItem(modelList.get(md).toString());
					}
				}
			}
		});
        
		cbCarModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbCarTrim.removeAllItems();

				cbCarTrim.addItem("Select");

				if (cbCarModel.getSelectedItem() != null && !cbCarModel.getSelectedItem().equals("Select")) {
					try {
						trimList = addCar.readCarTrim(cbCarModel.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					for (int md = 0; md < trimList.size(); md++) {
						cbCarTrim.addItem(trimList.get(md).toString());
					}
				}
			}
		});
        
        btnUpdate.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	String newVIN = vin;
	        	
		        // ERROR HANDLING cannot have "," ANYWHERE in the car inputs.
		        if (tfCarName.getText().contains(",") == true) { 
		        	
		        	tfCarName.setText(tfCarName.getText().replaceAll(",", "")); 
		        	}

		        if (tfCarVIN.getText().contains(",") == true) { 
		        	
		        	tfCarVIN.setText(tfCarVIN.getText().replaceAll(",", "")); 
		        	}
		        if (tfCarPlate.getText().contains(",") == true) { 
		        	
		        	tfCarPlate.setText(tfCarPlate.getText().replaceAll(",", "")); 
		        	}	    
        
	        	if (btnTxt == "Edit" && vin.compareTo(tfCarVIN.getText()) != 0) {

	        		int result = JOptionPane.showConfirmDialog(aPanel,"Are you sure you want to change the VIN?", "Change VIN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		            if(result == JOptionPane.YES_OPTION){ 
		            	newVIN = tfCarVIN.getText();
		            	JOptionPane.showMessageDialog(null, tfCarName.getText() + "'s VIN has been changed.");
		            }
					else if (result == JOptionPane.NO_OPTION){ }
	        	}
	        	if (btnTxt == "Add") {
	        		addCar.addNewCar(tfCarName.getText(), cbCarYear.getSelectedItem().toString(), 
	        				cbCarMake.getSelectedItem().toString(), cbCarModel.getSelectedItem().toString(), 
	        				cbCarTrim.getSelectedItem().toString(), tfCarVIN.getText(), 
	        				tfCarPlate.getText());
	        	}
	        	else if(btnTxt =="Edit") {
	        		addCar.editCar(name, tfCarName.getText(), cbCarYear.getSelectedItem().toString(), 
	        				cbCarMake.getSelectedItem().toString(), cbCarModel.getSelectedItem().toString(), 
	        				cbCarTrim.getSelectedItem().toString(), newVIN, tfCarPlate.getText());
	        	}
	        	addCar.writeToFile();

	        	aDialog.dispose();

	        	MainUI.reload();
// TODO popup that car has been loaded
	    }});
	}

}