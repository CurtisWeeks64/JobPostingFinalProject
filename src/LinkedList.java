
public class LinkedList {
	
	private Link first;
	
	public LinkedList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
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
	}
	
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
//		System.out.println("List of jobs in alphabetical order by job title: ");
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
//		System.out.println("");
	}

}
