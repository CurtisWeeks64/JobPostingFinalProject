package Model;
import Controller.Queue;

/**
 * This is the class for the jobs
 */
public class Job {
	
	private int jobNumber;
	private String title;
	private String company;
	private double salary;
	private double fte; //Full time equivalent. 1=fulltime, .5=halftime.
	private String description;
	public Queue applicantQueue;
	
	public Job(String title, String company, double salary, double fte, String description) {
		super();
		this.title = title;
		this.company = company;
		this.salary = salary;
		this.fte = fte;
		this.description = description;
		applicantQueue = new Queue();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getFte() {
		return fte;
	}

	public void setFte(double fte) {
		this.fte = fte;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(int number) {
		this.jobNumber = number;
	}

	/**
	 * @return
	 * This method returns the individual job as a string
	 */
	public String toString() {
		return "Job number: " + jobNumber + ", Job title: " + title + ", Company: " + company + 
				"\nSalary: " + salary + ", Full Time Equivalent: " + fte + 
				"\nJob description: " + description;
	}	

}
