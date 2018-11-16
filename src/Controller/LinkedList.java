package Controller;
import Model.Job;

public class LinkedList {
	
	private Link first;
	private Link last;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void insert(Job job) {
		Link newLink = new Link(job);
		
		if(isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	/* Regular insert is more appropriate
	public void insert(Job job) {
		
		Link newLink = new Link(job);
		Link previous = null;
		Link current = first;
		
		while(current != null && current.job.getTitle().compareToIgnoreCase(newLink.job.getTitle())<0) {
			previous = current;
			current = current.next;
		}
		
		if(previous==null) {
			first = newLink;
		} else {
			previous.next = newLink;
		}
		newLink.next = current;
	} */
	
	public Link deleteFirst() {
		Link temp = first;
		if(first.next == null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
	public String generateListString() {
		String returnString = "";
		Link current = first;
		while(current != null) {
			returnString += current.toString() + "\n\n";
			current = current.next;
		}
		
		return returnString;
	}

	public int determineSize() {
		int counter = 0;
		Link current = first;
		
		while(current != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}
	
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
}
