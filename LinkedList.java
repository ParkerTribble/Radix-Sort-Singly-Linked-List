package BookSort;

public class LinkedList {
	private Node head = null;
	private Node tail = null;
	
	public void insertFront(Node t) {
		if (head==null) tail = t;
		t.next = head;
		head = t;
	}
	
	public Node removeFront() {
		if (head==null) return null;
		Node t = head;
		head = head.next;
		if (head==null) tail = null;
		t.next = null;
		return t;
	}
	
	public void insertRear(Node t) {
		if (head==null) 
			head = t;
		else 
			tail.next = t;
		tail = t;
		tail.next = null;
	}
	
	public void print() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		Node q = head;
		while (q!=null) {
			System.out.println(q);
			q = q.next;
		}
	}
	public void append(LinkedList appendix){
		if(appendix.isempty()) return;
		if(isempty())
		{
		head = appendix.head;
		}
		else{
			tail.next = appendix.head;
		}
		tail = appendix.tail;
		tail.next = null;
		appendix.head = null;
		appendix.tail = null;
	}
	
	public boolean isempty() {
		if(head == null && tail == null){
			return true;
		}else{
		return false;
		}
	}
	

	
	}

