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
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("M/d/yyyy");

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
		lastMiles = NerdList.listMiles.get(NerdList.listMiles.size() - 1).getCurrentMiles();
		lastDateSS = NerdList.listMiles.get(NerdList.listMiles.size() - 1).getCurrentDate();
		changeMiles = NerdList.listChange.get(NerdList.listChange.size() - 1).getChangeMiles();
		changeDateSS = NerdList.listChange.get(NerdList.listChange.size() - 1).getChangeDate();
		nextChangeMiles = NerdList.listChange.get(NerdList.listChange.size() - 1).getNextChangeMiles();
		nextChangeDateS = NerdList.listChange.get(NerdList.listChange.size() - 1).getNextChangeDate();
		lastSyn = NerdList.listChange.get(NerdList.listChange.size() - 1).getSynthetic();
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
		
		lastDate = LocalDate.parse(lastDateSS, formater);
		changeDate = LocalDate.parse(changeDateSS, formater);
		currentDate = LocalDate.parse(currentDateSS, formater);
		
		// Convert back to strings to output
		lastDateS = lastDate.format(formater);
		changeDateS = changeDate.format(formater);
		currentDateS = currentDate.format(formater);

		if (lastSyn == true) {
			nextChangeMiles = changeMiles + 5000;
			nextChangeDate = changeDate.plusMonths(9);
			syn = "synthetic";

		} else { 
			nextChangeMiles = changeMiles + 3000;
			nextChangeDate = changeDate.plusMonths(6);
			syn = "regular";
		}

		nextChangeDateS = nextChangeDate.format(formater);
		milesLeft = nextChangeMiles - currentMiles;

		// Oil change booleans
		change = false;
		synthetic = false;
		syn = "regular";
		if (synthetic == true) {syn = "synthetic";}

		// Backup info
		saveMiles = lastMiles;
		saveDate = lastDate;
		saveDateS = saveDate.format(formater);
		saveChange = changeMiles;
		saveChangeDate = changeDate;
		saveChangeDateS = saveChangeDate.format(formater);
		saveNextChange = nextChangeMiles;
		saveNextChangeDate = nextChangeDate;
		saveNextChangeDateS = nextChangeDate.format(formater);
		saveSyn = syn;
		saveLeft = milesLeft;

		// Message at bottom (can change)
		due ="<html>&emsp;&emsp;&emsp;&emsp; In <b>" + milesLeft + "</b> miles or by " + nextChangeDateS + "</html>";
		if (currentMiles > nextChangeMiles || currentDate.compareTo(nextChangeDate) >= 1) {due = "             You are past due for an oil change";}

		//****************************PANEL SETTING*********************************************		
		mPanel.setPreferredSize(new Dimension(360, 190));
		setBounds(100, 100, 360, 180);
		setBackground(new Color(191,136,255));
		
		JTextField tfNewMileage = new JTextField();
		JTextField tfNewDate = new JTextField();
		
		JCheckBox chkChange = new JCheckBox("Oil Change?");
		JCheckBox chkSynth = new JCheckBox("Synthetic oil?");
		
		JButton btnSave = new JButton("Update");
		JButton btnExit = new JButton("   Save   ");
		JButton btnReset = new JButton("Reset");
		
		JLabel lblMessage = new JLabel(due);
		JLabel lblLast = new JLabel("            Last oil change was on " + changeDateSS + " with " + syn + " oil");
		JLabel lblDate = new JLabel(" DATE: ");
		JLabel lblEnter = new JLabel("ENTER NEW MILEAGE:  ");
		JLabel lblNextChange = new JLabel("             Next oil change at " + nextChangeMiles + " miles    ");
		
		

		lblLast.setFont(new Font("Tahoma", Font.ITALIC, 11));

		mPanel.add(tfNewMileage);
		mPanel.add(tfNewDate);
		mPanel.add(chkChange);
		mPanel.add(chkSynth);
		mPanel.add(lblNextChange);
		mPanel.add(btnSave);
		mPanel.add(btnExit);
		mPanel.add(lblMessage);
		mPanel.add(btnReset);
		mPanel.add(lblLast);
		mPanel.add(lblDate);
		mPanel.add(lblEnter);

		lblEnter.setBounds(12, 15, 140, 14);
		tfNewMileage.setBounds(148, 12, 58, 20);
		lblDate.setBounds(216, 15, 70, 14);
		tfNewDate.setBounds(260, 12, 69, 20);
		lblLast.setBounds(12, 33, 289, 20);
		chkChange.setBounds(43, 54, 100, 23);
		chkSynth.setBounds(136, 54, 110, 23);
		btnSave.setBounds(250, 54, 79, 23);
		lblNextChange.setBounds(12, 90, 240, 14);
		btnReset.setBounds(250, 81, 79, 23);
		lblMessage.setBounds(12, 108, 240, 14);
		btnExit.setBounds(250, 108, 79, 23);

		tfNewMileage.setText(String.valueOf(lastMiles));
		tfNewDate.setText(lastDateS);

		if (lastDateSS.equals("1/11/1111")) {
			tfNewMileage.setText("");
			tfNewDate.setText("M/D/YYYY");
			lblLast.setText("");      
			lblNextChange.setText("");
			lblMessage.setText("");    
		}
		if (changeDateS.equals("1/11/1111")) {
			lblLast.setText("");  
			lblNextChange.setText("");
			lblMessage.setText("");   
		}
		
		chkChange.setBackground(new Color(191, 136, 255));
		chkSynth.setBackground(new Color(191, 136, 255));

		chkChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chkChange.isSelected()) {change = true;} 
				else {change = false;}

			}});

		chkSynth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chkSynth.isSelected()) {synthetic = true; syn = "synthetic";} 
				else {synthetic = false; syn = "regular";}

			}});


		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (change == true) {
					changeMilesS = tfNewMileage.getText();
					changeMiles = Integer.parseInt(changeMilesS);
					changeDateS = tfNewDate.getText();
					changeDate = LocalDate.parse(changeDateS, formater);
					changeDateSS = changeDate.format(formater);	
					lblLast.setText("            Last oil change was on " + changeDateSS + " with " + syn + " oil");

					if (synthetic == false) {
						mile = 3000;
						nextChangeMiles = changeMiles + mile; 
						nextChangeDate = changeDate.plusMonths(6);
						nextChangeDateS = nextChangeDate.format(formater);
					}

					else if (synthetic == true) {
						mile = 5000;
						nextChangeMiles = changeMiles + mile; 
						nextChangeDate = changeDate.plusMonths(9);
						nextChangeDateS = nextChangeDate.format(formater);
					}
					
					setMile = changeMiles;
					setDateSS = changeDateSS;
					
					lblNextChange.setText("             Next oil change at " + nextChangeMiles + " miles    ");
					lblMessage.setText("                 In " + mile + " miles or by " + nextChangeDateS);

				} else {
						
					setMileS = tfNewMileage.getText();
					setMile = Integer.parseInt(setMileS);
					setDateS = tfNewDate.getText();
					setDate = LocalDate.parse(setDateS, formater);
					setDateSS = setDate.format(formater);
					milesLeft = nextChangeMiles - setMile; 
					lblNextChange.setText("             Next oil change at " + nextChangeMiles + " miles");
					lblMessage.setText("                 In " + milesLeft + " miles or by " + nextChangeDateS);
					if (setMile > nextChangeMiles || setDate.compareTo(nextChangeDate) >= 1) {
						lblMessage.setText("             You are past due for an oil change");}
					
					if (changeDateS.equals("1/11/1111")) {
						lblLast.setText("");  
						lblNextChange.setText("");
						lblMessage.setText("");   
					}
					

				}}});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNewMileage.setText(String.valueOf(saveMiles));
				tfNewDate.setText(saveDateS);
				lblLast.setText("            Last oil change was on " + saveDateS + " with " + saveSyn + " oil");
				lblNextChange.setText("             Next oil change at " + saveNextChange + " miles");
				lblMessage.setText("                 In " + saveLeft + " miles or by " + saveNextChangeDateS);	

			}});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMileage mm = new MainMileage();
				if (change == true) {
				Mileage newOil = new Mileage(setMile, setDateSS, synthetic);
				NerdList.listChange.add(newOil);	
				System.out.println(Arrays.toString(NerdList.listChange.toArray()).replaceAll("[\\[\\]]", ""));
				
				try {
					mm.writeMileage(newOil, true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				} else {
					Mileage newReg = new Mileage(setMile, setDateSS);
					NerdList.listMiles.add(newReg);
					System.out.println(Arrays.toString(NerdList.listMiles.toArray()).replaceAll("[\\[\\]]", ""));
					
					try {
						mm.writeMileage(newReg, false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				mDialog.dispose();;
				MainUI.reload();
			}});
	}

}