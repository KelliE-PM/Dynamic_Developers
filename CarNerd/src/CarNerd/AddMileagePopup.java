package CarNerd;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AddMileagePopup extends JPanel {

	private static final long serialVersionUID = 1L;

	// Dates
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

	// Create fields
	String saveDateSS;
	String changeDateSS;
	String saveChangeDateSS;
	String currentDateSS;

	String saveChangeDateS;
	String currentDateS;
	String saveNextChangeDateS;
	String setDateS;
	String setDateSS;

	static String changeDateS;
	static String nextChangeDateS;
	static String setMileS;
	static String lastDateS;
	static String lastDateSS;

	LocalDate saveDate;
	LocalDate saveChangeDate;
	LocalDate currentDate;
	LocalDate nextChangeDate;
	LocalDate saveNextChangeDate;

	static LocalDate lastDate;
	static LocalDate setDate;
	static LocalDate changeDate;

	String saveDateS;
	String changeMilesS;
	String syn;
	String saveSyn;
	String due;

	static int changeMiles;
	static int nextChangeMiles;
	static int setMile;
	static int lastMiles;

	int saveChange;
	int saveNextChange;
	int currentMiles;
	int saveMiles;
	int milesLeft;
	int saveLeft;
	int mile;

	boolean change;
	boolean synthetic;
	boolean lastSyn;

	AddMileagePopup(JPanel mPanel, JDialog mDialog) throws IOException {
		// Update Data
		int latestListMileEntry = NerdList.listMiles.size() - 1;
		lastMiles = NerdList.listMiles.get(latestListMileEntry).getCurrentMiles();
		lastDateSS = NerdList.listMiles.get(latestListMileEntry).getCurrentDate();

		int latestListChangeEntry = NerdList.listChange.size() - 1;
		changeMiles = NerdList.listChange.get(latestListChangeEntry).getChangeMiles();
		changeDateSS = NerdList.listChange.get(latestListChangeEntry).getChangeDate();
		nextChangeMiles = NerdList.listChange.get(latestListChangeEntry).getNextChangeMiles();
		nextChangeDateS = NerdList.listChange.get(latestListChangeEntry).getNextChangeDate();
		lastSyn = NerdList.listChange.get(latestListChangeEntry).getSynthetic();
		currentDateSS = lastDateSS;
		currentMiles = lastMiles;
		
		/*Old sample data
		lastDateSS = "12/31/2020";
		changeDateSS = "12/12/2020";
		currentDateSS = "1/31/2021";
		lastMiles = 564378;
		currentMiles = 564390;
		changeMiles = 562934;
		lastSyn = false;
    	*/

		// Create strings to dates to calculate
		// Error on this line when trying to run the pop up a second time.

		lastDate = LocalDate.parse(lastDateSS, formatter);
		changeDate = LocalDate.parse(changeDateSS, formatter);
		currentDate = LocalDate.parse(currentDateSS, formatter);

		// Convert back to strings to output
		lastDateS = lastDate.format(formatter);
		changeDateS = changeDate.format(formatter);
		currentDateS = currentDate.format(formatter);

		if (lastSyn) {
			nextChangeMiles = changeMiles + 5000;
			nextChangeDate = changeDate.plusMonths(9);
			syn = "synthetic";
		} else {
			nextChangeMiles = changeMiles + 3000;
			nextChangeDate = changeDate.plusMonths(6);
			syn = "regular";
		}

		nextChangeDateS = nextChangeDate.format(formatter);
		milesLeft = nextChangeMiles - currentMiles;

		// Oil change booleans
		change = false;
		syn = synthetic ? "synthetic" : "regular";

		// Backup info
		saveMiles = lastMiles;
		saveDate = lastDate;
		saveDateS = saveDate.format(formatter);
		saveChange = changeMiles;
		saveChangeDate = changeDate;
		saveChangeDateS = saveChangeDate.format(formatter);
		saveNextChange = nextChangeMiles;
		saveNextChangeDate = nextChangeDate;
		saveNextChangeDateS = nextChangeDate.format(formatter);
		saveSyn = syn;
		saveLeft = milesLeft;

		// Message at bottom (can change)
		due ="<html>&emsp;&emsp;&emsp;&emsp; In <b>" + milesLeft + "</b> miles or by " + nextChangeDateS + "</html>";
		if (currentMiles > nextChangeMiles || currentDate.compareTo(nextChangeDate) >= 1) {due = "             You are past due for an oil change";}

		//****************************PANEL SETTING*********************************************
		mPanel.setPreferredSize(new Dimension(360, 190));
		setBounds(100, 100, 360, 180);
		setBackground(new Color(191,136,255));

		JTextField newMileageTextField = new JTextField();
		JTextField newDateTextField = new JTextField();

		JCheckBox oilChangeCheckbox = new JCheckBox("Oil Change?");
		JCheckBox syntheticOilCheckbox = new JCheckBox("Synthetic oil?");

		JButton updateButton = new JButton("Update");
		JButton saveAndExitButton = new JButton("   Save   ");
		JButton resetButton = new JButton("Reset");

		JLabel messageLabel = new JLabel(due);
		JLabel lastChangeLabel = new JLabel("            Last oil change was on " + changeDateSS + " with " + syn + " oil");
		JLabel dateLabel = new JLabel(" DATE: ");
		JLabel newMileageLabel = new JLabel("ENTER NEW MILEAGE:  ");
		JLabel nextChangeLabel = new JLabel("             Next oil change at " + nextChangeMiles + " miles    ");



		lastChangeLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));

		mPanel.add(newMileageTextField);
		mPanel.add(newDateTextField);
		mPanel.add(oilChangeCheckbox);
		mPanel.add(syntheticOilCheckbox);
		mPanel.add(nextChangeLabel);
		mPanel.add(updateButton);
		mPanel.add(saveAndExitButton);
		mPanel.add(messageLabel);
		mPanel.add(resetButton);
		mPanel.add(lastChangeLabel);
		mPanel.add(dateLabel);
		mPanel.add(newMileageLabel);

		newMileageLabel.setBounds(12, 15, 140, 14);
		newMileageTextField.setBounds(148, 12, 58, 20);
		dateLabel.setBounds(216, 15, 70, 14);
		newDateTextField.setBounds(260, 12, 69, 20);
		lastChangeLabel.setBounds(12, 33, 289, 20);
		oilChangeCheckbox.setBounds(43, 54, 100, 23);
		syntheticOilCheckbox.setBounds(136, 54, 110, 23);
		updateButton.setBounds(250, 54, 79, 23);
		nextChangeLabel.setBounds(12, 90, 240, 14);
		resetButton.setBounds(250, 81, 79, 23);
		messageLabel.setBounds(12, 108, 240, 14);
		saveAndExitButton.setBounds(250, 108, 79, 23);

		newMileageTextField.setText(String.valueOf(lastMiles));
		newDateTextField.setText(lastDateS);

		if (lastDateSS.equals(NerdList.DEFAULT_DATE)) {
			newMileageTextField.setText("");
			newDateTextField.setText("M/D/YYYY");
			lastChangeLabel.setText("");
			nextChangeLabel.setText("");
			messageLabel.setText("");
		}
		if (changeDateS.equals(NerdList.DEFAULT_DATE)) {
			lastChangeLabel.setText("");
			nextChangeLabel.setText("");
			messageLabel.setText("");
		}

		oilChangeCheckbox.setBackground(new Color(191, 136, 255));
		syntheticOilCheckbox.setBackground(new Color(191, 136, 255));

		oilChangeCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change = oilChangeCheckbox.isSelected();
			}});

		syntheticOilCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synthetic = syntheticOilCheckbox.isSelected();
				syn = synthetic ? "synthetic" : "regular";
			}});


		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (change) {
					changeMilesS = newMileageTextField.getText();
					changeMiles = Integer.parseInt(changeMilesS);
					changeDateS = newDateTextField.getText();
					changeDate = LocalDate.parse(changeDateS, formatter);
					changeDateSS = changeDate.format(formatter);
					lastChangeLabel.setText("            Last oil change was on " + changeDateSS + " with " + syn + " oil");

					if (synthetic) {
						mile = 5000;
						nextChangeMiles = changeMiles + mile;
						nextChangeDate = changeDate.plusMonths(9);
						nextChangeDateS = nextChangeDate.format(formatter);
					} else {
						mile = 3000;
						nextChangeMiles = changeMiles + mile;
						nextChangeDate = changeDate.plusMonths(6);
						nextChangeDateS = nextChangeDate.format(formatter);

					}

					setMile = changeMiles;
					setDateSS = changeDateSS;

					nextChangeLabel.setText("             Next oil change at " + nextChangeMiles + " miles    ");
					messageLabel.setText("                 In " + mile + " miles or by " + nextChangeDateS);

				} else {

					setMileS = newMileageTextField.getText();
					setMile = Integer.parseInt(setMileS);
					setDateS = newDateTextField.getText();
					setDate = LocalDate.parse(setDateS, formatter);
					setDateSS = setDate.format(formatter);
					milesLeft = nextChangeMiles - setMile;
					nextChangeLabel.setText("             Next oil change at " + nextChangeMiles + " miles");
					messageLabel.setText("                 In " + milesLeft + " miles or by " + nextChangeDateS);
					if (setMile > nextChangeMiles || setDate.compareTo(nextChangeDate) >= 1) {
						messageLabel.setText("             You are past due for an oil change");}

					if (changeDateS.equals(NerdList.DEFAULT_DATE)) {
						lastChangeLabel.setText("");
						nextChangeLabel.setText("");
						messageLabel.setText("");
					}


				}}});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                newMileageTextField.setText(String.valueOf(saveMiles));
                newDateTextField.setText(saveDateS);
                lastChangeLabel.setText("            Last oil change was on " + saveDateS + " with " + saveSyn + " oil");
                nextChangeLabel.setText("             Next oil change at " + saveNextChange + " miles");
                messageLabel.setText("                 In " + saveLeft + " miles or by " + saveNextChangeDateS);
			}});

		saveAndExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSave(mDialog, change);
			}});
	}

	private void onSave(JDialog mDialog, boolean isChange) {
		MainMileage mm = new MainMileage();
		Mileage newOil = new Mileage(setMile, setDateSS, synthetic, isChange);
		NerdList.listChange.add(newOil);
		System.out.println(Arrays.toString(NerdList.listChange.toArray()).replaceAll("[\\[\\]]", ""));
		try {
			mm.writeMileage(newOil, change);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mDialog.dispose();;
		MainUI.reload();
	}
}