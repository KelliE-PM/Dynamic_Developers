package CarNerd;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MileagePopup extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// Dates
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("M/d/yyyy");
	
	// Create fields
	String lastDateSS;
	String changeDateSS;
	String currentDateSS;
	LocalDate lastDate;
	LocalDate nextReg;
	LocalDate nextSyn;
	LocalDate changeDate;
	LocalDate currentDate;
	LocalDate nextChangeDate;
	String lastDateS;
	String changeDateS;
	String currentDateS;
	String nextSynS;
	String nextRegS;
	int lastMiles;
	int changeMiles;
	int changeMilesReg;
	int changeMilesSyn;
	int nextChangeMiles;
	int currentMiles;
	boolean change;
	boolean synthetic;
	String syn;
	int milesLeft;
	
	public static void main(String[] args) {
		
	}

		MileagePopup(JFrame Mpanel) {
					
		// Update Data
		lastDateSS = "12/31/2020";
		changeDateSS = "12/12/2020";
		currentDateSS = "09/31/2021";
		lastMiles = 564378;
		currentMiles = lastMiles;
		changeMiles = 562934;
		
		// Create strings to dates to calculate
		lastDate = LocalDate.parse(lastDateSS, formater);
		changeDate = LocalDate.parse(changeDateSS, formater);
		currentDate = LocalDate.parse(currentDateSS, formater);
		nextReg = changeDate.plusMonths(6);
		nextSyn = changeDate.plusMonths(9);
		nextChangeDate = nextReg;
		
		// Convert back to strings to output
		lastDateS = lastDate.format(formater);
		nextRegS =nextReg.format(formater);
		nextSynS =nextSyn.format(formater);
		
		// Oil change booleans
		change = true;
		synthetic = false;
		syn = "regular";
		if (synthetic == true) {syn = "synthetic";}
		
		// Calculate next Oil Change
		changeMilesReg = changeMiles + 3000;
		changeMilesSyn = changeMiles + 5000;
		
		nextChangeMiles = changeMilesReg;
		if (synthetic == true) {nextChangeMiles = changeMilesSyn; nextChangeDate = nextSyn;} 
		milesLeft = nextChangeMiles - currentMiles;
		
		// Save mileage for reset
		//int saveMiles = lastMiles;
		//String saveDate = lastDate;
		//int saveChangeMiles = changeMiles;
		//String saveChangeDate = changeDate;
		
		// Message at bottom (can change)
		String due = "                 In " + milesLeft + " miles or by " + nextRegS;
		if (currentMiles > nextChangeMiles || currentDate.compareTo(changeDate) >= 1) {due = "             You are past due for an oil change";}
		
//****************************FRAME SETTING*********************************************		
		
		setBounds(100, 100, 360, 180);
		setBackground(new Color(191,136,255));
		JTextField newMileage = new JTextField();
		JTextField newDate = new JTextField();
		JCheckBox checkChange = new JCheckBox("Oil Change?");
		JCheckBox checkSynth = new JCheckBox("Synthetic oil?");
		JLabel nextChange = new JLabel("             Next oil change at " + nextChangeMiles + " miles    ");
		JButton update = new JButton("Update");
		JButton exit = new JButton("   Exit   ");
		JLabel message = new JLabel(due);
		JButton reset = new JButton("Reset");
		JLabel last = new JLabel("            Last oil change was on " + changeDateSS + " with " + syn + " oil");
		JLabel date = new JLabel(" DATE: ");
		JLabel enter = new JLabel("ENTER NEW MILEAGE:  ");
		
		last.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		Mpanel.add(newMileage);
		Mpanel.add(newDate);
		Mpanel.add(checkChange);
		Mpanel.add(checkSynth);
		Mpanel.add(nextChange);
		Mpanel.add(update);
		Mpanel.add(exit);
		Mpanel.add(message);
		Mpanel.add(reset);
		Mpanel.add(last);
		Mpanel.add(date);
		Mpanel.add(enter);
		
		enter.setBounds(12, 15, 140, 14);
		newMileage.setBounds(148, 12, 58, 20);
		date.setBounds(216, 15, 70, 14);
		newDate.setBounds(260, 12, 69, 20);
		last.setBounds(12, 33, 289, 20);
		checkChange.setBounds(43, 54, 100, 23);
		checkSynth.setBounds(136, 54, 98, 23);
		update.setBounds(250, 54, 79, 23);
		nextChange.setBounds(12, 90, 240, 14);
		reset.setBounds(250, 81, 79, 23);
		message.setBounds(12, 108, 240, 14);
		exit.setBounds(250, 108, 79, 23);

		newMileage.setText(String.valueOf(lastMiles));
        newDate.setText(lastDateS);
		
		checkChange.setBackground(new Color(191, 136, 255));
		checkSynth.setBackground(new Color(191, 136, 255));
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (change == true) {
				String changeMileS = newMileage.getText();
				int changeMile = Integer.parseInt(changeMileS);
				String changeDateS = newDate.getText();
				changeDate = LocalDate.parse(changeDateS, formater);
				changeDateSS = changeDate.format(formater);	
				last.setText("            Last oil change was on " + changeDateSS + " with " + syn + " oil");
				
				} else {
				String setMileS = newMileage.getText();
				int setMile = Integer.parseInt(setMileS);
				String setDateS = newDate.getText();
				LocalDate setDate = LocalDate.parse(setDateS, formater);
				String setDateSS = setDate.format(formater);
				}
				
			}});
		
		
		if (checkChange.isSelected()) {change = true;} 
		else{ change = false;}
		
		if (checkSynth.isSelected()) {synthetic = true;} 
		else{ synthetic = false;}
		
	}

}