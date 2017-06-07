package linkedlist;

import java.util.ArrayList;

public class LinkedList {
	Node head;
	
	public class Node {
		Node next;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void display() {
		if(head == null)
			return;
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public void append(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void prepend(int data) {
		Node nHead = new Node(data);
		nHead.next = head;
		head = nHead;
	}
	
	public void delete(int data) {
		if(head == null)
			return;
		if(head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public boolean hasycle() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		if(head == null)
			return false;
		Node current = head;
		while(current != null) {
			if(nodes.contains(current))
				return true;
			nodes.add(current);
			current = current.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.append(10);
		linkedList.append(11);
		linkedList.append(19);
		linkedList.append(1);
		linkedList.append(6);
		
		linkedList.delete(19);
		
		linkedList.prepend(8);
		linkedList.append(6);
		
		linkedList.display();
		
		System.out.println(linkedList.hasycle());
	}
}
