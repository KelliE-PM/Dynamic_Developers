package car_nerds_ui_stage1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;

public class LogPage {

	protected Shell shell;
	private Text txtTypeInNotes;
	private Text txtTitle;
	private Text txtEvent;
	private Text txtDate;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogPage window = new LogPage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(921, 533);
		shell.setLayout(null);
		
		txtTitle = new Text(shell, SWT.BORDER);
		txtTitle.setBounds(250, 82, 117, 21);
		txtTitle.setText("Title");
		
		txtEvent = new Text(shell, SWT.BORDER);
		txtEvent.setBounds(408, 82, 108, 21);
		txtEvent.setText("Event");
		
		txtDate = new Text(shell, SWT.BORDER);
		txtDate.setBounds(551, 82, 101, 21);
		txtDate.setText("Date");
		
		txtTypeInNotes = new Text(shell, SWT.BORDER);
		txtTypeInNotes.setBounds(234, 113, 425, 200);
		txtTypeInNotes.setText("Type in notes here.");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(278, 340, 117, 30);
		btnNewButton.setText("Save");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(497, 342, 122, 27);
		btnNewButton_1.setText("Cancel");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(10, 443, 108, 41);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setText("CAR");
		
		Button btnNewButton_2_2 = new Button(shell, SWT.NONE);
		btnNewButton_2_2.setText("LOG");
		btnNewButton_2_2.setBounds(132, 443, 108, 41);
		
		Button btnNewButton_2_2_1 = new Button(shell, SWT.NONE);
		btnNewButton_2_2_1.setText("INFO");
		btnNewButton_2_2_1.setBounds(259, 443, 108, 41);
		
		Button btnNewButton_2_2_2 = new Button(shell, SWT.NONE);
		btnNewButton_2_2_2.setText("MILEAGE");
		btnNewButton_2_2_2.setBounds(384, 443, 108, 41);
		
		Button btnNewButton_2_2_3 = new Button(shell, SWT.NONE);
		btnNewButton_2_2_3.setText("REMIND");
		btnNewButton_2_2_3.setBounds(515, 443, 108, 41);
		
		Button btnNewButton_2_2_4 = new Button(shell, SWT.NONE);
		btnNewButton_2_2_4.setText("DOCS");
		btnNewButton_2_2_4.setBounds(644, 443, 108, 41);
		
		Button btnNewButton_2_2_5 = new Button(shell, SWT.NONE);
		btnNewButton_2_2_5.setText("SETTINGS");
		btnNewButton_2_2_5.setBounds(774, 443, 108, 41);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Name");
		lblName.setBounds(97, 10, 55, 15);
		
		Label lblMake = new Label(shell, SWT.NONE);
		lblMake.setText("Make");
		lblMake.setBounds(644, 10, 55, 15);
		
		Label lblModel = new Label(shell, SWT.NONE);
		lblModel.setText("Model");
		lblModel.setBounds(752, 10, 55, 15);
		
		Label lblYear = new Label(shell, SWT.NONE);
		lblYear.setText("Year");
		lblYear.setBounds(480, 10, 55, 15);
		
		Label lblTrim = new Label(shell, SWT.NONE);
		lblTrim.setText("Trim");
		lblTrim.setBounds(250, 10, 55, 15);

	}
}
