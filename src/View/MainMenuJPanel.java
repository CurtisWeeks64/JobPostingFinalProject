package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LinkedList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class has the JPanel for the main menu page
 */
public class MainMenuJPanel extends JPanel {

	JButton btnAddNewJob = new JButton("Add Job Posting");
	private final JButton btnViewAllJobs = new JButton("View All Job Postings");
	private LinkedList jobList;

	/**
	 * Create the panel.
	 */
	public MainMenuJPanel(LinkedList jobs) {
		
		this.jobList = jobs;
		
		//Header title for the page
		JLabel instructions = new JLabel(" SELECT AN OPTION TO CONTINUE ");
		
		//Creating and adding the button listener to the submit, clear, and back to main buttons
		ButtonListener bl = new ButtonListener();
		btnAddNewJob.addActionListener(bl);
		btnViewAllJobs.addActionListener(bl);
		
		//Adding the buttons to the panel
		JPanel buttons = new JPanel();
		setLayout(new BorderLayout());
		add(instructions, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddNewJob);
		buttons.add(btnViewAllJobs);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			//Add new job button
			if (e.getSource() == btnAddNewJob) {
				newPanel = new AddJobPostingJPanel(jobList);
			//View all jobs button
			} else if (e.getSource() == btnViewAllJobs) {
				newPanel = new ViewAllJobsJPanel(jobList);
			}
			
			sendToNewPanel(newPanel);

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
		
	}

}

