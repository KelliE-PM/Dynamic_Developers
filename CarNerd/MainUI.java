package CarNerd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainUI {
	public JComboBox<String> spChooseCar = new JComboBox<String>();
	public void selectCar(JFrame frame) throws FileNotFoundException{
// ********** SELECT CAR // ADD CAR // DELETE CAR // EDIT CAR **********
		//String[] cars = {"Select Car", "Miata", "F150", "Jeep", "Mazda 3", "350z", "Add Car"};
		
	    JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");
	    
	    AddCarMethods addCarMethods = new AddCarMethods();
//TODO add cars to spinner	    
	    //spChooseCar.add(addCarMethods.addCarOptions());
	    //spChooseCar.clear();
	    
	    btnAddCar.setBounds(10, 40, 100, 30);
	    spChooseCar.setBounds(10, 10, 150, 20);
	    btnDeleteCar.setBounds(10, 80, 100, 30);
	    
	    frame.add(btnAddCar);
	    btnAddCar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JFrame popupFrame = new JFrame("Edit Car Information");
	            try { popupFrame.getContentPane().add(new AddCarPopup(popupFrame), BorderLayout.CENTER); } 
	            catch (ParseException e1) { e1.printStackTrace(); }
	            popupFrame.pack();
	            popupFrame.setVisible(true);
	        }
	    });
	 // ********** DELETE CAR **********	    
	    frame.add(btnDeleteCar);
	    btnDeleteCar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int result = JOptionPane.showConfirmDialog(frame,"Are you sure you would like to delete [car]?", "Delete Car", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(result == JOptionPane.YES_OPTION){ 
	        //TODO delete car 
	            	JOptionPane.showMessageDialog(null, "[car] as been deleted.");
	            }
				else if (result == JOptionPane.NO_OPTION){ 
			//TODO do nothing
				}
	        }
	    });
	    frame.add(spChooseCar);
}

	public void loadCarInfo(JFrame frame) {
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

        frame.add(lblCarName);
		frame.add(lblCarYear);
        frame.add(lblCarMake);
        frame.add(lblCarModel);
        frame.add(lblCarTrim);
        frame.add(lblCarVIN);
        frame.add(lblPlateNum);
        frame.add(btnEdit);
// onclick listener - reacts to the EDIT button being pressed
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame carPopup = new JFrame("Edit Car Information");
                try { carPopup.getContentPane().add(new AddCarPopup(carPopup), BorderLayout.CENTER); } 
                catch (ParseException e1) { e1.printStackTrace(); }
                carPopup.pack();
                carPopup.setVisible(true);
            }
        });
        
	}

	public void loadNotes(JFrame frame) { 
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
	
	public void loadMileage(JFrame frame) throws ParseException {
	        int lastOilMile = 157249;
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Date lastOilDate = (dateFormat.parse("04/29/2020"));
	        int lastMile = 155924;
	        Date lastMileDate = (dateFormat.parse("06/04/2020"));	        
	        
	        JLabel lblLastMile = new JLabel("Last Reported Mileage: " + lastMile);
	        JLabel lblLastMileDate = new JLabel("Reported on: " + lastMileDate); 
			JLabel lblLastOilMile = new JLabel("Last Reported Oil Change Mileage: " + (lastOilMile));
	        JLabel lblLastOilDate = new JLabel("Reported on: " + lastOilDate);
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
        
	        frame.add(lblLastMile);
			frame.add(lblLastMileDate);
	        frame.add(lblLastOilMile);
	        frame.add(lblLastOilDate);
	        frame.add(lblNextOilMile);
	        frame.add(lblNextOilDate);
		     
	        frame.add(btnAddMile);
	        btnAddMile.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	JFrame mFrame = new JFrame("Mileage Tracker");
	            	int x = 360, y = 184;
	                mFrame.setPreferredSize(new Dimension(x, y));
	                mFrame.getContentPane().add(new AddMileagePopup(mFrame), BorderLayout.CENTER);
	                mFrame.pack();
	                mFrame.setVisible(true);
	            }
	        });
		}

	public void loadSettings(JFrame frame) {
        JButton btnExportMile = new JButton("Export Mileage");
        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");
        
        btnExportMile.setBounds(70, 650, 150, 30);
        btnLogout.setBounds(270, 650, 150, 30);
        btnExit.setBounds(470, 650 , 150, 30);
        
        frame.add(btnExportMile);
        frame.add(btnLogout);
        frame.add(btnExit);
	}
}
