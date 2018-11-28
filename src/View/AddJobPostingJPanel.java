package View;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.Link;
import Controller.LinkedList;
import Model.Applicant;
import Model.Job;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * This class has the JPanel for the page to add a job posting
 */
public class AddJobPostingJPanel extends JPanel {
	private JTextField txtTitle;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtFullTimeStatus;
	private JTextArea txtDescription;
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnBackToMain = new JButton("Back to Main Menu");
	LinkedList jobList;
	
	/**
	 * Create the panel.
	 */
	public AddJobPostingJPanel(LinkedList jobs) {

		this.jobList = jobs;
		
		setLayout(new BorderLayout());

		JPanel form = new JPanel();

		form.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		//Header title for the page
		JLabel lblApplyDesc = new JLabel("Enter Below Information To Add a Job Posting");
		add(lblApplyDesc, BorderLayout.NORTH);

		//Label for the job title
		JLabel lblTitle = new JLabel("Job Title:");
		form.add(lblTitle, "4, 6, right, default");

		//Text field for the job title
		txtTitle = new JTextField();
		form.add(txtTitle, "6, 6, fill, default");
		txtTitle.setColumns(10);

		//Label for the company name
		JLabel lblCompany = new JLabel("Company:");
		form.add(lblCompany, "4, 8, right, default");

		//Text field for the company name
		txtCompany = new JTextField();
		form.add(txtCompany, "6, 8, fill, default");
		txtCompany.setColumns(10);

		//Label for the job salary
		JLabel lblSalary = new JLabel("Salary:");
		form.add(lblSalary, "4, 10, right, default");

		//Text field for the job salary
		txtSalary = new JTextField();
		form.add(txtSalary, "6, 10, fill, default");
		txtSalary.setColumns(10);
		
		//Label for the job fte
		JLabel lblFullTimeStatus = new JLabel("Full Time Equivalent:");
		form.add(lblFullTimeStatus, "4, 12, right, default");

		//Text field for the job fte
		txtFullTimeStatus = new JTextField();
		form.add(txtFullTimeStatus, "6, 12, fill, default");
		txtFullTimeStatus.setColumns(10);
		
		//Label for the job description
		JLabel lblDescription = new JLabel("Job Description:");
		form.add(lblDescription, "4, 14, right, default");

		//Text field for the job description
		txtDescription = new JTextArea();
		form.add(txtDescription, "6, 14, fill, default");
		txtDescription.setColumns(10);

		//Creating and adding the button listener to the submit, clear, and back to main buttons
		buttonListener bl = new buttonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnBackToMain.addActionListener(bl);

		//Adding the buttons and form to the panel
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		buttons.add(btnSubmit, BorderLayout.WEST);
		buttons.add(btnClear, BorderLayout.CENTER);
		buttons.add(btnBackToMain, BorderLayout.EAST);
		add(form, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Submit button
			if (e.getSource() == btnSubmit) {
				String errorString = validateForm();
				//If there was invalid input, show the errors
				if(errorString.length() > 1) {
					JOptionPane.showMessageDialog(null, errorString);
				//Otherwise create a new job
				} else {
					double salary = Double.parseDouble(txtSalary.getText());
					double fte = Double.parseDouble(txtFullTimeStatus.getText());
					Job newJob = new Job(txtTitle.getText(), txtCompany.getText(), salary, fte, txtDescription.getText());
					jobList.insert(newJob);
					JOptionPane.showMessageDialog(null, "Job Posting Added.");
					clearAllFields();
				}
			//Clear button clears all fields
			} else if (e.getSource() == btnClear) {
				clearAllFields();
			//Back to main button directs back to the main menu
			} else if (e.getSource() == btnBackToMain) {
				MainMenuJPanel newPanel = new MainMenuJPanel(jobList);
				sendToNewPanel(newPanel);
			}

		}

		/**
		 * The method to clear all of the text fields
		 */
		private void clearAllFields() {
			txtTitle.setText("");
			txtCompany.setText("");
			txtSalary.setText("");
			txtFullTimeStatus.setText("");
			txtDescription.setText("");
		}
		
		/**
		 * @param newPanel
		 * The method to send to a different panel
		 */
		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);

		}
		
		/**
		 * @return
		 * The method to check all fields in the form and if any of the input is
		 * invalid, it adds the error message to the string that is returned
		 */
		private String validateForm() {
			String returnString = "";
			if(txtTitle.getText().length() == 0) {
				returnString += "Title is required.\n";
			}
			if(txtCompany.getText().length() == 0) {
				returnString += "Company is required.\n";
			}
			if(txtSalary.getText().length() == 0) {
				returnString += "Salary is required.\n";
			}
			try {
				double salary = Double.parseDouble(txtSalary.getText());
			} catch(Exception e) {
				returnString += "Desired Salary must be a valid number.\n";
			}
			if(txtFullTimeStatus.getText().length() == 0) {
				returnString += "Full Time Equivalent is required.\n";
			}
			boolean successfulParse = true;
			double fte = 0;
			try {
				fte = Double.parseDouble(txtFullTimeStatus.getText());
			} catch(Exception e) {
				returnString += "Full Time Equivalent must be a valid number.\n";
				successfulParse = false;
			}
			if(successfulParse && (fte > 1 || fte <= 0)) {
				returnString += "Full Time Equivalent must be between .1 and 1.0 (1.0 = full time, 0.5 = part time).\n";
			}
			if(txtDescription.getText().length() == 0) {
				returnString += "Description is required.\n";
			}
			return returnString;
		}

	}

}
