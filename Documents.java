import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Documents {

	private JFrame frmDocuments;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Documents window = new Documents();
					window.frmDocuments.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Documents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDocuments = new JFrame();
		frmDocuments.setTitle("Documents");
		frmDocuments.getContentPane().setForeground(new Color(0, 0, 0));
		frmDocuments.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frmDocuments.setBounds(100, 100, 690, 502);
		frmDocuments.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDocuments.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(221, 160, 221));
		textArea.setFont(new Font("Dialog", Font.PLAIN, 15));
		textArea.setText("Documents:");
		textArea.setBounds(48, 80, 503, 242);
		frmDocuments.getContentPane().add(textArea);
		
		Button carButton = new Button("Car");
		carButton.setBounds(7, 380, 74, 24);
		carButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Your documents");
			}
		});
		frmDocuments.getContentPane().add(carButton);
		
		Button infoButton = new Button("Info");
		infoButton.setBounds(87, 380, 79, 24);
		frmDocuments.getContentPane().add(infoButton);
		
		Button logButton = new Button("Log");
		logButton.setBounds(172, 380, 79, 24);
		frmDocuments.getContentPane().add(logButton);
		
		Button mileageButton = new Button("Mileage");
		mileageButton.setBounds(257, 380, 79, 24);
		frmDocuments.getContentPane().add(mileageButton);
		
		Button reminderButton = new Button("Reminders!");
		reminderButton.setBounds(342, 380, 79, 24);
		frmDocuments.getContentPane().add(reminderButton);
		
		Button documentButton = new Button("Documents");
		documentButton.setBackground(new Color(186, 85, 211));
		documentButton.setBounds(427, 380, 79, 24);
		frmDocuments.getContentPane().add(documentButton);
		
		Button settingButton = new Button("Settings");
		settingButton.setBounds(512, 380, 79, 24);
		frmDocuments.getContentPane().add(settingButton);
		
		Label carLabel = new Label("Vehicle: ");
		carLabel.setAlignment(Label.CENTER);
		carLabel.setBounds(48, 10, 70, 24);
		frmDocuments.getContentPane().add(carLabel);
		
		Label yearLabel = new Label("Year: ");
		yearLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				documentButton.setBackground(new Color(186, 85, 211));
			}
		});
		yearLabel.setAlignment(Label.CENTER);
		yearLabel.setBounds(151, 10, 70, 24);
		frmDocuments.getContentPane().add(yearLabel);
		
		Label makeLabel = new Label("Make: ");
		makeLabel.setAlignment(Label.CENTER);
		makeLabel.setBounds(257, 10, 70, 24);
		frmDocuments.getContentPane().add(makeLabel);
		
		Label modelLabel = new Label("Model: ");
		modelLabel.setAlignment(Label.CENTER);
		modelLabel.setBounds(370, 10, 70, 24);
		frmDocuments.getContentPane().add(modelLabel);
		
		Label trimLabel = new Label("Trim: ");
		trimLabel.setAlignment(Label.CENTER);
		trimLabel.setBounds(481, 10, 70, 24);
		frmDocuments.getContentPane().add(trimLabel);
	}
}
