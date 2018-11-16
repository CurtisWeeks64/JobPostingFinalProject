package TestMains;
import Controller.JobApplicantPopulator;
import Controller.LinkedList;
import Model.Job;

public class TesterModelControllerMain {

	public static void main(String[] args) {
		
		JobApplicantPopulator populator = new JobApplicantPopulator();
		LinkedList list = populator.populate();
		
		list.displayList();
		System.out.println(list.determineSize());
		
		list.sortBySalaryHighToLow();
		list.displayList();
		System.out.println("");
		
		list.sortByTitle();
		list.displayList();
		System.out.println("");
		
		list.sortByCompany();
		list.displayList();
		System.out.println("");
	}

}
