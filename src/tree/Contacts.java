package tree;

import java.util.HashMap;

public class Contacts {
	public class Node {
		HashMap<Character, Node> children = new HashMap<Character, Node>();
		boolean isCompleteWord;
		int noOfChildren = 0;
		
		private Node getNode(char c) {
			return children.get(c);
		}
		
		private void setNode(char c, Node node) {
			children.put(c, node);
		}
		
		private void add(String s) {
			add(s.toCharArray(), 0);
		}
		
		private void add(char[] str, int index) {
			noOfChildren++;
			if(index == str.length)
				return;
			char ch = str[index];
			Node child = getNode(ch);
			if(child == null) {
				child = new Node();
				setNode(ch, child);
			}
			child.add(str, index+1);
		}
		
		public int findCount(String str, int index) {
			if(index == str.length())
				return noOfChildren;
			Node child = getNode(str.charAt(index));
			if(child == null)
				return 0;
			return child.findCount(str, index+1);
		}
	}
	
	public static void main(String[] args) {
		Contacts contacts = new Contacts();
		Node node = contacts.new Node();
		node.add("ankit");
		node.add("abcd");
		System.out.println(node.findCount("a", 0));
	}
}
