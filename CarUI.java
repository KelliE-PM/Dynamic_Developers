package CarNerd;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class CarUI {
	public static void selectCar(JComponent panel){
	String[] cars = {"Select Car", "Miata", "F150", "Jeep", "Mazda 3", "350z"};
    
    JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");
    JComboBox<String> spChooseCar = new JComboBox<String>(cars);
    
    btnAddCar.setBounds(10, 40, 100, 30);
    spChooseCar.setBounds(10, 10, 150, 20);
    btnDeleteCar.setBounds(10, 80, 100, 30);
    
    panel.add(btnAddCar);
    panel.add(btnDeleteCar);
    panel.add(spChooseCar);
    
}
	public static void loadCarInfo(JComponent panel) {

        JLabel lblCarName = new JLabel("Mira");
        JLabel lblCarYear = new JLabel("2000");
		JLabel lblCarMake = new JLabel("Mazda");
        JLabel lblCarModel = new JLabel("MIATA");
        JLabel lblCarTrim = new JLabel("LS");
		JLabel lblCarVIN = new JLabel("VIN: ***************** ");
        JLabel lblPlateNum = new JLabel("Plate: PH1-C5M");
        JButton btnEdit = new JButton("Edit");
       
        
        lblCarName.setBounds(180, 10, 100, 20);
        
		lblCarYear.setBounds(180, 40, 100, 20);
        lblCarMake.setBounds(250, 40, 100, 20);
        lblCarModel.setBounds(350, 40, 100, 20);
		lblCarTrim.setBounds(450, 40, 100, 20);
		
        lblCarVIN.setBounds(200, 70, 150, 20);
        lblPlateNum.setBounds(350, 70, 150, 20);
        btnEdit.setBounds(550, 40, 100, 30);
        
        panel.add(lblCarName);
		panel.add(lblCarYear);
        panel.add(lblCarMake);
        panel.add(lblCarModel);
        panel.add(lblCarTrim);
        panel.add(lblCarVIN);
        panel.add(lblPlateNum);
        panel.add(btnEdit);
	}
	public static void loadNotes(JComponent panel) {
		//JTextArea txtrEnterTextHere = new JTextArea();
	    //txtrEnterTextHere.setText("Enter text here");
	    //txtrEnterTextHere.setBounds(222, 97, 407, 241);
	    //panel.add(txtrEnterTextHere);
	    
	    //JTextField txtTitle = new JTextField();
	    //txtTitle.setText("Title");
	    //txtTitle.setBounds(196, 66, 86, 20);
	    //panel.add(txtTitle);
	    //txtTitle.setColumns(10);
	    
	    //JTextField txtEvent = new JTextField();
	    //txtEvent.setText("Event");
	    //txtEvent.setColumns(10);
	    //txtEvent.setBounds(379, 66, 86, 20);
	    //panel.add(txtEvent);
	    
	    //JTextField txtRemindDate = new JTextField();
	    //txtRemindDate.setText("Remind Date");
	    //txtRemindDate.setColumns(10);
	    //txtRemindDate.setBounds(569, 66, 86, 20);
	    //panel.add(txtRemindDate);
	    
	    //JButton btnSave = new JButton("SAVE");
	    //btnSave.setBounds(268, 349, 89, 45);
	    //panel.add(btnSave);
	    
	    //JButton btnClear = new JButton("CLEAR");
	    //btnClear.setBounds(501, 349, 89, 45);
	    //panel.add(btnClear);
	          
	
	    String[] reminders = {"   NoteTitle1", "**NoteTitle2", "    NoteTitle3", "   NoteTitle4", "**NoteTitle5", "   NoteTitle6", "**NoteTitle7"};
	    JList list = new JList(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane, BorderLayout.WEST);
		scrollPane.setBounds(10, 150, 170, 400);
		
		
	    JLabel lblNote = new JLabel("Any Notes marked with ** have reminders.");
	    lblNote.setBounds(10, 560, 700, 20);
	    panel.add(lblNote);
	}
	
	public static void loadMileage(JComponent panel) throws ParseException {
	        int lastOilMile = 157249;
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Date lastOilDate = (dateFormat.parse("04/29/2020"));
	        int lastMile = 155924;
	        Date lastMileDate = (dateFormat.parse("06/04/2020"));
	        
	        
	        
	        JLabel lblLastMile = new JLabel("Last Reported Mileage: " + lastMile);
	        JLabel lblLastMileDate = new JLabel("Reported on: 06/04/2020"); 
			JLabel lblLastOilMile = new JLabel("Last Reported Oil Change Mileage: " + (lastOilMile));
	        JLabel lblLastOilDate = new JLabel("Reported on: 04/29/2020");
	        JLabel lblNextOilMile = new JLabel("Next Oil Change Mileage: " + String.valueOf(lastOilMile + 3000));
			JLabel lblNextOilDate = new JLabel("Suggested Next Oil Change Date: 10/26/2020");
	        JButton btnAddMile = new JButton("Add Mileage");
	        
	        
	        lblLastMile.setBounds(300, 200, 350, 20);
			lblLastMileDate.setBounds(300, 230, 350, 20);
	        lblLastOilMile.setBounds(300, 260, 350, 20);
	        lblLastOilDate.setBounds(300, 290, 350, 20);
			lblNextOilMile.setBounds(300, 320, 350, 20);
	        lblNextOilDate.setBounds(300, 350, 350, 20);
	        btnAddMile.setBounds(350, 380, 150, 30);
	        
	        panel.add(lblLastMile);
			panel.add(lblLastMileDate);
	        panel.add(lblLastOilMile);
	        panel.add(lblLastOilDate);
	        panel.add(lblNextOilMile);
	        panel.add(lblNextOilDate);
	        panel.add(btnAddMile);
	}
	
	public static void loadSettings(JComponent panel) {
        JButton btnExportMile = new JButton("Export Mileage");
        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");
        
        btnExportMile.setBounds(70, 650, 150, 30);
        btnLogout.setBounds(270, 650, 150, 30);
        btnExit.setBounds(470, 650 , 150, 30);
        
        panel.add(btnExportMile);
        panel.add(btnLogout);
        panel.add(btnExit);
	}
}
