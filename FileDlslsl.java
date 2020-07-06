package car_nerds_ui_stage1;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileDlslsl {
	public static void main(String[] args) throws IOException {
		String file_name = "E:/test.txt";
		
		try {
			ReadCar file = new ReadCar(file_name);
			String[] aryLines = file.OpenFile();
			
			for (int i=0; i < aryLines.length; i++ ) {
				System.out.println( aryLines[ i ] ) ;
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			AddCarMethods data = new AddCarMethods(file_name, true);
			data.writeToFile("this is another line for a number i hate");
			
			System.out.println("text file written to");
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
