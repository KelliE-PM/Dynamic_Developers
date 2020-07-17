package CarNerd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainUI {
	public static void selectCar(JFrame mainFrame) throws FileNotFoundException{
// ********** SELECT CAR // ADD CAR // DELETE CAR // EDIT CAR **********
	    JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");
	    
	    AddCarMethods addCarMethods = new AddCarMethods();
	    
	    btnAddCar.setBounds(10, 40, 100, 30);
	    btnDeleteCar.setBounds(10, 80, 100, 30);
	    
	    addCarMethods.addCarOptions(mainFrame);
	    
	    mainFrame.add(btnAddCar);
	    btnAddCar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JFrame popupFrame = new JFrame("Edit Car Information");
	            try { popupFrame.getContentPane().add(new AddCarPopup(popupFrame, mainFrame), BorderLayout.CENTER); } 
	            catch (ParseException e1) { e1.printStackTrace(); }
	            popupFrame.pack();
	            popupFrame.setVisible(true);
	        }
	    });
	 // ********** DELETE CAR **********	    
	    mainFrame.add(btnDeleteCar);
	    btnDeleteCar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int result = JOptionPane.showConfirmDialog(mainFrame,"Are you sure you would like to delete [car]?", "Delete Car", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(result == JOptionPane.YES_OPTION){ 
	        //TODO delete car 
	            	JOptionPane.showMessageDialog(null, "[car] as been deleted.");
	            }
				else if (result == JOptionPane.NO_OPTION){ 
			//TODO do nothing
				}
	        }
	    });
}

	public static void loadCarInfo(JFrame mainFrame) {
// car information loading
        JLabel lblCarName = new JLabel("");
        JLabel lblCarYear = new JLabel("");
		JLabel lblCarMake = new JLabel("");
        JLabel lblCarModel = new JLabel("");
        JLabel lblCarTrim = new JLabel("");
		JLabel lblCarVIN = new JLabel("VIN: " + "");
        JLabel lblPlateNum = new JLabel("Plate: " + "");
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
// onclick listener - reacts to the EDIT button being pressed
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame carPopup = new JFrame("Edit Car Information");
                try { carPopup.getContentPane().add(new AddCarPopup(carPopup, mainFrame), BorderLayout.CENTER); } 
                catch (ParseException e1) { e1.printStackTrace(); }
                carPopup.pack();
                carPopup.setVisible(true);
            }
        });
        
	}

	public static void loadNotes(JFrame frame) { 
	    String[] reminders = {"   NoteTitle1", "**NoteTitle2", "    NoteTitle3", "   NoteTitle4", "**NoteTitle5", "   NoteTitle6", "**NoteTitle7"};
	    JList<String> list = new JList<String>(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		frame.add(scrollPane, BorderLayout.WEST);
		scrollPane.setBounds(10, 150, 170, 400);
		
		JLabel lblNote = new JLabel("Any Notes marked with ** have reminders.");
	    lblNote.setBounds(10, 560, 700, 20);
	    frame.add(lblNote);
	    
	    JButton btnNewNote = new JButton("Add Note");
	    btnNewNote.setBounds(10, 590, 150, 30);
	    frame.add(btnNewNote);
	    btnNewNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame notePopup = new JFrame("New Note");
                try { notePopup.getContentPane().add(new AddNotePopup(notePopup), BorderLayout.CENTER); } 
                catch (ParseException e1) { e1.printStackTrace(); }
                notePopup.pack();
                notePopup.setVisible(true);
            }
        });
	}
	
	public static void loadMileage(JFrame mainFrame) throws ParseException {
		
		// FIX   Call to object, can't pull from pop up
		int lastMiles = AddMileagePopup.lastMiles;
		String lastDateS = AddMileagePopup.lastDateS;
		int changeMiles = AddMileagePopup.changeMiles;
		String changeDateS = AddMileagePopup.changeDateS;
		int nextChangeMiles =  AddMileagePopup.nextChangeMiles;
		String nextChangeDateS = AddMileagePopup.nextChangeDateS;
		
		//Dummy info
		lastMiles = 564378;
		lastDateS = "12/31/2020";
		changeMiles = 562934;
		changeDateS = "12/12/2020";
		nextChangeMiles = 565934;
		nextChangeDateS = "6/12/2021";
		
		JLabel lblLastMileage = new JLabel("<html>LAST REPORTED MILEAGE:  <b>" + lastMiles + "</b> miles on <i>" + lastDateS + "</i></html>");
	    lblLastMileage.setBounds(300, 200, 350, 20);
        mainFrame.add(lblLastMileage);
		if (lastMiles == 0) {lblLastMileage.setText("LAST REPORTED MILEAGE: ");}

		JLabel lblLastChange = new JLabel("<html>LAST REPORTED OIL CHANGE:  <b>" + changeMiles + "</b> miles on <i>" + changeDateS + "</i></html>");
	    lblLastChange.setBounds(300, 224, 350, 20);
        mainFrame.add(lblLastChange);
		if (changeMiles == 0) {lblLastChange.setText("LAST REPORTED OIL CHANGE: ");}
        
		JLabel lblNextChange = new JLabel("<html>NEXT CHANGE DUE:  <b>" + nextChangeMiles + "</b> miles or on <i>" + nextChangeDateS + "</i></html>");
	    lblNextChange.setBounds(300, 248, 350, 20);
        mainFrame.add(lblNextChange);
    	if (nextChangeMiles == 0) {lblNextChange.setText("NEXT CHANGE DUE: ");}
	
		JButton btnAddMile = new JButton("Add Mileage");
        btnAddMile.setBounds(350, 280, 150, 30);
        
        mainFrame.add(btnAddMile);
        btnAddMile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame mFrame = new JFrame("Mileage Tracker");
            	int x = 360, y = 184;
                mFrame.setPreferredSize(new Dimension(x, y));
                mFrame.getContentPane().add(new AddMileagePopup(mFrame), BorderLayout.CENTER);
                mFrame.pack();
                mFrame.setVisible(true);
        }});
        
	}


	public static void loadSettings(JFrame mainFrame) {
        JButton btnExportMile = new JButton("Export Mileage");
        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");
        
        btnExportMile.setBounds(70, 650, 150, 30);
        btnLogout.setBounds(270, 650, 150, 30);
        btnExit.setBounds(470, 650 , 150, 30);
        
        mainFrame.add(btnExportMile);
        mainFrame.add(btnLogout);
        mainFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {System.exit(0);}});
	}
}