package Controller;

import Model.Applicant;
import Model.Job;

public class JobApplicantPopulator {
	
	public LinkedList list;
	
	public JobApplicantPopulator() {}
	
	public LinkedList populate() {
		
		list = new LinkedList();
		
		Job job1 = new Job("Factory Associate 1", "FactoriesRUs", 34000, 1, "Description");
		list.insert(job1);
	
		Job job2 = new Job("Accounting Associate 1", "ZAccountantsRUs", 54000, 1, "Description");
		list.insert(job2);
	
		Job job3 = new Job("System Associate 1", "SystemsRUs", 28000, .5, "Description");
		list.insert(job3);

		Job job4 = new Job("Desk Clerk", "ClerksRUs", 30000, .8, "Description");
		list.insert(job4);
		
		Job job5 = new Job("Server", "iHob", 32000, 1, "Description");
		list.insert(job5);
	
		Job job6 = new Job("Data Analyst", "BigData BigCompany", 154000, 1, "Description");
		list.insert(job6);
	
		Job job7 = new Job("Brick Layer", "Moore Mortar and More", 48000, 1, "Description");
		list.insert(job7);

		Job job8 = new Job("Lumberjack", "Take 'Em All Tree Trimming", 52000, 1, "Description");
		list.insert(job8);
		
		Applicant applicant1 = new Applicant("Bob", "Worker", 48000, "Bachelors Degree",
				"Lots of jobs");
		Applicant applicant2 = new Applicant("Joe", "Worker", 48000, "Bachelors Degree",
				"Lots of jobs");
		Applicant applicant3 = new Applicant("Wanda", "Worker", 48000, "Bachelors Degree",
				"Lots of jobs");
		Applicant applicant4 = new Applicant("Amelia", "Worker", 48000, "Bachelors Degree",
				"Lots of jobs");
		
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
