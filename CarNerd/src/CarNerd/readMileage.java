package CarNerd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class readMileage  {

	public void readMileageFile() throws IOException {

		FileInputStream readMile = new FileInputStream("Mileage.txt");
		Scanner reader = new Scanner(readMile);


		while (reader.hasNext()) {
			String type = reader.next();

			if (type.equals("Normal")) {
				int lastMiles = reader.nextInt();
				String lastDate = reader.next();
				Mileage newReg = new Mileage(lastMiles, lastDate);
				NerdList.listMiles.add(newReg);
			}

			if (type.equals("Change")) {
				int lastChange = reader.nextInt();
				String changeDate = reader.next();
				boolean lastSyn = reader.nextBoolean();
				Mileage newOil = new Mileage(lastChange, changeDate, lastSyn);
				NerdList.listMiles.add(newOil);	
			}
		}	
		
		reader.close();
		readMile.close();
		
	}
	
	public void writeMileageFile() throws IOException {
		FileOutputStream write = new FileOutputStream("Mileage.txt");
		PrintWriter writer = new PrintWriter(write);
		
		for (int index = 0; index < NerdList.listMiles.size(); index++) {
			if (NerdList.listMiles.get(index).getType().equals("Normal")) {
				writer.println(NerdList.listMiles.get(index).getType() + " " 
				+ NerdList.listMiles.get(index).getCurrentMiles() + " "
				+ NerdList.listMiles.get(index).getCurrentDate());
				
			}
			if (NerdList.listMiles.get(index).getType().equals("Change")) {
				writer.println(NerdList.listMiles.get(index).getType() + " " 
				+ NerdList.listMiles.get(index).getChangeMiles() + " "
				+ NerdList.listMiles.get(index).getChangeDate() + " "
				+ NerdList.listMiles.get(index).getSynthetic());
			}
			
		}
		writer.close();		
		write.close();
	}
}

/*
JLabel lblLastMileage = new JLabel("LAST REPORTED MILEAGE:  " + AddMileagePopup.lastMiles + " miles on " + AddMileagePopup.lastDate);
lblLastMileage.setBounds(300, 200, 350, 20);
frame.add(lblLastMileage);

JLabel lblLastChange = new JLabel("LAST REPORTED OIL CHANGE:  " + AddMileagePopup.changeMiles + " miles on " + AddMileagePopup.changeDate);
lblLastChange.setBounds(300, 223, 350, 20);
frame.add(lblLastChange);

JLabel lblNextChange = new JLabel("NEXT CHANGE DUE:  " + AddMileagePopup.changeMiles + " miles or " + AddMileagePopup.changeDate);
lblNextChange.setBounds(300, 246, 350, 20);
frame.add(lblNextChange);

JButton btnAddMile = new JButton("Add Mileage");
btnAddMile.setBounds(350, 280, 150, 30);

frame.add(btnAddMile);
btnAddMile.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    	JFrame mFrame = new JFrame("Mileage Tracker");
    	int x = 360, y = 184;
        mFrame.setPreferredSize(new Dimension(x, y));
        mFrame.getContentPane().add(new AddMileagePopup(mFrame), BorderLayout.CENTER);
        mFrame.pack();
        mFrame.setVisible(true);
*/