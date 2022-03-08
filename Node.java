package BookSort;

public class Node {
	private static int serialNumber=0;	

	int id;
	String author, title, callNum;
	Node next=null;

	public Node(String author, String title, String callNum, Node next) {
		this.author = author;
		this.title = title;
		this.callNum = callNum;
		this.next = next;
		id = ++serialNumber;
	    
	}
	public Node() {
		id = ++serialNumber;
		this.author = "";
	}

	public String toString() {
			return callNum+author+title;
	}
}
