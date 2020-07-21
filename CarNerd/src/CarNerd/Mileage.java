package CarNerd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mileage {
	
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("M/d/yyyy");
	
	private int currentMiles;
	private String currentDate;
	private int changeMiles;
	private String changeDate;
	private boolean synthetic;
	private String type;
	private int nextChangeMiles;
	private String nextChangeDate;
	private LocalDate nextChangeDateLD;
	private LocalDate changeDateLD;
	private int mile;
	private String oil = "regular";
	
	
	// Two variables is normal new mileage
	public Mileage(int currentMiles, String currentDate) {
		type = "Normal";
		this.currentMiles = currentMiles;
		this.currentDate = currentDate;
	}
		
	// Three variables is an oil change
	public Mileage(int changeMiles, String changeDate, boolean synthetic) {
		type = "Change";
		this.changeMiles = changeMiles;
		this.changeDate = changeDate;
		this.synthetic = synthetic;
		
		changeDateLD = LocalDate.parse(changeDate, formater);
		
		if (synthetic == false) {
			mile = 3000;
			nextChangeMiles = changeMiles + mile; 
			nextChangeDateLD = changeDateLD.plusMonths(6);
			nextChangeDate = nextChangeDateLD.format(formater);
		}

		if (synthetic == true) {
			mile = 5000;
			nextChangeMiles = changeMiles + mile; 
			nextChangeDateLD = changeDateLD.plusMonths(9);
			nextChangeDate = nextChangeDateLD.format(formater);
		}
		
		
	}
	
	public void setType(String cType) {type = cType;}
	public String getType() {return type;}
	
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
	
	public void setNexChangeMiles(int ncgMiles) {nextChangeMiles = ncgMiles;}
	public int getNextChangeMiles() {return nextChangeMiles;}
	public void setNextChangeDate(String ncgDate) {nextChangeDate = ncgDate;}
	public String getNextChangeDate() {return nextChangeDate;}
	
	public String toString() {
		if (synthetic == true) {oil = "Synthetic";}
		if (type == "Normal") {return "" + currentMiles + " miles on " + currentDate;} 
		return "Oil change at " + changeMiles + " miles on " + changeDate + " with " + oil + " oil";
	}

}