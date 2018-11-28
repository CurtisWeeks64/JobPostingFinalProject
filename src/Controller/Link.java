package Controller;
import Model.Job;

/**
 * This class is the link used for the linked list of jobs
 */
public class Link {
	
	public Job job;
	public Link next;
	
	public Link(Job job) {
		this.job = job;
	}
	
	public void displayLink() {
		System.out.println(job.toString());
	}
	
	public String toString() {
		return job.toString();
	}

}
