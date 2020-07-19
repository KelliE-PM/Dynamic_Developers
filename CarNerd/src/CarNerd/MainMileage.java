package CarNerd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMileage {
	public void loadMileage(JFrame mainFrame) throws ParseException {
		JLabel lblLastMileage = new JLabel("LAST REPORTED MILEAGE:  " + AddMileagePopup.lastMiles + " miles on " + AddMileagePopup.lastDate);
		lblLastMileage.setBounds(300, 200, 350, 20);
		mainFrame.add(lblLastMileage);
		JLabel lblLastChange = new JLabel("LAST REPORTED OIL CHANGE:  " + AddMileagePopup.changeMiles + " miles on " + AddMileagePopup.changeDate);
		lblLastChange.setBounds(300, 223, 350, 20);
		mainFrame.add(lblLastChange);
		JLabel lblNextChange = new JLabel("NEXT CHANGE DUE:  " + AddMileagePopup.changeMiles + " miles or " + AddMileagePopup.changeDate);
		lblNextChange.setBounds(300, 246, 350, 20);
		mainFrame.add(lblNextChange);
		JButton btnAddMile = new JButton("Add Mileage");
		btnAddMile.setBounds(350, 280, 150, 30);
		mainFrame.add(btnAddMile);

// ******************** ADD MILEAGE ********************
// TODO create titles for ALL dialog boxes.  Don't delete TODO until all are complete
		btnAddMile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog mDialog = new JDialog();
				mDialog.setSize(360, 190);

				JPanel mPanel = new JPanel(new BorderLayout());
				mPanel.add(new AddMileagePopup(mPanel, mDialog));

				mDialog.add(mPanel);
				mDialog.setVisible(true);
			}
		});
	}
}
