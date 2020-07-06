package car_nerds_ui_stage1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class AddCarMethods {
	
	private String path;
	private boolean append_to_file = false;

	public static void main(String[] args) {
		

	}
	
	
	public AddCarMethods (String filepath) {
		path = filepath;
	}
	
	public AddCarMethods (String filepath, boolean append_value ) {
		path = filepath;
		append_to_file = append_value;
	}
	
	public void writeToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%s" + "%n", textLine);
		
		print_line.close();
	}

}
