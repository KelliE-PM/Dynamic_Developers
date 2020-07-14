package CarNerd;

import java.time.LocalDate;

public class Note {
	private LocalDate currentDate;
	private LocalDate remindDate;
	private String noteTitle;
	private String noteText;
	
	// constructor for if user doesn't want to be reminded (without remindDate)
	public Note (LocalDate currentDate, String noteTitle, String noteText) {
		this.currentDate = currentDate;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
	}
	
	// constructor for full entry (currentDate, reminders, title, and text)
	public Note (LocalDate currentDate, LocalDate remindDate, String noteTitle, String noteText) {
		this.currentDate = currentDate;
		this.remindDate = remindDate;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
	}

	public LocalDate getCurrentDate() {return currentDate;}
	public void setCurrentDate(LocalDate currentDate) {this.currentDate = currentDate;}

	public LocalDate getRemindDate() {return remindDate;}
	public void setRemindDate(LocalDate remindDate) {this.remindDate = remindDate;}

	public String getNoteTitle() {return noteTitle;}
	public void setNoteTitle(String noteTitle) {this.noteTitle = noteTitle;}

	public String getNoteText() {return noteText;}
	public void setNoteText(String noteText) {this.noteText = noteText;}
	
	

}
