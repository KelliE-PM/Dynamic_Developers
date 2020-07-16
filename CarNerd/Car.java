package CarNerd;

public class Car {
	private String name, year, make, model, trim, VIN, plate;
	
	//private Mileage miles;
	//private Note notes;
	
	public void setName(String enteredName) { name = enteredName; }
	public void setYear(String enteredYear) { year = enteredYear; }
	public void setMake(String enteredMake) { make = enteredMake; }
	public void setModel(String enteredModel) { model = enteredModel; }
	public void setTrim(String enteredTrim) { trim = enteredTrim; }
	public void setVIN(String enteredVIN) { VIN = enteredVIN; }
	public void setPlate(String enteredPlate) { plate = enteredPlate; }
	public void setNote(String enteredNote) { }
	
	public String getName() { return name; }
	public String getYear() { return year; }
	public String getMake() { return make; }
	public String getModel() { return model; }
	public String getTrim() { return trim; }
	public String getVIN() { return VIN; }
	public String getPlate() { return plate; }
	
	
}
