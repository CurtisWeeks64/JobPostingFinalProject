package Start;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.JobApplicantPopulator;
import Controller.LinkedList;
import View.MainMenuJPanel;
import View.ViewAllJobsJPanel;

import javax.swing.JButton;
import java.awt.GridLayout;

public class StartMain {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JobApplicantPopulator pop = new JobApplicantPopulator();
		LinkedList jobList = pop.populate();
		JFrame frame = new JFrame();
		MainMenuJPanel panel = new MainMenuJPanel(jobList);
		frame.add(panel);

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}