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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCarPopup extends JPanel{
	public JTextField tfCarName = new JTextField();
	public JTextField tfCarTrim = new JTextField();
	public JTextField tfCarVIN = new JTextField("");
	public JTextField tfCarPlate = new JTextField("");
	public JButton btnUpdate = new JButton();
	public JLabel lblCarName = new JLabel("Name");
	public JLabel lblCarTrim = new JLabel("Trim");
	
	ArrayList<String> yearList = new ArrayList<String>();
	ArrayList<String> makeList = new ArrayList<String>();
	ArrayList<String> modelList = new ArrayList<String>();
	ArrayList<String> trimList = new ArrayList<String>();
	
	public JComboBox<String> cbCarYear = new JComboBox<String>();
	public JComboBox<String> cbCarMake = new JComboBox<String>();
	public JComboBox<String> cbCarModel = new JComboBox<String>();
	
	public JLabel lblCarVIN = new JLabel("VIN");
	public JLabel lblCarPlate = new JLabel("Plate");
	
	private static final long serialVersionUID = 1L;
	
	public AddCarPopup() { }
	
	AddCarPopup(String btnTxt, JPanel aPanel, JDialog aDialog) {
		AddCarMethods addCar = new AddCarMethods();
    	setBackground(new Color(191,136,255));

    	btnUpdate.setText(btnTxt);
    	
        lblCarName.setBounds(10, 10, 100, 30);
        lblCarTrim.setBounds(310, 20, 50, 30);
        lblCarVIN.setBounds(10, 100, 150, 30);
        lblCarPlate.setBounds(10, 140, 150, 30);
        
        cbCarYear.setBounds(10, 50, 70, 30);
        cbCarMake.setBounds(90, 50, 90, 30);
        cbCarModel.setBounds(190, 50, 110, 30);
        
        tfCarTrim.setBounds(310, 50, 90, 30);
        tfCarName.setBounds(75, 10, 100, 30);
        tfCarVIN.setBounds(75, 100, 150, 30);
        tfCarPlate.setBounds(75, 140, 150, 30);
        btnUpdate.setBounds(150, 190, 100, 30);

        aPanel.add(tfCarName);
		aPanel.add(tfCarVIN);
		aPanel.add(tfCarPlate);
        aPanel.add(lblCarName);
        aPanel.add(lblCarTrim);
        aPanel.add(cbCarYear);
        aPanel.add(cbCarMake);
        aPanel.add(cbCarModel);
        aPanel.add(tfCarTrim);
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
        /*
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
        */
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// ERROR HANDLING cannot have "," ANYWHERE in the car inputs.
				if (tfCarName.getText().contains(",") == true) {

					tfCarName.setText(tfCarName.getText().replaceAll(",", ""));
				}
				if (tfCarTrim.getText().contains(",") == true) {

					tfCarTrim.setText(tfCarTrim.getText().replaceAll(",", ""));
				}
				if (tfCarVIN.getText().contains(",") == true) {

					tfCarVIN.setText(tfCarVIN.getText().replaceAll(",", ""));
				}
				if (tfCarPlate.getText().contains(",") == true) {

					tfCarPlate.setText(tfCarPlate.getText().replaceAll(",", ""));
				}   
        
	        		addCar.addNewCar(tfCarName.getText(), cbCarYear.getSelectedItem().toString(), 
	        				cbCarMake.getSelectedItem().toString(), cbCarModel.getSelectedItem().toString(), 
	        				tfCarTrim.getText(), tfCarVIN.getText(), 
	        				tfCarPlate.getText());
	        	
	        	addCar.writeToFile();

	        	aDialog.dispose();

	        	MainUI.reload();
	    }});
	}

}