package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
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
	public void writeMileage(Mileage printMiles, boolean oilChange) throws IOException {
			//FileOutputStream write = new FileOutputStream("Mileage.txt");
			//PrintWriter writer = new PrintWriter(write);

			FileWriter fw = new FileWriter("Mileage.txt", true);
			PrintWriter pw = new PrintWriter(fw);

			//for (int index = 0; index < NerdList.listMiles.size(); index++) {
			pw.println(printMiles.getType() + " "
					+ printMiles.getCurrentMiles() + " "
					+ printMiles.getCurrentDate() + " "
					+ printMiles.getSynthetic()+ " "
					+ NerdList.theCar.getName());

			pw.close();
			//fw.close();
	}
		public void readMileage() throws IOException {
			if (NerdList.theCar.getName() != null) {
				FileInputStream readMile = new FileInputStream("Mileage.txt");
				Scanner reader = new Scanner(readMile);

				while (reader.hasNext()) {
					String type = reader.next();

					if (type.equals("Normal")) {
						int lastMiles = reader.nextInt();
						String lastDate = reader.next();
						String carName = reader.nextLine().trim();

						if (NerdList.theCar.getName().equals(carName)) {
							Mileage newReg = new Mileage(lastMiles, lastDate, false, false); //
							NerdList.listMiles.add(newReg);
						}
					}

					if (type.equals("Change")) {
						int lastChange = reader.nextInt();
						String changeDate = reader.next();
						boolean lastSyn = reader.nextBoolean();
						String carName = reader.nextLine().trim();

						if (NerdList.theCar.getName().compareTo(carName) == 0) {
							Mileage newOil = new Mileage(lastChange, changeDate, lastSyn, true);
							NerdList.listChange.add(newOil);
						}
					}
				}

				reader.close();
				readMile.close();

			} else {
				Mileage newReg = new Mileage(-1, NerdList.DEFAULT_DATE, false, false);
				Mileage newOil = new Mileage(-1, NerdList.DEFAULT_DATE, false, true);

				NerdList.listMiles.add(newReg);
				NerdList.listChange.add(newOil);
			}
		}

		public void deleteAllMileage() {
			while(!NerdList.listMiles.isEmpty()) {
				NerdList.listMiles.remove(0);
			}
			while(!NerdList.listChange.isEmpty()) {
				NerdList.listChange.remove(0);
			}

		}
		public void loadMileage(JFrame mainFrame) throws ParseException, IOException {

		deleteAllMileage();
		readMileage();

		int mostRecentMilesEntry = NerdList.listMiles.size() - 1;
		int lastMiles = NerdList.listMiles.get(mostRecentMilesEntry).getCurrentMiles();
		String lastDate = NerdList.listMiles.get(mostRecentMilesEntry).getCurrentDate();

		int mostRecentChangeEntry = NerdList.listChange.size() - 1;
		int changeMiles = NerdList.listChange.get(mostRecentChangeEntry).getChangeMiles();
		String changeDate = NerdList.listChange.get(mostRecentChangeEntry).getChangeDate();
		int nextChangeMiles = NerdList.listChange.get(mostRecentChangeEntry).getNextChangeMiles();
		String nextChangeDate = NerdList.listChange.get(mostRecentChangeEntry).getNextChangeDate();

		JLabel lastMileageLabel = new JLabel("LAST REPORTED MILEAGE:  " + lastMiles + " miles on " + lastDate);
		lastMileageLabel.setBounds(300, 200, 350, 20);
		mainFrame.add(lastMileageLabel);
		JLabel lastChangeLabel = new JLabel("LAST REPORTED OIL CHANGE:  " + changeMiles + " miles on " + changeDate);
		lastChangeLabel.setBounds(300, 223, 350, 20);
		mainFrame.add(lastChangeLabel);
		JLabel nextChangeLabel = new JLabel("NEXT CHANGE DUE:  " + nextChangeMiles + " miles or " + nextChangeDate);
		nextChangeLabel.setBounds(300, 246, 350, 20);
		mainFrame.add(nextChangeLabel);

		if (lastDate == null || lastDate.equals(NerdList.DEFAULT_DATE)) {
			lastMileageLabel.setText("LAST REPORTED MILEAGE:");
			lastChangeLabel.setText("LAST REPORTED OIL CHANGE:");
			nextChangeLabel.setText("NEXT CHANGE DUE:");
		}

		if (changeDate == null || changeDate.equals(NerdList.DEFAULT_DATE)) {
			lastChangeLabel.setText("LAST REPORTED OIL CHANGE:");
			nextChangeLabel.setText("NEXT CHANGE DUE:");
		}

		JButton addMileButton = new JButton("Add Mileage");
		addMileButton.setBounds(350, 280, 150, 30);
		mainFrame.add(addMileButton);

		addMileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog mileageDialog = new JDialog();
				mileageDialog.setSize(360, 190);

				JPanel mileagePanel = new JPanel(new BorderLayout());
				try {
					mileagePanel.add(new AddMileagePopup(mileagePanel, mileageDialog));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				mileageDialog.add(mileagePanel);
				mileageDialog.setVisible(true);
			}
		});
	}


}