package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMileage {
	public void writeMileage() throws IOException {
		FileOutputStream write = new FileOutputStream("Mileage.txt");
		PrintWriter writer = new PrintWriter(write);

		for (int index = 0; index < NerdList.listMiles.size(); index++) {
			writer.println(NerdList.listMiles.get(index).getType() + " " 
					+ NerdList.listMiles.get(index).getCurrentMiles() + " "
					+ NerdList.listMiles.get(index).getCurrentDate());
		}

		for (int index = 0; index < NerdList.listChange.size(); index++) {
			writer.println(NerdList.listChange.get(index).getType() + " " 
					+ NerdList.listChange.get(index).getChangeMiles() + " "
					+ NerdList.listChange.get(index).getChangeDate() + " "
					+ NerdList.listChange.get(index).getSynthetic());
		}

		writer.close();
	}
	public void deleteAllMileage() {
		while(!NerdList.listMiles.isEmpty()) {
			NerdList.listMiles.remove(0);
		}
		while(!NerdList.listChange.isEmpty()) {
			NerdList.listChange.remove(0);
		}
		
	}
	public void readMileage() throws IOException {
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
				NerdList.listChange.add(newOil);	
			}
		}	

		reader.close();
		readMile.close();
	}
	public void loadMileage(JFrame mainFrame) throws ParseException, IOException {
		deleteAllMileage();
		readMileage();
		
		//writeMileage();

		int lastMiles = NerdList.listMiles.get(NerdList.listMiles.size() - 1).getCurrentMiles();
		String lastDate = NerdList.listMiles.get(NerdList.listMiles.size() - 1).getCurrentDate();
		int changeMiles = NerdList.listChange.get(NerdList.listChange.size() - 1).getChangeMiles();
		String changeDate = NerdList.listChange.get(NerdList.listChange.size() - 1).getChangeDate();
		int nextChangeMiles = NerdList.listChange.get(NerdList.listChange.size() - 1).getNextChangeMiles();
		String nextChangeDate = NerdList.listChange.get(NerdList.listChange.size() - 1).getNextChangeDate();
		
		JLabel lblLastMileage = new JLabel("LAST REPORTED MILEAGE:  " + lastMiles + " miles on " + lastDate);
		lblLastMileage.setBounds(300, 200, 350, 20);
		mainFrame.add(lblLastMileage);
		JLabel lblLastChange = new JLabel("LAST REPORTED OIL CHANGE:  " + changeMiles + " miles on " + changeDate);
		lblLastChange.setBounds(300, 223, 350, 20);
		mainFrame.add(lblLastChange);
		JLabel lblNextChange = new JLabel("NEXT CHANGE DUE:  " + nextChangeMiles + " miles or " + nextChangeDate);
		lblNextChange.setBounds(300, 246, 350, 20);
		mainFrame.add(lblNextChange);
		
		if (lastDate.equals("1/11/1111")) {
			lblLastMileage.setText("LAST REPORTED MILEAGE:");
			lblLastChange.setText("LAST REPORTED OIL CHANGE:");
			lblNextChange.setText("NEXT CHANGE DUE:");
		}
			
		if (changeDate.equals("1/11/1111")) {
			lblLastChange.setText("LAST REPORTED OIL CHANGE:");
			lblNextChange.setText("NEXT CHANGE DUE:");	
		}

		JButton btnAddMile = new JButton("Add Mileage");
		btnAddMile.setBounds(350, 280, 150, 30);
		mainFrame.add(btnAddMile);

		btnAddMile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog mDialog = new JDialog();
				mDialog.setSize(360, 190);

				JPanel mPanel = new JPanel(new BorderLayout());
				try {
					mPanel.add(new AddMileagePopup(mPanel, mDialog));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				mDialog.add(mPanel);
				mDialog.setVisible(true);
			}
		});
	}


}