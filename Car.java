package CarNerd;

public class Car {
	private String name, year, make, model, trim, VIN, plate;
	private Mileage miles;
	private Note notes;
	
	private void setName(String enteredName) { name = enteredName; }
	private void setYear(String enteredYear) { year = enteredYear; }
	private void setMake(String enteredMake) { make = enteredMake; }
	private void setModel(String enteredModel) { model = enteredModel; }
	private void setTrim(String enteredTrim) { trim = enteredTrim; }
	private void setVIN(String enteredVIN) { VIN = enteredVIN; }
	private void setPlate(String enteredPlate) { plate = enteredPlate; }
	private void setNote(String enteredNote) { }
	
	private String getName() { return name; }
	private String getYear() { return year; }
	private String getMake() { return make; }
	private String getModel() { return model; }
	private String getTrim() { return trim; }
	private String getVIN() { return VIN; }
	private String getPlate() { return plate; }
	
	
}
