package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainCarInfo {
	
	JComboBox<String> cbChooseCar = new JComboBox<String>();
	AddCarMethods addCar = new AddCarMethods();
// ******************** THE CAR INSTANCIATION ********************
// NerdList.theCar is the selected car and should be used throughout the program to pull the currently selected car
	//static Car NerdList.theCar = new Car();
	JLabel lblCarName, lblCarYear, lblCarMake, lblCarModel, lblCarTrim, lblCarVIN, lblPlateNum;	
	

	public void selectCar(JFrame mainFrame) throws ParseException, IOException {
		JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");

		btnAddCar.setBounds(10, 40, 100, 30);
		btnDeleteCar.setBounds(10, 80, 100, 30);
		cbChooseCar.setBounds(10, 10, 150, 20);

// ******************** SELECT CAR ********************
		AddCarMethods addCar = new AddCarMethods();

		addCar.readFile();

		setDropDown(mainFrame);

		cbChooseCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//TODO change notes, mileage to selection
				String selectedCar = cbChooseCar.getSelectedItem().toString();
				
				for (int a = 0; a < NerdList.listCars.size(); a++) {

					if (NerdList.listCars.get(a).getName().compareTo(selectedCar) == 0) {

						NerdList.theCar = NerdList.listCars.get(a);
						break;
					}
				}
				
				//setCarInfo(NerdList.theCar.getName(), NerdList.theCar.getYear(), NerdList.theCar.getMake(), NerdList.theCar.getModel(), NerdList.theCar.getTrim(),
						//NerdList.theCar.getVIN(), NerdList.theCar.getPlate());
				MainUI.reload();
				cbChooseCar.setSelectedItem(NerdList.theCar.getName());
				SwingUtilities.updateComponentTreeUI(mainFrame);
			}
		});

// ******************** ADD CAR ********************   
		mainFrame.add(btnAddCar);

		btnAddCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JDialog aDialog = new JDialog(mainFrame, "Click a button", true);
				aDialog.setSize(400, 400);

				JPanel aPanel = new JPanel(new BorderLayout());
				aPanel.add(new AddCarPopup("Add", aPanel, aDialog, "", "", "", "", "", "", ""));

				aDialog.add(aPanel);
				aDialog.setVisible(true);
			}
		});

// ******************** DELETE CAR ********************	    
		mainFrame.add(btnDeleteCar);

		btnDeleteCar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteCar = NerdList.theCar.getName();

				int result = JOptionPane.showConfirmDialog(mainFrame,
						"Are you sure you would like to delete " + deleteCar + "?", "Delete Car", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					try {
						addCar.deleteCar(deleteCar);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, deleteCar + " as been deleted.");
					
					MainUI.reload();
				}

				else if (result == JOptionPane.NO_OPTION) {
				}
			}
		});
	}
	public void setDropDown(JFrame mainFrame) {
		//mainFrame.remove(cbChooseCar);
		cbChooseCar.addItem("Select Car");
		for (int rf = 0; rf < NerdList.listCars.size(); rf++) {

			cbChooseCar.addItem(NerdList.listCars.get(rf).getName());
		}

		mainFrame.add(cbChooseCar);

		SwingUtilities.updateComponentTreeUI(mainFrame);
	}

	public void setCarInfo(String name, String year, String make, String model, String trim, String vin, String plate) {
		// changes the labels to the currently selected car
		lblCarName.setText(name);
		lblCarYear.setText(year + " " +  make + " " +  model + " " +  trim);
		lblCarVIN.setText("VIN: " + vin);
		lblPlateNum.setText("Plate: " + plate);
	}

	public void loadCarInfo(JFrame mainFrame) {
		// initial car information loading
		String ymmtLabelText = NerdList.theCar.getYear()+ " " + NerdList.theCar.getMake()+ " " + NerdList.theCar.getModel()+ " " + NerdList.theCar.getTrim();
		String vinLabelText = NerdList.theCar.getVIN() + " ";
		String plateLabelText = NerdList.theCar.getPlate() + " ";
		
		ymmtLabelText = ymmtLabelText.equals("null null null null") ? "" : ymmtLabelText;
		vinLabelText = vinLabelText.equals("null ") ? "" : vinLabelText;
		plateLabelText = plateLabelText.equals("null ") ? "" : plateLabelText;
		
		lblCarName = new JLabel(NerdList.theCar.getName());
		lblCarYear = new JLabel(ymmtLabelText);
		lblCarVIN = new JLabel("VIN: " + vinLabelText);
		lblPlateNum = new JLabel("Plate: " + plateLabelText);
		JButton btnEdit = new JButton("Edit");

		lblCarName.setBounds(200, 10, 600, 20);
		lblCarYear.setBounds(200, 40, 600, 20);
		//lblCarMake.setBounds(250, 40, 100, 20);
		//lblCarModel.setBounds(350, 40, 100, 20);
		//lblCarTrim.setBounds(450, 40, 100, 20);
		lblCarVIN.setBounds(200, 70, 150, 20);
		lblPlateNum.setBounds(400, 70, 150, 20);
		btnEdit.setBounds(550, 40, 100, 30);

		mainFrame.add(lblCarName);
		mainFrame.add(lblCarYear);
		//mainFrame.add(lblCarMake);
		//mainFrame.add(lblCarModel);
		//mainFrame.add(lblCarTrim);
		mainFrame.add(lblCarVIN);
		mainFrame.add(lblPlateNum);
		mainFrame.add(btnEdit);
// ******************** EDIT CAR ********************
// onclick listener - reacts to the EDIT button being pressed
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				final JDialog dialog = new JDialog(mainFrame, "Click a button", true);

				dialog.setSize(400, 400);

				JPanel panel = new JPanel(new BorderLayout());
				panel.add(new AddCarPopup("Edit", panel, dialog, NerdList.theCar.getName(), NerdList.theCar.getYear(), NerdList.theCar.getMake(),
						NerdList.theCar.getModel(), NerdList.theCar.getTrim(), NerdList.theCar.getVIN(), NerdList.theCar.getPlate()));

				dialog.add(panel);
				dialog.setVisible(true);
			}

		});

	}

}
