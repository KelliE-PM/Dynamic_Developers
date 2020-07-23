package CarNerd;

import java.util.ArrayList;

public class Car {
	private String name, year, make, model, trim, VIN, plate;
	private String notePath, mileagePath;
	
	
	//private Mileage miles;
	public Car() {}  // constructor method
	
	//public Car(String enteredName) {  
	//	NerdList.carNotesHM.put(enteredName, null);
	//}
	
	public void setName(String enteredName) { name = enteredName; }
	public void setYear(String enteredYear) { year = enteredYear; }
	public void setMake(String enteredMake) { make = enteredMake; }
	public void setModel(String enteredModel) { model = enteredModel; }
	public void setTrim(String enteredTrim) { trim = enteredTrim; }
	public void setVIN(String enteredVIN) { VIN = enteredVIN; }
	public void setPlate(String enteredPlate) { plate = enteredPlate; }
	public void setNote(Note note) { NerdList.carNotes.add(note); }
	public void setNotePath (String enteredNotePath) { notePath = enteredNotePath; }
	public void setMileagePath (String enteredMileagePath) { mileagePath = enteredMileagePath; }
	
	public String getName() { return name; }
	public String getYear() { return year; }
	public String getMake() { return make; }
	public String getModel() { return model; }
	public String getTrim() { return trim; }
	public String getVIN() { return VIN; }
	public String getPlate() { return plate; }
	public String getNotePath() { return notePath; }
	public String getMileagePath() { return mileagePath; }
	
	//public ArrayList<Note> getNotesHM() { return NerdList.carNotesHM.get(name); }
	public ArrayList<Note> getNotes() {return NerdList.carNotes; }
	
}