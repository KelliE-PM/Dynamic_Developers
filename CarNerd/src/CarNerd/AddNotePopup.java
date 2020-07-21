package CarNerd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	public AddNotePopup(JPanel nPanel, JDialog nDialog) throws ParseException {
		setBackground(new Color(191,136,255));
		
		JLabel lblNoteDate = new JLabel("Current Date (MM/DD/YYYY");
		JLabel lblRemindDate = new JLabel("Reminder Date (MM/DD/YYYY");
		JLabel lblNoteTitle = new JLabel("Title");
		JLabel lblNoteText = new JLabel("Note: ");
		
		JTextField tfNoteDate = new JTextField("");
		JTextField tfRemindDate = new JTextField("");
		JTextField tfNoteTitle = new JTextField("");
		
		JTextArea taNoteText = new JTextArea();
		taNoteText.setLineWrap(true);
		
		JButton btnSave = new JButton("SAVE");
	    JButton btnClear = new JButton("CLEAR");
	    
		
		lblNoteDate.setBounds(10, 15, 80, 20);
		lblRemindDate.setBounds(10, 55, 80, 20);
		lblNoteTitle.setBounds(10, 95, 80, 20);
		lblNoteText.setBounds(10, 135, 80, 20);
		
		
		tfNoteDate.setBounds(100, 10, 100, 30);
		tfRemindDate.setBounds(100, 50, 100, 30);
		tfNoteTitle.setBounds(100, 90, 100, 30);
		taNoteText.setBounds(100, 130, 150, 150);
		
		btnSave.setBounds(100, 300, 140, 45);
	    btnClear.setBounds(300, 300, 140, 45);
	    
		
		nPanel.add(lblNoteDate);
		nPanel.add(lblRemindDate);
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
	    	  if(isValidDate(nDialog, tfNoteDate.getText()) && isValidDate(nDialog, tfRemindDate.getText())) {
		    	  
		    	  try {
		  			FileWriter fw = new FileWriter("notes.txt", true);
		  			PrintWriter pw = new PrintWriter(fw);
		  			
		  			pw.print(tfNoteDate.getText());
		  			pw.println();
		  			pw.print(tfRemindDate.getText());
		  			pw.println();
		  			pw.print(tfNoteTitle.getText());
		  			pw.println();
		  			pw.print(taNoteText.getText());
		  			pw.println();
		  			
		  			pw.close();
		  			
		  		} catch (IOException e1) {
		  			// TODO Auto-generated catch block
		  			e1.printStackTrace();
		  		}
	    	  }
	      }
	      
	      private boolean isValidDate(JDialog frame, String text) {
				
				DateTimeFormatter f = DateTimeFormatter.ofPattern("d-MM-yyyy");
				try {
					
				@SuppressWarnings("unused")
				LocalDate date = LocalDate.parse(text, f);
				
				
				} catch (DateTimeParseException e) {
					
				return false;
					
				}
				nDialog.dispose();
				MainUI.reload();
				return true;
				
			}
	      
	    });
	          
	    btnClear.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){ 
	    	  tfNoteDate.setText("");
	    	  tfRemindDate.setText("");
	    	  tfNoteTitle.setText("");
	    	  taNoteText.setText("");
	      }
	    });
	}
}