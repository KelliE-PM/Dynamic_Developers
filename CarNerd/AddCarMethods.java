package CarNerd;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.io.IOException;

public class AddCarMethods {
JComboBox<String> cbChooseCar = new JComboBox<String>();	
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
	public void addCarOptions(JFrame frame) throws FileNotFoundException {
// adds the cars to an ArrayList for the spinner to generate
		Car tempCar = new Car();
		tempCar.setName("TestCar");
		listCars.add(tempCar);
		
		tempCar = new Car();
		tempCar.setName("AnotherTest");
		listCars.add(tempCar);
				
		cbChooseCar.setBounds(10, 10, 150, 20);
		for (int c = 0; c < listCars.size(); c++ ) { cbChooseCar.addItem(listCars.get(c).getName()); }
	    
	    frame.add(cbChooseCar);
	}
	
	public void addMoreChoices(JFrame AddCarFrame) {
		Car tCar = new Car();
		tCar.setName("AnotherTest");
		listCars.add(tCar);
		for (int c = 0; c < listCars.size(); c++ ) { cbChooseCar.addItem(listCars.get(c).getName()); }
	}
	
	public void selectCar() {
		
		
		
	}
}