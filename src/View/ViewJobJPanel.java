package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.Link;
import Controller.LinkedList;

/**
 * This class has the JPanel for the page to view the selected job posting
 */
public class ViewJobJPanel extends JPanel {
	
	JTextArea list;
	JScrollPane scroll;
	private JButton btnBackToMain;
	private JButton btnApply;
	private JButton btnViewApplicants;
	private LinkedList jobList;
	private Link jobLink;

	/**
	 * Create the panel.
	 */
	public ViewJobJPanel(LinkedList jobs, Link job) {
		
		this.jobList = jobs;
		this.jobLink = job;
		JPanel form = new JPanel();
		JLabel title = new JLabel("DETAILS FOR JOB");
		
		@SuppressWarnings("unchecked")
		//Calling the link method to return the string for the individual job
		String jobPost = jobLink.toString();
		
		//Displaying the job string on the page
		JTextArea commentTextArea = new JTextArea(jobPost,5,20);
	
		scroll = new JScrollPane(commentTextArea);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(450, 200));
        
        //Creating and adding the button listener to the back to main,
        //apply, and view applicants buttons
        btnBackToMain = new JButton("Back to Main");
        btnApply = new JButton("Apply For This Job");
        btnViewApplicants = new JButton("View All Applicants");
        ButtonListener bl = new ButtonListener();
        btnBackToMain.addActionListener(bl);
        btnApply.addActionListener(bl);
        btnViewApplicants.addActionListener(bl);
        
        //Adding the buttons and scroll big text area to the panel
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		buttons.add(btnBackToMain, BorderLayout.NORTH);
		buttons.add(btnViewApplicants, BorderLayout.CENTER);
		buttons.add(btnApply, BorderLayout.SOUTH);
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
			//Apply button
			} else if(e.getSource() == btnApply) {
				//If the applicant queue is full, display an error message
				if(jobLink.job.applicantQueue.getTotalSize() == 20) {
					JOptionPane.showMessageDialog(null, "The applicant queue for this posting is full.\nNo additional applicants are being accepted.");
				//If not full, then send them to the panel to apply
				} else {
					newPanel = new AddApplicantJPanel(jobList, jobLink);
					sendToNewPanel(newPanel);
				}
			//View applicants button
			} else if(e.getSource() == btnViewApplicants) {
				//If the applicant queue is empty, display an error message
				if(jobLink.job.applicantQueue.getTotalSize() == 0) {
					JOptionPane.showMessageDialog(null, "There are currently no applicants to view.");
				//If the applicant queue is not empty, send them to the page to view the applicants
				} else {
					newPanel = new ViewAllApplicantsJPanel(jobList, jobLink);
					sendToNewPanel(newPanel);
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
		
	}
}
