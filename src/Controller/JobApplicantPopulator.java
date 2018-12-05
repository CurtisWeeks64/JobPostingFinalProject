package Controller;

import Model.Applicant;
import Model.Job;

/**
 * This class has a single method that populates jobs and applicants for the application run
 */
public class JobApplicantPopulator {
	
	public LinkedList list;
	
	public JobApplicantPopulator() {}
	
	/**
	 * This is the method to populate jobs and applicants
	 */
	public LinkedList populate() {
		
		list = new LinkedList();
		
		Job job1 = new Job("Factory Associate 1", "FactoriesRUs", 34000, 1, "Making the stuff for the consumers");
		list.insert(job1);
	
		Job job2 = new Job("Accounting Associate 1", "ZZZ Accounting", 54000, 1, "Keeping the books all day.");
		list.insert(job2);
	
		Job job3 = new Job("System Associate 1", "SystemsRUs", 28000, .5, "Help desk. Assist employees with laptop issues.");
		list.insert(job3);

		Job job4 = new Job("Desk Clerk", "ClerksRUs", 30000, .8, "Greet and process patients at the front desk.");
		list.insert(job4);
		
		Job job5 = new Job("Server", "iHob", 32000, 1, "Wait on tables and serve them their pancakes and burgers.");
		list.insert(job5);
	
		Job job6 = new Job("Data Analyst", "BigData BigCompany", 154000, 1, "Data mining with SQL and SAAS.");
		list.insert(job6);
	
		Job job7 = new Job("Brick Layer", "Moore Mortar and More", 48000, 1, "Lay a brick, put mortar on it.");
		list.insert(job7);

		Job job8 = new Job("Lumberjack", "Take 'Em All Tree Trimming", 52000, 1, "Hack away at trees.");
		list.insert(job8);
		
		Applicant applicant1 = new Applicant("Bob", "Finance Director", 48000, "Bachelors Degree",
				"Director of finance at a large company in Des Moines.");
		Applicant applicant2 = new Applicant("Joe", "Personal Trainer", 48000, "Bachelors Degree",
				"Training clients at Lifetime Athletic for 12 years.");
		Applicant applicant3 = new Applicant("Wanda", "Fireman", 48000, "Bachelors Degree",
				"Fireman with the Chicago Fire Department for 20 years.");
		Applicant applicant4 = new Applicant("Amelia", "Massage Therapist", 48000, "Bachelors Degree",
				"Massage therapist at Massage Heights for two years. Before that I worked at a hair salon for three years.");
		
		job1.applicantQueue.insert(applicant1);
		job1.applicantQueue.insert(applicant2);
		job1.applicantQueue.insert(applicant3);
		job1.applicantQueue.insert(applicant4);

		job2.applicantQueue.insert(applicant1);
		job2.applicantQueue.insert(applicant2);
		
		job4.applicantQueue.insert(applicant2);
		job4.applicantQueue.insert(applicant3);
		job4.applicantQueue.insert(applicant4);
		
		return list;
	}
}
