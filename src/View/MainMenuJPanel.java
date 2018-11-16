package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class MainMenuJPanel extends JPanel {

	JButton btnAddNewJob = new JButton("Add Job Posting");
	private final JButton btnViewAllJobs = new JButton("View All Job Postings");

	/**
	 * Create the panel.
	 */
	public MainMenuJPanel() {
		
		JLabel instructions = new JLabel(" SELECT AN OPTION TO CONTINUE ");
		
		ButtonListener bl = new ButtonListener();
		btnAddNewJob.addActionListener(bl);
		btnViewAllJobs.addActionListener(bl);
		
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
			if (e.getSource() == btnAddNewJob) {
//				newPanel = new AddInstructorJPanel();
			} else if (e.getSource() == btnViewAllJobs) {
				newPanel = new ViewAllJobsJPanel();
			}
			
			sendToNewPanel(newPanel);

		}

		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);

		}
		
	}

}

