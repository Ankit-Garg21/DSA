package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Node {
	Node left, right;
	int data;
	HashMap<Integer, ArrayList<Integer>> vertical = new HashMap<Integer, ArrayList<Integer>>();
	HashMap<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();

	public Node(int data) {
		this.data = data;
	}

	class QItem {
		Node node;
		int horizontalDistance;

		public QItem(Node node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}

	public boolean contains(int value) {
		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null)
				return false;
			return left.contains(value);
		} else {
			if (right == null)
				return false;
			return right.contains(value);
		}
	}

	public void printInorder() {
		if (left != null) {
			left.printInorder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.printInorder();
		}
	}

	public void printPreorder() {
		System.out.print(data + " ");
		if (left != null) {
			left.printPreorder();
		}
		if (right != null) {
			right.printPreorder();
		}
	}

	public void printPostorder() {
		if (left != null) {
			left.printPostorder();
		}
		if (right != null) {
			right.printPostorder();
		}
		System.out.print(data + " ");
	}

	public void levelOrderTraversal(Node root) {
		int height = height(root);
		for(int i=0; i<height; i++) {
			printLevel(root, i);
		}
	}
	
	public void printLevel(Node node, int level) {
		if(node == null)
			return;
		if(level == 0)
			System.out.print(node.data + " ");
		else if(level > 0) {
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}
	
	public int height(Node node) {
		if(node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if(leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	public Node parseVertical(Node root, int level) {
		ArrayList<Integer> values;
		if (root == null) {
			return null;
		}
		Node left = parseVertical(root.left, --level);
		if (left == null) {
			level++;
		}
		if (vertical.get(level) != null) {
			values = vertical.get(level);
			values.add(root.data);
			vertical.put(level, values);
			verticalSum.put(level, verticalSum.get(level) + root.data);
		} else {
			values = new ArrayList<Integer>();
			values.add(root.data);
			vertical.put(level, values);
			verticalSum.put(level, root.data);
		}
		return parseVertical(root.right, ++level);
	}

	public void printVertical() {
		Set<Integer> keys = vertical.keySet();
		for (int key : keys) {
			System.out.println(vertical.get(key));
		}
	}

	public void printVerticalSum() {
		Set<Integer> keys = verticalSum.keySet();
		for (int key : keys) {
			System.out.println(verticalSum.get(key));
		}
	}

	public void printTopView(Node root) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (root == null)
			return;
		Queue<QItem> q = new LinkedList<QItem>();
		q.add(new QItem(root, 0));

		while (!q.isEmpty()) {
			QItem qItem = q.remove();
			int horizontalDistance = qItem.horizontalDistance;

			if (!set.contains(horizontalDistance)) {
				set.add(horizontalDistance);
				System.out.print(qItem.node.data + " ");
			}

			if (qItem.node.left != null) {
				q.add(new QItem(qItem.node.left, horizontalDistance - 1));
			}
			if (qItem.node.right != null) {
				q.add(new QItem(qItem.node.right, horizontalDistance + 1));
			}
		}
	}

	public void printBottomView(Node root) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (root == null)
			return;
		Queue<QItem> q = new LinkedList<QItem>();
		q.add(new QItem(root, 0));

		while (!q.isEmpty()) {
			QItem qItem = q.remove();
			int horizontalDistance = qItem.horizontalDistance;

			map.put(horizontalDistance, qItem.node.data);

			if (qItem.node.left != null) {
				q.add(new QItem(qItem.node.left, horizontalDistance - 1));
			}
			if (qItem.node.right != null) {
				q.add(new QItem(qItem.node.right, horizontalDistance + 1));
			}
		}

		Set<Integer> keys = map.keySet();
		for (int key : keys) {
			System.out.print(map.get(key) + " ");
		}
	}

	int max_level = 0;
	public void printLeftView(Node node, int level) {
		if (node == null)
			return;
		if(max_level < level) {
			max_level = level;
			System.out.print(node.data + " ");
		}
		printLeftView(node.left, level+1);
		printLeftView(node.right, level+1);
	}
	
	public void printRightView(Node node, int level) {
		if (node == null)
			return;
		if(max_level < level) {
			max_level = level;
			System.out.print(node.data + " ");
		}
		printRightView(node.right, level+1);
		printRightView(node.left, level+1);
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.insert(1);
		root.insert(3);
		root.insert(10);
		root.insert(2);
		root.insert(4);
		root.insert(8);
		root.insert(9);
		root.insert(6);
		root.insert(7);

		//root.printInorder();
		//root.printPreorder();
		//root.printPostorder();

//		 root.parseVertical(root, 0);
//		 root.printVertical();
		// root.printVerticalSum();

		//root.printTopView(root);
		//root.printBottomView(root);
		
		//root.levelOrderTraversal(root);
		
		//root.printLeftView(root, 1);
		//root.printRightView(root, 1);
	}
}