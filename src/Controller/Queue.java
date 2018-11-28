package Controller;
import Model.Applicant;

/**
 * This class is the queue data structure for the applicants of each job
 */
public class Queue {
	
	private final int SIZE = 20;
	private Applicant[] queArray;
	private int front;
	private int rear;
	private int totalSize;
	
	public Queue() {
		queArray = new Applicant[SIZE];
		front = 0;
		rear = -1;
		totalSize = 0;
	}
	
	/**
	 * @param a
	 * This method inserts a new applicant at the back of the queue
	 */
	public void insert(Applicant a) {
		if(totalSize < SIZE) {
			if(rear == SIZE-1) {
				rear = -1;
			}
			queArray[++rear] = a;
			totalSize++;
		}
	}
	
	/**
	 * @return
	 * This method removes the front applicant from the queue and returns that applicant
	 */
	public Applicant remove() {
		if(totalSize > 0) {
			Applicant temp = queArray[front++];
			if(front == SIZE) {
				front = 0;
			}
			totalSize--;
			return temp;
		}
		return null;
	}
	
	/**
	 * @return
	 * This method returns a boolean true if the queue is empty
	 */
	public boolean isEmpty() {
		return totalSize == 0;
	}
	
	/**
	 * @return
	 * This method returns the entire queue of applicants as a string
	 */
	public String toString() {
		String returnString = "";
		boolean stopLoop = true;
		for(int i = front; stopLoop ; i++) {
			returnString += queArray[i].toString() + "\n\n";
			if(i == SIZE-1 && i != rear) {
				i = -1;
			}
			if(i == rear) {
				stopLoop = false;
			}
		}
		return returnString;
	}
	
	/**
	 * @return
	 * This method returns the int that represents the total number of applicants in queue
	 */
	public int getTotalSize() {
		return this.totalSize;
	}

}
