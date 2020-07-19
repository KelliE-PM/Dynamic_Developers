package CarNerd;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewNotePopup extends JPanel{
	private static final long serialVersionUID = 1L;

	public ViewNotePopup(JFrame frame, Note note) throws ParseException {
		// ****SIZE OF POPUP WINDOW******       
		int x = 600, y = 400;
		frame.setPreferredSize(new Dimension(x, y));

        int r = 191, g = 136, b = 255;
		frame.getContentPane().setBackground(new Color(r, g, b));
		
		JLabel lblNoteDate = new JLabel("Current Date (MM/DD/YYYY");
		JLabel lblRemindDate = new JLabel("Reminder Date (MM/DD/YYYY");
		JLabel lblNoteTitle = new JLabel("Title");
		JLabel lblNoteText = new JLabel("Note: ");
		
		JTextField tfNoteDate = new JTextField(note.getCurrentDate().toString());
		JTextField tfRemindDate = new JTextField(note.getRemindDate().toString());
		JTextField tfNoteTitle = new JTextField(note.getNoteTitle());
		JTextArea taNoteText = new JTextArea(note.getNoteText());
		
		lblNoteDate.setBounds(10, 15, 80, 20);
		lblRemindDate.setBounds(10, 55, 80, 20);
		lblNoteTitle.setBounds(10, 95, 80, 20);
		lblNoteText.setBounds(10, 135, 80, 20);
		
		tfNoteDate.setBounds(100, 10, 100, 30);
		tfRemindDate.setBounds(100, 50, 100, 30);
		tfNoteTitle.setBounds(100, 90, 100, 30);
		taNoteText.setBounds(100, 130, 150, 150);
		
		frame.add(lblNoteDate);
		frame.add(lblRemindDate);
		frame.add(lblNoteTitle);
		frame.add(lblNoteText);
		
		frame.add(tfNoteDate);
		frame.add(tfRemindDate);
		frame.add(tfNoteTitle);
		frame.add(taNoteText);
		        
	}
}
