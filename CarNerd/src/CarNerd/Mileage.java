package CarNerd;

public class Mileage {
	
	private int currentMiles;
	private String currentDate;
	private int changeMiles;
	private String changeDate;
	private boolean synthetic;

	// Two variables is normal new mileage
	public Mileage(int currentMiles, String currentDate) {
		this.currentMiles = currentMiles;
		this.currentDate = currentDate;
	}
		
	// Three variables is an oil change
	public Mileage(int changeMiles, String changeDate, boolean synthetic) {
		this.changeMiles = changeMiles;
		this.changeDate = changeDate;
		this.synthetic = synthetic;
	}
		
	public void setCurrentMiles(int cMiles) {currentMiles = cMiles;}
	public int getCurrentMiles() {return currentMiles;}
	
	public void setCurrentDate(String cDate) {currentDate = cDate;}
	public String getCurrentDate() {return currentDate;}
	
	public void setChangeMiles(int cgMiles) {changeMiles = cgMiles;}
	public int getChangeMiles() {return changeMiles;}
	
	public void setChangeDate(String cgDate) {changeDate = cgDate;}
	public String getChangeDate() {return changeDate;}
	
	public void setSynthetic(boolean syn) {synthetic = syn;}
	public boolean getSynthetic() {return synthetic;}
}