package Program;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Date;

public class popUp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel Mpanel;
	private JTextField newMileage;
	private JTextField newDate;
	private JCheckBox checkChange;
	private JCheckBox checkSynth;
	private JLabel nextChange;
	private JButton update;
	private JButton exit;
	private JLabel message;
	private JButton reset;
	private JLabel last;
	
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popUp frame = new popUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public popUp() {
		
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
		


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 195);

		Mpanel = new JPanel();
		Mpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mpanel);
		Mpanel.setLayout(new MigLayout("", "[][58.00][][60.00,left]", "[][][][][]"));
		Mpanel.setBackground(new Color(191,136,255));
		
		JLabel enter = new JLabel("ENTER NEW MILEAGE:  ");
		Mpanel.add(enter, "cell 0 0,alignx trailing");
		
		newMileage = new JTextField();
		newMileage.setHorizontalAlignment(SwingConstants.LEFT);
		newMileage.setText(String.valueOf(lastMiles));
		Mpanel.add(newMileage, "cell 1 0,alignx center");
		newMileage.setColumns(10);
		
		// setMileage = 
		
		JLabel date = new JLabel(" DATE: ");
		Mpanel.add(date, "cell 2 0,alignx trailing");
		
		newDate = new JTextField();
		newDate.setText(lastDate);
		Mpanel.add(newDate, "cell 3 0,alignx center,aligny center");
		newDate.setColumns(10);

		// setDate = 
		
		last = new JLabel("             Last oil change was on " + changeDate + " with " + syn + " oil");
		last.setFont(new Font("Tahoma", Font.ITALIC, 11));
		Mpanel.add(last, "cell 0 1 4 1,growx");
		
		checkChange = new JCheckBox("Oil Change?");
		checkChange.setBackground(new Color(191, 136, 255));
		Mpanel.add(checkChange, "cell 0 2,alignx right,aligny top");
		
		if (checkChange.isSelected()) {change = true;} 
		else{ change = false;}
		
		checkSynth = new JCheckBox("Synthetic oil?");
		Mpanel.add(checkSynth, "cell 1 2 2 1,growx,aligny top");
		checkSynth.setBackground(new Color(191, 136, 255));
		
		if (checkSynth.isSelected()) {synthetic = true;} 
		else{ synthetic = false;}
		
		update = new JButton("Update");
		Mpanel.add(update, "cell 3 2");
		
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
		
		nextChange = new JLabel("             Next oil change at " + nextChangeMiles + " miles    ");
		nextChange.setHorizontalAlignment(SwingConstants.LEFT);
		Mpanel.add(nextChange, "cell 0 3 3 1,alignx left,aligny bottom");
		
		reset = new JButton("Reset");
		Mpanel.add(reset, "cell 3 3,growx,aligny center");
		
		/* 
		lastMiles = saveMiles;
		lastDate = saveDate;
		changeMiles = saveChangeMiles;
		changeDate = saveChangeDate;
		*/
		
		message = new JLabel(due);
		Mpanel.add(message, "cell 0 4 3 1,alignx left,aligny top");
		
		exit = new JButton("   Exit   ");
		Mpanel.add(exit, "cell 3 4,growy");
		
		// mile(currentMiles, currentDate)
		// popUp.dispose();
	}

}
