package CarNerd;

import java.time.LocalDate;

public class Mileage {
	
	private int currentMiles;
	private LocalDate currentDate;
	private int changeMiles;
	private LocalDate changeDate;
	private boolean synthetic;

	// Two variables is normal new mileage
	public Mileage(int currentMiles, LocalDate currentDate) {
		this.currentMiles = currentMiles;
		this.currentDate = currentDate;
	}
		
	// Three variables is an oil change
	public Mileage(int changeMiles, LocalDate changeDate, boolean synthetic) {
		this.changeMiles = changeMiles;
		this.changeDate = changeDate;
		this.synthetic = synthetic;
	}
		
	public void setCurrentMiles(int cMiles) {currentMiles = cMiles;}
	public int getCurrentMiles() {return currentMiles;}
	public void setCurrentDate(LocalDate cDate) {currentDate = cDate;}
	public LocalDate getCurrentDate() {return currentDate;}
	
	public void setChangeMiles(int cgMiles) {changeMiles = cgMiles;}
	public int getChangeMiles() {return changeMiles;}
	public void setChangeDate(LocalDate cgDate) {changeDate = cgDate;}
	public LocalDate getChangeDate() {return changeDate;}
	public void setSynthetic(boolean syn) {synthetic = syn;}
	public boolean getSynthetic() {return synthetic;}
}
