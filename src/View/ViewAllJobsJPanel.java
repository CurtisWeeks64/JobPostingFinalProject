package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.Link;
import Controller.LinkedList;

/**
 * This class has the JPanel for the page to view all the job postings
 */
public class ViewAllJobsJPanel extends JPanel {
	
	JTextArea list;
	JScrollPane scroll;
	private JButton btnBackToMain;
	private JButton btnViewJob;
	private JButton btnSort;
	private JTextField jobNumberField = new JTextField(4);
	private LinkedList jobList;
	private JComboBox comboBoxSort;

	/**
	 * Create the panel.
	 */
	public ViewAllJobsJPanel(LinkedList jobs) {
		
		this.jobList = jobs;
		JPanel form = new JPanel();
		JLabel title = new JLabel("DETAILS FOR ALL JOBS");
		
		//Calling the linked list method to sort the jobs by job number before displaying
		jobList.sortByJobNumber();
		
		@SuppressWarnings("unchecked")
		//Calling the linked list method to return all jobs as a string
		String allJobs = jobList.displayList();
		
		//Displaying the jobs string on the page
		JTextArea commentTextArea = new JTextArea(allJobs,5,20);
	
		scroll = new JScrollPane(commentTextArea);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(450, 200));
        
        //Creating and adding the button listener to the back to main,
        //view job, and sort buttons. Also adding the values to the drop
        //down for the different ways to sort
        btnBackToMain = new JButton("Back to Main");
        btnViewJob = new JButton("View Job");
        btnSort = new JButton("Sort");
        JLabel selectJobLabel = new JLabel("Job number to view: ");
        JLabel selectSortLabel = new JLabel("Sort by:");
        comboBoxSort = new JComboBox(new String[] {"Job Number", "Salary", "Job Title", "Company Name"});
        ButtonListener bl = new ButtonListener();
        btnBackToMain.addActionListener(bl);
        btnViewJob.addActionListener(bl);
        btnSort.addActionListener(bl);
        
        //Adding the buttons and scroll big text area to the panel
		JPanel buttons = new JPanel();
		JPanel buttonSort = new JPanel();
		buttons.setLayout(new BorderLayout());
		buttonSort.setLayout(new BorderLayout());
		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		buttonSort.add(selectSortLabel, BorderLayout.WEST);
		buttonSort.add(comboBoxSort, BorderLayout.CENTER);
		buttonSort.add(btnSort, BorderLayout.EAST);
		buttons.add(buttonSort, BorderLayout.NORTH);
		buttons.add(btnBackToMain, BorderLayout.SOUTH);
		buttons.add(selectJobLabel, BorderLayout.WEST);
		buttons.add(jobNumberField, BorderLayout.CENTER);
		buttons.add(btnViewJob, BorderLayout.EAST);
		form.add(buttons, BorderLayout.SOUTH);
		
		add(form);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			//Back to main button
			if(e.getSource()==btnBackToMain){
		        newPanel = new MainMenuJPanel(jobList);
				sendToNewPanel(newPanel);
			//View the specific job button
			} else if(e.getSource() == btnViewJob) {
				//validate the job number input is valid
				Link selectedLink = validateNumber();
				//If job number invalid, display error message
				if(selectedLink == null) {
					JOptionPane.showMessageDialog(null, "Invalid job number");
					jobNumberField.setText("");
				//if job number valid, send to the panel to view the individual job
				} else {
					newPanel = new ViewJobJPanel(jobList, selectedLink);
					sendToNewPanel(newPanel);
				}
			//Sort button
			} else if(e.getSource()==btnSort) {
				//Get the selected sort from the drop down box
				String selected = (String)comboBoxSort.getSelectedItem();
				//Sort by job number
				if(selected.equals("Job Number")){
					jobList.sortByJobNumber();
					String output = jobList.displayList();
					JTextArea outText = new JTextArea(output,5,20);
					scroll.setViewportView(outText);
				//Sort by salary
				} else if(selected.equals("Salary")){
					jobList.sortBySalaryHighToLow();
					String output = jobList.displayList();
					JTextArea outText = new JTextArea(output,5,20);
					scroll.setViewportView(outText);
				//Sort by job title
				} else if(selected.equals("Job Title")){
					jobList.sortByTitle();
					String output = jobList.displayList();
					JTextArea outText = new JTextArea(output,5,20);
					scroll.setViewportView(outText);
				//Sort by company name
				} else if(selected.equals("Company Name")){
					jobList.sortByCompany();
					String output = jobList.displayList();
					JTextArea outText = new JTextArea(output,5,20);
					scroll.setViewportView(outText);
				}
			}
			
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
		 * Validate the job number input is a valid and existing job number
		 */
		public Link validateNumber() {
			Link selectedLink = null;
			int number = 0;
			String jobString = jobNumberField.getText();
			try {
				number = Integer.parseInt(jobString);
			} catch(Exception e) {
				return selectedLink;
			}
			selectedLink = jobList.findJobNumber(number);
			return selectedLink;
		}
		
	}

}
