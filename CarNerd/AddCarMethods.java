package CarNerd;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class AddCarMethods {
	public ArrayList<Car> listCars = new ArrayList<Car>();
	private String path;
	private boolean append_to_file = false;
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
		//return listCars.get(listCars.size() - 1);
	}
	public void readFile() throws FileNotFoundException {
// adds the cars to an ArrayList for the spinner to generate
		MainUI mainUI = new MainUI();
		Car tempCar = new Car();
		tempCar.setName("Mira");
		tempCar.setYear("2000");
		tempCar.setMake("Mazda");
		tempCar.setModel("Miata");
		tempCar.setTrim("SE");
		tempCar.setVIN("*****************");
		tempCar.setPlate("PH1C5M");
		listCars.add(tempCar);
		
		tempCar = new Car();
		tempCar.setName("Vera");
		tempCar.setYear("2006");
		tempCar.setMake("Nissan");
		tempCar.setModel("350Z");
		tempCar.setTrim("Awesome");
		tempCar.setVIN("#################");
		tempCar.setPlate("2BA96F");
		listCars.add(tempCar);
		
		
		
		//cbChooseCar.setBounds(10, 10, 150, 20);
		for (int c = 0; c < listCars.size(); c++ ) { mainUI.cbChooseCar.addItem(listCars.get(c).getName()); }
	    
	   // return listCars;
	}
	
	//public void addMoreChoices(JFrame AddCarFrame) {
	//	Car tCar = new Car();
	//	tCar.setName("AnotherTest");
	//	listCars.add(tCar);
	//	for (int c = 0; c < listCars.size(); c++ ) { cbChooseCar.addItem(listCars.get(c).getName()); }
//	}
	
	public void selectCar() {
		
		
		
	}
}