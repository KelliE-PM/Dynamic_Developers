package CarNerd;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainNotes {
	
	static DefaultListModel listModel = new DefaultListModel();
	static JList notes = new JList(listModel);
	
	public void loadNotes(JFrame frame) {

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
				while ((nextLine = br.readLine()) != null) {

					if (!nextLine.trim().isEmpty()) {

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

						}// end switch

						lineCounter++;

					}

				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e2) {
			FileWriter fw;
			try {
				fw = new FileWriter("notes.txt", true);
				PrintWriter pw = new PrintWriter(fw);
				
				pw.close();
				
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
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  			
		}

		DefaultListModel listModel2 = new DefaultListModel();
		JList titles = new JList(listModel2);

		for (int i = 0; i < notes.getModel().getSize(); i++) {

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

				try {
					notePopup.getContentPane().add(new AddNotePopup(notePopup), BorderLayout.CENTER);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				notePopup.pack();
				notePopup.setVisible(true);
			}

		});

		JButton btnViewNote = new JButton("View Note");
		btnViewNote.setBounds(10, 620, 150, 30);

		frame.add(btnViewNote);

		btnViewNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame notePopup = new JFrame("New Note");
				try {

					Note theNote = new Note();

					for (int i = 0; i < notes.getModel().getSize(); i++) {

						theNote = (Note) (notes.getModel().getElementAt(i));

						if (theNote.getNoteTitle() == titles.getSelectedValue()) {

							break;
						}
					}

					notePopup.getContentPane().add(new ViewNotePopup(notePopup, theNote), BorderLayout.CENTER);

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

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
}
