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
 * This class has the JPanel for the page to view all the applicants of the selected job posting
 */
public class ViewAllApplicantsJPanel extends JPanel {
	
	JTextArea list;
	JScrollPane scroll;
	private JButton btnBackToMain;
	private JButton btnViewJob;
	private LinkedList jobList;
	private Link jobLink;

	/**
	 * Create the panel.
	 */
	public ViewAllApplicantsJPanel(LinkedList jobs, Link job) {
		
		this.jobList = jobs;
		this.jobLink = job;
		
		JPanel form = new JPanel();
		JLabel title = new JLabel("APPLICANTS FOR THIS JOB");
		
		@SuppressWarnings("unchecked")
		
		//Calling the queue method to return all applicants in the queue as a string
		String allApplicants = jobLink.job.applicantQueue.toString();
		
		//Displaying the applicants string on the page
		JTextArea commentTextArea = new JTextArea(allApplicants,5,20);
	
		scroll = new JScrollPane(commentTextArea);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(450, 200));
      
        //Creating and adding the button listener to the view job and back to main buttons
        btnBackToMain = new JButton("Back to Main");
        btnViewJob = new JButton("Back To Job Posting");
        ButtonListener bl = new ButtonListener();
        btnBackToMain.addActionListener(bl);
        btnViewJob.addActionListener(bl);
        
        //Adding the buttons and scroll big text area to the panel
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		buttons.add(btnBackToMain, BorderLayout.SOUTH);
		buttons.add(btnViewJob, BorderLayout.NORTH);
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
			//Go back to selected job button
			} else if(e.getSource() == btnViewJob) {
				newPanel = new ViewJobJPanel(jobList, jobLink);
				sendToNewPanel(newPanel);
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
		
	}

}
