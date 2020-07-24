package CarNerd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddNotePopup extends JPanel{
	private static final long serialVersionUID = 1L;
	MainNotes mn = new MainNotes();
	public AddNotePopup(JPanel nPanel, JDialog nDialog, Note note) throws ParseException {
		setBackground(new Color(191,136,255));
		
		JLabel lblNoteDate = new JLabel("Current Date");
		//JLabel lblRemindDate = new JLabel("Reminder Date (M/DD/YYYY");
		JLabel lblNoteTitle = new JLabel("Title");
		JLabel lblNoteText = new JLabel("Note: ");
		
		JTextField tfNoteDate = new JTextField("M/DD/YYYY");
		JTextField tfRemindDate = new JTextField("1/11/2020");
		JTextField tfNoteTitle = new JTextField("");
		
		JTextArea taNoteText = new JTextArea("");
		taNoteText.setLineWrap(true);
		
		JButton btnSave = new JButton("SAVE");
	    JButton btnClear = new JButton("CLEAR");
		
		lblNoteDate.setBounds(10, 15, 80, 20);
		
		/*
		 * Currently not utilizing Remind Date.
		 * Use bounds below if utilizing Remind Date properly.
		 * lblRemindDate.setBounds(10, 55, 80, 20);
		 * lblNoteTitle.setBounds(10, 95, 80, 20);
		 * lblNoteText.setBounds(10, 135, 80, 20);
		 * tfRemindDate.setBounds(100, 50, 100, 30);
		 * tfNoteTitle.setBounds(100, 90, 100, 30);
		 * taNoteText.setBounds(100, 130, 150, 150);
		 */
		
		lblNoteTitle.setBounds(10, 55, 80, 20);
		lblNoteText.setBounds(10, 95, 80, 20);
		tfNoteDate.setBounds(90, 10, 250, 30);
		tfNoteTitle.setBounds(90, 50, 250, 30);
		taNoteText.setBounds(90, 90, 250, 150);
		
		btnSave.setBounds(90, 250, 100, 30);
	    btnClear.setBounds(240, 250, 100, 30);
	    
	    if (note != null) {
	    	MainNotes mn = new MainNotes();
			tfNoteDate.setText(mn.returningDateString(note.getCurrentDate().toString()));
			tfRemindDate.setText(mn.returningDateString(note.getRemindDate().toString()));
			tfNoteTitle.setText(note.getNoteTitle());
			taNoteText.setText(note.getNoteText());
	    }
	    
		nPanel.add(lblNoteDate);
		//nPanel.add(lblRemindDate);
		nPanel.add(lblNoteTitle);
		nPanel.add(lblNoteText);
		
		nPanel.add(tfNoteDate);
		nPanel.add(tfRemindDate);
		nPanel.add(tfNoteTitle);
		nPanel.add(taNoteText);
		
		nPanel.add(btnSave);
		nPanel.add(btnClear);
		
	    btnSave.addActionListener(new ActionListener(){
	    	
	      public void actionPerformed(ActionEvent e){
	    	  if(isValidDate(nDialog, tfNoteDate.getText())) { //&& isValidDate(nDialog, tfRemindDate.getText())) {
					mn.writeNotesFile(NerdList.theCar.getName(), tfNoteDate.getText(),tfRemindDate.getText(),tfNoteTitle.getText(),taNoteText.getText());
	    	  }
	    	  
	    	  nDialog.dispose();
	    	  MainUI.reload();
	      }
	    });
	          
	    btnClear.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){ 
	    	  tfNoteDate.setText("");
	    	  tfRemindDate.setText("1/11/2020");
	    	  tfNoteTitle.setText("");
	    	  taNoteText.setText("");
	      }
	    });
	}
	
	private boolean isValidDate(JDialog frame, String text) {
				
				DateTimeFormatter f = DateTimeFormatter.ofPattern("M/dd/yyyy");
				try {
					
				@SuppressWarnings("unused")
				LocalDate date = LocalDate.parse(text, f);
				
				} catch (DateTimeParseException e) {
					
				return false;
				}
				return true;
			}
}


