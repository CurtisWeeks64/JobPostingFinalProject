package View;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.Link;
import Controller.LinkedList;
import Model.Applicant;

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
 * This class has the JPanel for the page to add an applicant to the selected job
 */
public class AddApplicantJPanel extends JPanel {
	private JTextField txtApplicantName;
	private JTextField txtApplicantCurrentTitle;
	private JTextField txtDesiredSalary;
	private JTextField txtEducationLevel;
	private JTextArea txtWorkHistory;
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnBackToMain = new JButton("Back to Main Menu");
	LinkedList jobList;
	Link jobLink;
	
	/**
	 * Create the panel.
	 */
	public AddApplicantJPanel(LinkedList jobs, Link job) {

		this.jobList = jobs;
		this.jobLink = job;
		
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
		JLabel lblApplyDesc = new JLabel("Enter Below Information To Apply");
		add(lblApplyDesc, BorderLayout.NORTH);

		//Label for the applicant name
		JLabel lblApplicantName = new JLabel("Full Name:");
		form.add(lblApplicantName, "4, 6, right, default");

		//Text field for the applicant name
		txtApplicantName = new JTextField();
		form.add(txtApplicantName, "6, 6, fill, default");
		txtApplicantName.setColumns(10);

		//Label for the applicant current title
		JLabel lblApplicantCurrentTitle = new JLabel("Current Job Title:");
		form.add(lblApplicantCurrentTitle, "4, 8, right, default");

		//Text field for the applicant current title
		txtApplicantCurrentTitle = new JTextField();
		form.add(txtApplicantCurrentTitle, "6, 8, fill, default");
		txtApplicantCurrentTitle.setColumns(10);

		//Label for the applicant desired salary
		JLabel lblDesiredSalary = new JLabel("Desired Salary:");
		form.add(lblDesiredSalary, "4, 10, right, default");

		//Text field for the applicant desired salary
		txtDesiredSalary = new JTextField();
		form.add(txtDesiredSalary, "6, 10, fill, default");
		txtDesiredSalary.setColumns(10);
		
		//Label for the applicant education level
		JLabel lblEducationLevel = new JLabel("Highest Education Level:");
		form.add(lblEducationLevel, "4, 12, right, default");

		//Text field for the applicant education level
		txtEducationLevel = new JTextField();
		form.add(txtEducationLevel, "6, 12, fill, default");
		txtEducationLevel.setColumns(10);
		
		//Label for the applicant work history
		JLabel lblWorkHistory = new JLabel("Work History:");
		form.add(lblWorkHistory, "4, 14, right, default");

		//Text field for the applicant work history
		txtWorkHistory = new JTextArea();
		form.add(txtWorkHistory, "6, 14, fill, default");
		txtWorkHistory.setColumns(10);

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
				//Otherwise create a new applicant and add it to the applicant queue for the selected job. Send back to the job
				} else {
					double salary = Double.parseDouble(txtDesiredSalary.getText());
					Applicant newApplicant = new Applicant(txtApplicantName.getText(), txtApplicantCurrentTitle.getText(), salary, txtEducationLevel.getText(), txtWorkHistory.getText());
					jobLink.job.applicantQueue.insert(newApplicant);
					JOptionPane.showMessageDialog(null, "Application Submitted.");
					ViewJobJPanel newPanel = new ViewJobJPanel(jobList, jobLink);
					sendToNewPanel(newPanel);
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
			txtApplicantName.setText("");
			txtApplicantCurrentTitle.setText("");
			txtDesiredSalary.setText("");
			txtEducationLevel.setText("");
			txtWorkHistory.setText("");
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
			if(txtApplicantName.getText().length() == 0) {
				returnString += "Applicant Name is required.\n";
			}
			if(txtApplicantCurrentTitle.getText().length() == 0) {
				returnString += "Current Title is required.\n";
			}
			if(txtDesiredSalary.getText().length() == 0) {
				returnString += "Desired Salary is required.\n";
			}
			try {
				double salary = Double.parseDouble(txtDesiredSalary.getText());
			} catch(Exception e) {
				returnString += "Desired Salary must be a valid number.\n";
			}
			if(txtEducationLevel.getText().length() == 0) {
				returnString += "Education Level is required.\n";
			}
			if(txtWorkHistory.getText().length() == 0) {
				returnString += "Work History is required. If none, enter none.\n";
			}
			return returnString;
		}

	}

}
