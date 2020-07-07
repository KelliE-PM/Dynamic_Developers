package CarNerd;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;

public class MileagePopup extends JPanel {
	
	private static final long serialVersionUID = 1L;

	
	/* not finished
	 
	 public static void mile() {
		int miles;
		Date date;
	}
	
	public static void change() {
		int changeMiles;
		Date changeDate;
		boolean synthetic;
	}
	*/
	
	public static void main(String[] args) {
		
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
				//	MileagePopup frame = new MileagePopup();
			//	frame.setVisible(true);
			//	} catch (Exception e) {
				//	e.printStackTrace();
			//	}
		//	}
		//});
	}

		MileagePopup(JFrame Mpanel) {
		// Last given mileage   FIX  can't initialize empty every time
		
		
		int lastMiles = 0;
		String lastDate = "MM/DD/YYYY";
		
		// Update mileage (starting with last given in box)
		int currentMiles = lastMiles;
		String currentDate = lastDate;
		
		// Oil change
		int changeMiles;
		String changeDate;
		
		// Next oil change
		String nextChangeDate;  // add 6 months
		int nextChangeMiles;
		int milesLeft;
		
		// If true, mileage updates oil change label
		boolean change = false;
		boolean synthetic = false;
		String syn = "regular";
		if (synthetic == true) {syn = "synthetic";}
		
		// Dummy info
		lastMiles = 564378;
		lastDate = "12/31/2020";
		currentMiles = lastMiles;
		changeMiles = 562934;
		changeDate = "12/12/2020";
		nextChangeDate = "6/12/2021";
		
		// Save mileage for reset
		int saveMiles = lastMiles;
		String saveDate = lastDate;
		int saveChangeMiles = changeMiles;
		String saveChangeDate = changeDate;
		
		// Calculates next change and miles left
		nextChangeMiles = changeMiles + 3000;
		if (synthetic == true) {nextChangeMiles = changeMiles + 5000;} 
		// int nextChangeDate = changeDate + 6 months
		// if (synthetic == true) nextChangeDate = changeDate + 9 months
		milesLeft = nextChangeMiles - currentMiles;
		
		// Message at bottom (can change)
		String due = "             In " + milesLeft + " miles or by " + nextChangeDate;
		if (currentMiles > nextChangeMiles) /*|| currentDate > changeDate) */ {due = "             You are past due for an oil change";}
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//****************************FRAME SETTING*********************************************		
		
		setBounds(100, 100, 360, 195);
		JTextField newMileage = new JTextField();
		JTextField newDate = new JTextField();
		JCheckBox checkChange = new JCheckBox("Oil Change?");
		JCheckBox checkSynth = new JCheckBox("Synthetic oil?");
		JLabel nextChange = new JLabel("             Next oil change at " + nextChangeMiles + " miles    ");
		JButton update = new JButton("Update");
		JButton exit = new JButton("   Exit   ");
		JLabel message = new JLabel(due);
		JButton reset = new JButton("Reset");
		JLabel last = new JLabel("             Last oil change was on " + changeDate + " with " + syn + " oil");
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
		
		newMileage.setBounds(10, 20, 100, 30);
		newDate.setBounds(10, 30, 100, 30);
		checkChange.setBounds(10, 40, 100, 30);
		checkSynth.setBounds(10, 50, 100, 30);
		nextChange.setBounds(10, 60, 100, 30);
		update.setBounds(10, 70, 100, 30);
		exit.setBounds(10, 80, 100, 30);
		message.setBounds(10, 90, 100, 30);
		reset.setBounds(10, 100, 100, 30);
		last.setBounds(10, 110, 100, 30);
		date.setBounds(10, 120, 100, 30);
		enter.setBounds(10, 130, 100, 30);
		

		Mpanel.setBackground(new Color(191,136,255));
		
		//newMileage.setHorizontalAlignment(SwingConstants.LEFT);
		newMileage.setText(String.valueOf(lastMiles));
		
		//newMileage.setColumns(10);
		newDate.setText(lastDate);

		//newDate.setColumns(10);
		
		checkChange.setBackground(new Color(191, 136, 255));
		
		if (checkChange.isSelected()) {change = true;} 
		else{ change = false;}
		
		checkSynth.setBackground(new Color(191, 136, 255));
		
		if (checkSynth.isSelected()) {synthetic = true;} 
		else{ synthetic = false;}
		
		//Mpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(Mpanel);
		//Mpanel.setLayout(new MigLayout("", "[][58.00][][60.00,left]", "[][][][][]"));
		//Mpanel.getContentPane().add(new (Mpanel), BorderLayout.CENTER);
		
		//Mpanel.add(enter, "cell 0 0,alignx trailing");
		
		//Mpanel.add(newMileage, "cell 1 0,alignx center");
				// setMileage = 
		
		//Mpanel.add(date, "cell 2 0,alignx trailing")
			//Mpanel.add(newDate, "cell 3 0,alignx center,aligny center");	
		
		// setDate = 
		
		//Mpanel.add(last, "cell 0 1 4 1,growx");
		
		//Mpanel.add(checkChange, "cell 0 2,alignx right,aligny top");
		
		
		//Mpanel.add(checkSynth, "cell 1 2 2 1,growx,aligny top");
		//Mpanel.add(update, "cell 3 2");
		
		/*
		currentMiles = setMiles;
		currentDate = setDate;
		// mile(currentMiles, currentDate);
		// update message
		 
		if (change == true) {changeMiles = currentMiles; changeDate = currentDate;} 
		// change(changeMiles, changeDate, synthetic);
		// update last label and message
		*/
				
		// Errors
		// if (currentMiles < lastMiles) {currentMiles = saveMiles;}  // mileage won't update if less than old mileage.
		// if (currentDate < lastDate) {currentDate = saveDate}  // date won't update if earlier than old date.
		
		//nextChange.setHorizontalAlignment(SwingConstants.LEFT);
		//Mpanel.add(nextChange, "cell 0 3 3 1,alignx left,aligny bottom");
		
		
		//Mpanel.add(reset, "cell 3 3,growx,aligny center");
		
		/* 
		lastMiles = saveMiles;
		lastDate = saveDate;
		changeMiles = saveChangeMiles;
		changeDate = saveChangeDate;
		*/
		
		//Mpanel.add(message, "cell 0 4 3 1,alignx left,aligny top");
		
		
		//Mpanel.add(exit, "cell 3 4,growy");
		
		// mile(currentMiles, currentDate)
		// popUp.dispose();
	}

}
