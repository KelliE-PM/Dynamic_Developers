import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainUI {
	public static void selectCar(JFrame frame){
	String[] cars = {"Select Car", "Miata", "F150", "Jeep", "Mazda 3", "350z", "Add Car"};
    
    JButton btnAddCar = new JButton("Add Car"), btnDeleteCar = new JButton("Delete Car");
    JComboBox<String> spChooseCar = new JComboBox<String>(cars);
    
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
	public static void loadCarInfo(JFrame frame) {
// car information loading
        JLabel lblCarName = new JLabel("Mira");
        JLabel lblCarYear = new JLabel("2000");
		JLabel lblCarMake = new JLabel("Mazda");
        JLabel lblCarModel = new JLabel("MIATA");
        JLabel lblCarTrim = new JLabel("LS");
		JLabel lblCarVIN = new JLabel("VIN: JM1NB353*Y01*****");
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
	
	static DefaultListModel listModel = new DefaultListModel();
	static JList notes = new JList(listModel);
	
	public static void loadNotes(JFrame frame) { 
		
		try {
			
			FileReader fr = new FileReader("notes.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String nextLine;
			String currentDate = "";
			String remindDate = "";
			String title = "";
			String text = "";
			
			int lineCounter = 0;
			
			Note currentNote;
			
			try {
				while((nextLine = br.readLine()) != null) {
					
					if(!nextLine.trim().isEmpty()) {
					
					switch (lineCounter % 4) {
					
					case 0:
						currentDate = nextLine;
						break;
						
					case 1:
						remindDate = nextLine;
						break;
						
					case 2:
						title = nextLine;
						break;
						
					case 3:
						text = nextLine;
						currentNote = new Note(toDate(currentDate), toDate(remindDate), title, text);
						listModel.addElement(currentNote);
						break;
						
					default:
						break;
					
					}//end switch
					
					lineCounter++;
					
					}
					
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		DefaultListModel listModel2 = new DefaultListModel();
		JList titles = new JList(listModel2);
		
		for(int i=0;i<notes.getModel().getSize();i++) {
			
			Note theNote = (Note) (notes.getModel().getElementAt(i));
			
			listModel2.addElement(theNote.getNoteTitle());
			
		}
		
		JScrollPane scrollPane = new JScrollPane(titles);
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
	
	private static boolean isValidDate(String text) {
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("d-MM-yyyy");
		try {
			
		LocalDate date = LocalDate.parse(text, f);
		
		
		} catch (DateTimeParseException e) {
			
		return false;
			
		}
		
		return true;
		
	}
	
	private static LocalDate toDate(String text) {
			
			DateTimeFormatter f = DateTimeFormatter.ofPattern("d-MM-yyyy");
			
			LocalDate date = LocalDate.parse(text, f);
			// TODO Auto-generated method stub
			return date;
		}
	public static void loadMileage(JFrame frame) throws ParseException {
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
	}
	
	public static void loadSettings(JFrame frame) {
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

