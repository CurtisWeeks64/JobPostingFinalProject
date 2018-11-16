package Controller;
import Model.Job;

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