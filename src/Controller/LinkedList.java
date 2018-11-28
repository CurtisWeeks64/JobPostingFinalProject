package Controller;
import Model.Job;

/**
 * This is the linked list of jobs
 */
public class LinkedList {
	
	private Link first;
	private Link last;
	private int jobCounter = 1000;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	/**
	 * @param job
	 * This method inserts a job at the end of the linked list
	 */
	public void insert(Job job) {
		Link newLink = new Link(job);
		newLink.job.setJobNumber(++jobCounter);
		if(isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	/**
	 * @return
	 * This method deletes the first job in the linked list
	 */
	public Link deleteFirst() {
		Link temp = first;
		if(first.next == null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	/**
	 * @return
	 * This method displays the entire list of jobs
	 */
	public String displayList() {
		String displayString = "";
		Link current = first;
		while(current != null) {
			displayString += current.toString() + "\n\n";
			current = current.next;
		}
		return displayString;
	}

	/**
	 * This method is used to sort jobs by salary
	 */
	public void sortBySalaryHighToLow() {
		Link root = first, current, highest;

		while(root.next != null) {
			highest = root;
			current = root.next;
			while(current != null) {
				if(current.job.getSalary() > highest.job.getSalary()) {
					highest = current;
				}
				current = current.next;
			}
			Job temp = root.job;
			root.job = highest.job;
			highest.job = temp;
			
			root = root.next;
		}
	}
	
	/**
	 * This method is used to sort jobs by job number
	 */
	public void sortByJobNumber() {
		Link root = first, current, lowest;

		while(root.next != null) {
			lowest = root;
			current = root.next;
			while(current != null) {
				if(current.job.getJobNumber() < lowest.job.getJobNumber()) {
					lowest = current;
				}
				current = current.next;
			}
			Job temp = root.job;
			root.job = lowest.job;
			lowest.job = temp;
			
			root = root.next;
		}
	}
	
	/**
	 * This method is used to sort jobs by job title
	 */
	public void sortByTitle() {
		Link root = first, current, highest;

		while(root.next != null) {
			highest = root;
			current = root.next;
			while(current != null) {
				if(current.job.getTitle().compareToIgnoreCase(highest.job.getTitle())<0) {
					highest = current;
				}
				current = current.next;
			}
			Job temp = root.job;
			root.job = highest.job;
			highest.job = temp;
			
			root = root.next;
		}
	}
	
	/**
	 * This method is used to sort jobs by comapny name
	 */
	public void sortByCompany() {
		Link root = first, current, highest;

		while(root.next != null) {
			highest = root;
			current = root.next;
			while(current != null) {
				if(current.job.getCompany().compareToIgnoreCase(highest.job.getCompany())<0) {
					highest = current;
				}
				current = current.next;
			}
			Job temp = root.job;
			root.job = highest.job;
			highest.job = temp;
			
			root = root.next;
		}
	}
	
	/**
	 * @param number
	 * @return
	 * This method is used to find the specific job using the job number as search criteria
	 */
	public Link findJobNumber(int number) {
		if(number < 1000) {
			return null;
		}
		Link current = first;
		while(current != null) {
			if(current.job.getJobNumber() == number) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
}
