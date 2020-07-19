package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainCarInfo {
	
	JComboBox<String> cbChooseCar = new JComboBox<String>();
	AddCarMethods addCar = new AddCarMethods();
// ******************** THE CAR INSTANCIATION ********************
// theCar is the selected car and should be used throughout the program to pull the currently selected car
	static Car theCar = new Car();
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

						theCar = NerdList.listCars.get(a);
					}
				}

				setCarInfo(theCar.getName(), theCar.getYear(), theCar.getMake(), theCar.getModel(), theCar.getTrim(),
						theCar.getVIN(), theCar.getPlate());

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
				aPanel.add(new AddCarPanel("Add", aPanel, aDialog, "", "", "", "", "", "", ""));

				aDialog.add(aPanel);
				aDialog.setVisible(true);
			}
		});

// ******************** DELETE CAR ********************	    
		mainFrame.add(btnDeleteCar);

		btnDeleteCar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteCar = theCar.getName();

				int result = JOptionPane.showConfirmDialog(mainFrame,
						"Are you sure you would like to delete ?" + deleteCar, "Delete Car", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					addCar.deleteCar(deleteCar);
					JOptionPane.showMessageDialog(null, deleteCar + " as been deleted.");
				}

				else if (result == JOptionPane.NO_OPTION) {
				}
			}
		});
	}
	public void setDropDown(JFrame mainFrame) {
		mainFrame.remove(cbChooseCar);

		for (int rf = 0; rf < NerdList.listCars.size(); rf++) {

			cbChooseCar.addItem(NerdList.listCars.get(rf).getName());
// TODO **FOR DEBUGGING PURPOSES.  PLEASE REMOVE BEFORE SUBMITTING	    	
			System.out.println(NerdList.listCars.get(rf).getName());
		}
		if (lblCarName != null) {
			lblCarName.setText("Testing Updating Abilities");
		}

		mainFrame.add(cbChooseCar);

		SwingUtilities.updateComponentTreeUI(mainFrame);
	}

//TODO find a better way to pass this many arguments.  Map maybe? 
	public void setCarInfo(String name, String year, String make, String model, String trim, String vin, String plate) {
		// changes the labels to the currently selected car
		lblCarName.setText(name);
		lblCarYear.setText(year);
		lblCarMake.setText(make);
		lblCarModel.setText(model);
		lblCarTrim.setText(trim);
		lblCarVIN.setText("VIN: " + vin);
		lblPlateNum.setText("Plate: " + plate);
	}

// TODO take out unnecessary arguments
	public void loadCarInfo(JFrame mainFrame, String name, String year, String make, String model, String trim, String vin,
			String plate) {
		// initial car information loading
		lblCarName = new JLabel();
		lblCarYear = new JLabel();
		lblCarMake = new JLabel();
		lblCarModel = new JLabel();
		lblCarTrim = new JLabel();
		lblCarVIN = new JLabel("VIN: ");
		lblPlateNum = new JLabel("Plate: ");
		JButton btnEdit = new JButton("Edit");

		lblCarName.setBounds(180, 10, 100, 20);
		lblCarYear.setBounds(180, 40, 100, 20);
		lblCarMake.setBounds(250, 40, 100, 20);
		lblCarModel.setBounds(350, 40, 100, 20);
		lblCarTrim.setBounds(450, 40, 100, 20);
		lblCarVIN.setBounds(200, 70, 150, 20);
		lblPlateNum.setBounds(350, 70, 150, 20);
		btnEdit.setBounds(550, 40, 100, 30);

		mainFrame.add(lblCarName);
		mainFrame.add(lblCarYear);
		mainFrame.add(lblCarMake);
		mainFrame.add(lblCarModel);
		mainFrame.add(lblCarTrim);
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
				panel.add(new AddCarPanel("Edit", panel, dialog, theCar.getName(), theCar.getYear(), theCar.getMake(),
						theCar.getModel(), theCar.getTrim(), theCar.getVIN(), theCar.getPlate()));

				dialog.add(panel);
				dialog.setVisible(true);
			}

		});

	}

}
