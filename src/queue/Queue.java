package queue;

public class Queue {

	private static class Node {
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head == null;
	}

	public int keep() {
		if(head == null)
			return 0;
		return head.data;
	}
	
	public void add(int data) {
		Node node = new Node(10);
		if(tail != null)
			tail.next = node;
		tail = node;
		
		if(head == null)
			head = node;
	}
	
	public int remove() {
		if(head == null)
			return 0;
		int data = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		return data;
	}
}
