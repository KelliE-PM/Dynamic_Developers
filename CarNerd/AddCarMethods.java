package CarNerd;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Scanner;

import java.io.IOException;

public class AddCarMethods {
	
	private String path;
	private boolean append_to_file = false;
	public ArrayList<Car> listCars = new ArrayList<Car>();
	public AddCarMethods (String filepath) { path = filepath; }
	
	public AddCarMethods (String filepath, boolean append_value ) {
		path = filepath;
		append_to_file = append_value;
	}
	
	public AddCarMethods() {}

	public void writeToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf("%s" + "%n", textLine);
		print_line.close();
	}
	public void addNewCar(String name, String year, String make, String model, String trim, String vin, String plate) {
// adds car from Add Car popup upon pressing the Add New Car button
		Car tempCar = new Car();
		
//TODO if or case statements to catch empty fields
		tempCar.setName(name);
		tempCar.setYear(year);
		tempCar.setMake(make);
		tempCar.setModel(model);
		tempCar.setTrim(trim);
		tempCar.setVIN(vin);
		tempCar.setPlate(plate);
		listCars.add(tempCar);
	}
	public String[] addCarOptions() throws FileNotFoundException {
// adds the cars to an ArrayList for the spinner to generate
		String[] carsOption = new String[listCars.size()];
		MainUI MainUI = new MainUI();
		//FileInputStream FIS = new FileInputStream("cars.txt");
		//Scanner inputRead = new Scanner(FIS);
		
		for (int c = 0; c < listCars.size(); c++) {
			carsOption[c] = listCars.get(c).getName();
		}

		return carsOption;
	}
	public void selectCar() {
		
		
		
	}
}