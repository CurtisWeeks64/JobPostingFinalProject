
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
	
	public void insert(Applicant a) {
		if(totalSize < SIZE) {
			if(rear == SIZE-1) {
				rear = -1;
			}
			queArray[++rear] = a;
			totalSize++;
		}
	}
	
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
	
	public boolean isEmpty() {
		return totalSize == 0;
	}

}
