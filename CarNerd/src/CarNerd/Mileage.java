package CarNerd;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class Mileage {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("M/d/yyyy");
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
		
	// Three variables is an oil change
	public Mileage(int updateMiles, String updateDate, boolean synthetic, boolean isChange) {
		int monthsUntilChange = synthetic ? 9 : 6;
		type = isChange ? "Change" : "Normal";
		changeDateLD = LocalDate.parse(updateDate, formatter);

		if(isChange) {
			this.currentMiles = updateMiles;
			this.currentDate = Optional.ofNullable(updateDate).orElseGet(() -> simpleDateFormatter.format(Date.from(Instant.now())));
			mile = synthetic ? 5000 : 3000;
			nextChangeMiles = updateMiles + mile;
			nextChangeDateLD = changeDateLD.plusMonths(monthsUntilChange);
			nextChangeDate = nextChangeDateLD.format(formatter);
		} else {
			this.currentDate = Optional.ofNullable(updateDate).orElseGet(() -> simpleDateFormatter.format(Date.from(Instant.now())));
			this.changeMiles = updateMiles;
		}

		this.synthetic = synthetic;
	}
	
	public void setType(String cType) {type = cType;}
	public String getType() {return type;}
	
	public void setCurrentMiles(int cMiles) {currentMiles = cMiles;}
	public int getCurrentMiles() {return currentMiles;}
	public void setCurrentDate(String cDate) {currentDate = cDate;}
	public String getCurrentDate() {return Optional.ofNullable(currentDate).orElseGet(() -> NerdList.DEFAULT_DATE);}
	
	public void setChangeMiles(int cgMiles) {changeMiles = cgMiles;}
	public int getChangeMiles() {return changeMiles;}
	public void setChangeDate(String cgDate) {changeDate = cgDate;}
	public String getChangeDate() {return Optional.ofNullable(changeDate).orElseGet(() -> NerdList.DEFAULT_DATE);}
	public void setSynthetic(boolean syn) {synthetic = syn;}
	public boolean getSynthetic() {return synthetic;}
	
	public void setNexChangeMiles(int ncgMiles) {nextChangeMiles = ncgMiles;}
	public int getNextChangeMiles() {return nextChangeMiles;}
	public void setNextChangeDate(String ncgDate) {nextChangeDate = ncgDate;}
	public String getNextChangeDate() {return Optional.ofNullable(nextChangeDate).orElseGet(() -> NerdList.DEFAULT_DATE);}
	
	public String toString() {
		oil = synthetic ? "Synthetic" : "Regular";
		if (type.equals("Normal")) {return "" + currentMiles + " miles on " + currentDate;}
		return "Oil change at " + changeMiles + " miles on " + changeDate + " with " + oil + " oil";
	}

}