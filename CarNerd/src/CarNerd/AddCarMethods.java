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
	
	public void writeToFile() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("CarNerdCars.txt");
			PrintWriter printy = new PrintWriter(fos);
			for (int print = 0; print < NerdList.listCars.size(); print++) {
				printy.printf("%s,%s,%s,%s,%s,%s,%s%n", NerdList.listCars.get(print).getName(), NerdList.listCars.get(print).getYear(), 
						NerdList.listCars.get(print).getMake(), NerdList.listCars.get(print).getModel(), NerdList.listCars.get(print).getTrim(), 
						NerdList.listCars.get(print).getVIN(), NerdList.listCars.get(print).getPlate());
			}
			printy.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void editCar(String oldName, String name, String year, String make, String model, String trim, String vin, String plate) {
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { 
			if (oldName.compareTo(NerdList.listCars.get(c).getName()) == 0) {
				NerdList.listCars.get(c).setName(name);
				NerdList.listCars.get(c).setYear(year);
				NerdList.listCars.get(c).setMake(make);
				NerdList.listCars.get(c).setModel(model);
				NerdList.listCars.get(c).setTrim(trim);
				NerdList.listCars.get(c).setVIN(vin);
				NerdList.listCars.get(c).setPlate(plate);
				return;
			}
		}	
	}
	public void addNewCar(String name, String year, String make, String model, String trim, String vin, String plate) {
// adds car from Add Car popup upon pressing the Add New Car button
	
		Car tempCar = new Car();
		tempCar.setName(name);
		tempCar.setYear(year);
		tempCar.setMake(make);
		tempCar.setModel(model);
		tempCar.setTrim(trim);
		tempCar.setVIN(vin);
		tempCar.setPlate(plate);
		NerdList.listCars.add(tempCar);
	}
	public void deleteAllCars() {
		while (!NerdList.listCars.isEmpty()) { 
		NerdList.listCars.remove(0);
		}
	}
	public void deleteCar(String car) throws IOException {
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { 
			if (car.compareTo(NerdList.listCars.get(c).getName()) == 0) {
				NerdList.listCars.remove(c);
				writeToFile();
				return;
			}
		}
	}
	public void readFile() throws IOException {
// adds the cars to an ArrayList for the spinner to generate
		MainCarInfo mci = new MainCarInfo();
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
		for (int c = 0; c < NerdList.listCars.size(); c++ ) { 
			mci.cbChooseCar.addItem(NerdList.listCars.get(c).getName()); 
			}
	}
}