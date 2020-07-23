package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainNotes {
	
	//static DefaultListModel listModel = new DefaultListModel();  TODO
	//static JList notes = new JList(listModel);   TODO
	public String returningDateString(String date) {
		System.out.println(date);
		String fixedDate = date.substring(5,7) + "/" + date.substring(8,10) + "/" + date.substring(0,4);
		System.out.println(fixedDate);
		return fixedDate;
	}
	
	public void deleteAllNotes() {
		while(!NerdList.carNotes.isEmpty()) {
			NerdList.carNotes.remove(0);
		}
	}
	public void loadNotes(JFrame mainFrame) {
		if (NerdList.theCar.getName() != null) {
			deleteAllNotes();
			readNotesFile();
		}
		
		DefaultListModel<String> listModel2 = new DefaultListModel<String>(); 
		JList<String> titles = new JList<String>(listModel2);  
		
		ArrayList<Note> tempNotes = NerdList.theCar.getNotes();
		if (tempNotes != null) {
			for (int i = 0; i < tempNotes.size(); i++) {
	
				Note theNote = (Note) (tempNotes.get(i));
	
				listModel2.addElement(theNote.getNoteTitle());
			}
			//JLabel lblNote = new JLabel("Any Notes marked with ** have reminders.");
		}
		JButton btnNewNote = new JButton("Add Note");
		JButton btnViewNote = new JButton("View Note");
		JScrollPane scrollPane = new JScrollPane(titles);
		//lblNote.setBounds(10, 560, 700, 20);
		scrollPane.setBounds(10, 150, 170, 400);
		btnNewNote.setBounds(10, 590, 100, 30);
		btnViewNote.setBounds(10, 620, 100, 30);
		
		//mainFrame.add(lblNote);
		mainFrame.add(btnNewNote);
		mainFrame.add(scrollPane, BorderLayout.WEST);
		mainFrame.add(btnViewNote);
		
		btnNewNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog nDialog = new JDialog(mainFrame, "Click a button", true);
				nDialog.setSize(400, 400);

				JPanel nPanel = new JPanel(new BorderLayout());
				try {
					nPanel.add(new AddNotePopup(nPanel, nDialog, null));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				nDialog.add(nPanel);
				nDialog.setVisible(true);
			}

		});
		
		btnViewNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Note theNote = new Note();
				//TODO check to see if this causes an error if full.  Always pull new in case of delete;
				//tempNotes = null;
				ArrayList<Note> tempNotes = NerdList.theCar.getNotes();
				for (int i = 0; i < tempNotes.size(); i++) {

					theNote = (Note) (tempNotes.get(i));

					if (tempNotes.get(i).getNoteTitle() == titles.getSelectedValue()) {

						break;
					}
				}
				
				JDialog nDialog = new JDialog(mainFrame, "Click a button", true);
				nDialog.setSize(400, 400);

				JPanel nPanel = new JPanel(new BorderLayout());
				try {
					nPanel.add(new AddNotePopup(nPanel, nDialog, theNote));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				nDialog.add(nPanel);
				nDialog.setVisible(true);
			}
		});
	}
	
	public void writeNotesFile(String name, String noteDate, String remindDate, String noteTitle, String noteText) {
		try {
  			FileWriter fw = new FileWriter("notes.txt", true);
  			PrintWriter pw = new PrintWriter(fw);
  			
  			pw.printf("%s~%s~%s~%s~%s%n", name, noteDate, remindDate, noteTitle, noteText);
  			pw.close();
  		} catch (IOException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
	}
	public void readNotesFile() {
		// TODO only read theCar note files.
		try {
			FileReader fr = new FileReader("notes.txt");
			BufferedReader br = new BufferedReader(fr);

			String nextLine;
			String currentDate = "";
			String remindDate = "";
			String title = "";
			String text = "";
			String car = "";

			//int lineCounter = 0;

			Note currentNote;

			while ((nextLine = br.readLine()) != null) {

				if (!nextLine.trim().isEmpty()) {
					String[] tempNoteArr = nextLine.split("~");

					car = tempNoteArr[0];
					if (NerdList.theCar.getName().compareTo(car) == 0) {
						// switch (lineCounter % 4) {
						// case 0:
						currentDate = tempNoteArr[1];
						// break;
						// case 1:
						remindDate = tempNoteArr[2];
						// break;
						// case 2:
						title = tempNoteArr[3];
						// break;
						// case 3:
						text = tempNoteArr[4];

						currentNote = new Note(toDate(currentDate), toDate(remindDate), title, text);
						for (int c = 0; c < NerdList.listCars.size(); c++) {
							if (NerdList.listCars.get(c).getName().compareTo(car) == 0) {
								NerdList.listCars.get(c).setNote(currentNote);
								break;
							}
						}
					}
					// NerdList.theCar.setNote(currentNote);
					// break;

					// default:
					// break;

					// }// end switch

					// lineCounter++;

					}

				}
				br.close();
		} catch (IOException e2) {
			//FileWriter fw;
			
			/*try {
				fw = new FileWriter("Notes.txt", true);
				PrintWriter pw = new PrintWriter(fw);
				
				pw.close();
				
				FileReader fr = new FileReader("Notes.txt");
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
							NerdList.theCar.setNote(currentNote);
							break;
						default:
							break;
						
						}//end switch
						
						lineCounter++;
						
						}
						
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
  			
		}
		
	}
	/*
	private static boolean isValidDate(String text) {

		DateTimeFormatter f = DateTimeFormatter.ofPattern("d-MM-yyyy");
		try {

			LocalDate date = LocalDate.parse(text, f);

		} catch (DateTimeParseException e) {

			return false;
		}
		return true;
	}*/

	public LocalDate toDate(String text) {
		String strDate = text;
		//if (text != "") {
			//String dateFormatChange[] = text.split("/");
			//strDate = dateFormatChange[1].toString() + "-" + dateFormatChange[0].toString() + "-" + dateFormatChange[2].toString();
		//}
		DateTimeFormatter f = DateTimeFormatter.ofPattern("M/dd/yyyy");

		LocalDate date = LocalDate.parse(strDate, f);
		// TODO Auto-generated method stub
		return date;
	}
}
