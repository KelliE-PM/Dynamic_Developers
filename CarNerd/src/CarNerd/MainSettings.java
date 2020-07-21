package CarNerd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainSettings {
	public void loadSettings(JFrame mainFrame) {
		AddCarMethods addCar = new AddCarMethods();
		JButton btnExportMile = new JButton("Export Mileage");
		JButton btnLogout = new JButton("Logout");
		JButton btnExit = new JButton("Exit");

		btnExportMile.setBounds(70, 650, 150, 30);
		btnLogout.setBounds(270, 650, 150, 30);
		btnExit.setBounds(470, 650, 150, 30);

		//mainFrame.add(btnExportMile);
		mainFrame.add(btnLogout);
		mainFrame.add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// TODO write mileage, note, and car classes to a file.

				addCar.writeToFile();

				System.exit(0);
			}
		});
	}
}
