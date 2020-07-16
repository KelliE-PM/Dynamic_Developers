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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class MainUI {
	JLabel lblCarName, lblCarYear, lblCarMake, lblCarModel, lblCarTrim, lblCarVIN, lblPlateNum;
	static JFrame mainFrame;
	JComboBox<String> cbChooseCar = new JComboBox<String>();
	static Car theCar = new Car();
	
	public JFrame makeFrame() {
		mainFrame = new JFrame();
		return mainFrame;
	}
	
	public void selectCar() throws FileNotFoundException, ParseException{
// ********** SELECT CAR // ADD CAR // DELETE CAR // EDIT CAR **********
	    JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");
	    
	    btnAddCar.setBounds(10, 40, 100, 30);
	    btnDeleteCar.setBounds(10, 80, 100, 30);
	    cbChooseCar.setBounds(10, 10, 150, 20);
	     
//TODO loop through car class and add options
	 // ********** SELECT CAR **********
	    Car car = new Car();
	    AddCarMethods addCar = new AddCarMethods();
	    addCar.readFile();
	    
	    /*  made into it's own method.
	    for (int rf = 0; rf < CarList.listCars.size(); rf++) { 
	    	cbChooseCar.addItem(CarList.listCars.get(rf).getName());
// TODO **FOR DEBUGGING PURPOSES.  PLEASE REMOVE BEFORE SUBMITTING	    	
	    	System.out.println(CarList.listCars.get(rf).getName());
	    }
	    mainFrame.add(cbChooseCar);
	    */
	    setDropDown();
	    cbChooseCar.addActionListener (new ActionListener () {
	        @Override
	    	public void actionPerformed(ActionEvent e) {
//TODO change labels, notes, mileage to selection
	        	String selectedCar = cbChooseCar.getSelectedItem().toString();
// TODO **FOR DEBUGGING PURPOSES.  PLEASE REMOVE BEFORE SUBMITTING		        	
	        	System.out.println(selectedCar);
	        	
	        	for (int a = 0; a < NerdList.listCars.size(); a++) { 
// ********** THE CAR INSTANCIATION **********
// theCar is the selected car and should be used throughout the program to pull the currently selected car	        		
	        		if (NerdList.listCars.get(a).getName().compareTo(selectedCar) == 0) { theCar = NerdList.listCars.get(a); }
	        	}
	        	setCarInfo(theCar.getName(), theCar.getYear(), theCar.getMake(), theCar.getModel(), theCar.getTrim(), theCar.getVIN(), theCar.getPlate());
	        	SwingUtilities.updateComponentTreeUI(mainFrame);
	        }
	    });
	    
	 // ********** ADD CAR **********   
	    mainFrame.add(btnAddCar);
	    btnAddCar.addActionListener(new ActionListener() {
	    	@Override
	        public void actionPerformed(ActionEvent e) { }
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
				else if (result == JOptionPane.NO_OPTION){ }
	        }
	    });
}

	public void setDropDown() {
		mainFrame.remove(cbChooseCar);
		for (int rf = 0; rf < NerdList.listCars.size(); rf++) { 
	    	cbChooseCar.addItem(NerdList.listCars.get(rf).getName());
// TODO **FOR DEBUGGING PURPOSES.  PLEASE REMOVE BEFORE SUBMITTING	    	
	    	System.out.println(NerdList.listCars.get(rf).getName());
	    }
	    mainFrame.add(cbChooseCar);
	    SwingUtilities.updateComponentTreeUI(mainFrame);
	}
	
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
	
	public void loadCarInfo(String name, String year, String make, String model, String trim, String vin, String plate) {
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
// onclick listener - reacts to the EDIT button being pressed
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	final JDialog dialog = new JDialog(mainFrame, "Click a button", true);
            	dialog.setSize(400, 400);
            	
            	JPanel panel = new JPanel(new BorderLayout());
            	panel.add(new AddCarPanel(panel, dialog, mainFrame)); 
            	
            	dialog.add(panel);
            	dialog.setVisible(true);
            }
            
        });
        
	}

	public void loadNotes() { 
	    String[] reminders = {"   NoteTitle1", "**NoteTitle2", "    NoteTitle3", "   NoteTitle4", "**NoteTitle5", "   NoteTitle6", "**NoteTitle7"};
	    JList<String> list = new JList<String>(reminders);
		JScrollPane scrollPane = new JScrollPane(list);
		mainFrame.add(scrollPane, BorderLayout.WEST);
		scrollPane.setBounds(10, 150, 170, 400);
		
		JLabel lblNote = new JLabel("Any Notes marked with ** have reminders.");
	    lblNote.setBounds(10, 560, 700, 20);
	    mainFrame.add(lblNote);
	    
	    JButton btnNewNote = new JButton("Add Note");
	    btnNewNote.setBounds(10, 590, 150, 30);
	    mainFrame.add(btnNewNote);
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
	/*
	public void loadMileage() throws ParseException {
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
        
	        mainFrame.add(lblLastMile);
			mainFrame.add(lblLastMileDate);
	        mainFrame.add(lblLastOilMile);
	        mainFrame.add(lblLastOilDate);
	        mainFrame.add(lblNextOilMile);
	        mainFrame.add(lblNextOilDate);
		     
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
	            }
	        });
		}
	*/
	public void loadSettings() {
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
