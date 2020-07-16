package CarNerd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddCarMethods {
	Car car = new Car();
	
	public AddCarMethods() { /* Constructor Method*/ }
	
	public void writeToFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("CarNerdCars.txt");
		PrintWriter printy = new PrintWriter(fos);
		for (int print = 0; print < NerdList.listCars.size(); print++) {
			printy.printf("%s,%s,%s,%s,%s,%s,%s%n", NerdList.listCars.get(print).getName(), NerdList.listCars.get(print).getYear(), NerdList.listCars.get(print).getMake(), NerdList.listCars.get(print).getModel(), NerdList.listCars.get(print).getTrim(), NerdList.listCars.get(print).getVIN(), NerdList.listCars.get(print).getPlate());
		}
		printy.close();
		fos.close();
		
	}
	public void addNewCar(String name, String year, String make, String model, String trim, String vin, String plate) {
// adds car from Add Car popup upon pressing the Add New Car button
	
		Car tempCar = new Car();
// TODO if or case statements to catch empty fields
// TODO if "," is included in a textbox, remove
		tempCar.setName(name);
		tempCar.setYear(year);
		tempCar.setMake(make);
		tempCar.setModel(model);
		tempCar.setTrim(trim);
		tempCar.setVIN(vin);
		tempCar.setPlate(plate);
		NerdList.listCars.add(tempCar);
		//return listCars.get(listCars.size() - 1);
	}
	public void deleteAllCars() {
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { 
		NerdList.listCars.remove(c);
		}
	}
	public void deleteCar(String car) {
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { 
			if (car.compareTo(NerdList.listCars.get(c).getName()) == 0) {
				NerdList.listCars.remove(c);
				return;
			}
		}
	}
	public void readFile() throws IOException {
// adds the cars to an ArrayList for the spinner to generate
		MainUI mainUI = new MainUI();
		Car tempCar;
		String[] tempArr = null;
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream("CarNerdCars.txt");
		}
		catch (FileNotFoundException e2) {
			FileOutputStream fos = new FileOutputStream("CarNerdCars.txt");
			fos.close();
			fis = new FileInputStream("CarNerdCars.txt");
		}
		@SuppressWarnings("resource")
		Scanner ready = new Scanner(fis);
		deleteAllCars();
		while (ready.hasNextLine()) {
			tempCar = new Car();
			tempArr = ready.nextLine().split(",");
			tempCar.setName(tempArr[0]);
			tempCar.setYear(tempArr[1]);
			tempCar.setMake(tempArr[2]);
			tempCar.setModel(tempArr[3]);
			tempCar.setTrim(tempArr[4]);
			tempCar.setVIN(tempArr[5]);
			tempCar.setPlate(tempArr[6]);
			NerdList.listCars.add(tempCar);
		}
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { mainUI.cbChooseCar.addItem(NerdList.listCars.get(c).getName()); }
	}
}