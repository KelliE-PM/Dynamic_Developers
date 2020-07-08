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
	String saveDateSS;
	String changeDateSS;
	String saveChangeDateSS;
	String currentDateSS;
	LocalDate lastDate;
	LocalDate saveDate;
	LocalDate changeDate;
	LocalDate saveChangeDate;
	LocalDate currentDate;
	LocalDate nextChangeDate;
	LocalDate saveNextChangeDate;
	String lastDateS;
	String saveDateS;
	String changeDateS;
	String saveChangeDateS;
	String currentDateS;
	String nextChangeDateS;
	String saveNextChangeDateS;
	int lastMiles;
	int saveMiles;
	int changeMiles;
	int saveChange;
	int nextChangeMiles;
	int saveNextChange;
	int currentMiles;
	boolean change;
	boolean synthetic;
	boolean lastSyn;
	String syn;
	String saveSyn;
	int milesLeft;
	int saveLeft;
	String due;
	int mile;
	
	public static void main(String[] args) {
		
	}

		MileagePopup(JFrame Mpanel) {
					
		// Update Data
		lastDateSS = "12/31/2020";
		changeDateSS = "12/12/2020";
		currentDateSS = "1/31/2021";
		lastMiles = 564378;
		currentMiles = 564390;
		changeMiles = 562934;
		lastSyn = false;
		
		// Create strings to dates to calculate
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
		due = "                 In " + milesLeft + " miles or by " + nextChangeDateS;
		if (currentMiles > nextChangeMiles || currentDate.compareTo(nextChangeDate) >= 1) {due = "             You are past due for an oil change";}
		
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
		
		checkChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkChange.isSelected()) {change = true;} 
				else {change = false;}
				
			}});
		
		checkSynth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkSynth.isSelected()) {synthetic = true; syn = "synthetic";} 
				else {synthetic = false; syn = "regular";}
				
			}});
		
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (change == true) {
				String changeMileS = newMileage.getText();
				int changeMile = Integer.parseInt(changeMileS);
				String changeDateS = newDate.getText();
				changeDate = LocalDate.parse(changeDateS, formater);
				changeDateSS = changeDate.format(formater);	
				last.setText("            Last oil change was on " + changeDateSS + " with " + syn + " oil");
				
				if (synthetic == false) {
				mile = 3000;
				nextChangeMiles = changeMile + mile; 
				nextChangeDate = changeDate.plusMonths(6);
				nextChangeDateS = nextChangeDate.format(formater);
				}
				
				if (synthetic == true) {
				mile = 5000;
				nextChangeMiles = changeMile + mile; 
				nextChangeDate = changeDate.plusMonths(9);
				nextChangeDateS = nextChangeDate.format(formater);
				}
				
				nextChange.setText("             Next oil change at " + nextChangeMiles + " miles    ");
				message.setText("                 In " + mile + " miles or by " + nextChangeDateS);
				
				// FIX  send oil change mile and date to object or log
				
				} else {
				String setMileS = newMileage.getText();
				int setMile = Integer.parseInt(setMileS);
				String setDateS = newDate.getText();
				LocalDate setDate = LocalDate.parse(setDateS, formater);
				String setDateSS = setDate.format(formater);
				milesLeft = nextChangeMiles - setMile; 
				nextChange.setText("             Next oil change at " + nextChangeMiles + " miles");
				message.setText("                 In " + milesLeft + " miles or by " + nextChangeDateS);
				if (setMile > nextChangeMiles || setDate.compareTo(nextChangeDate) >= 1) {
				message.setText("             You are past due for an oil change");}
				
				// FIX  send mile and date to object or log
				
				}
				
			}});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMileage.setText(String.valueOf(saveMiles));
				newDate.setText(saveDateS);
				last.setText("            Last oil change was on " + saveDateS + " with " + saveSyn + " oil");
				nextChange.setText("             Next oil change at " + saveNextChange + " miles");
				message.setText("                 In " + saveLeft + " miles or by " + saveNextChangeDateS);
				
			}});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mpanel.dispose();
				
			}});
		
	}

}