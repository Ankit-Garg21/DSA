package stack;

import java.util.Stack;

public class Parantheses {
	public static char[][] tokens = { { '(', ')' }, { '{', '}' }, { '[', ']' } };

	public boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			if (isOpen(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || !matches(stack.pop(), c)) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	private boolean matches(char open, char close) {
		for(char[] ch : tokens) {
			if(ch[0] == open)
				return ch[1] == close;
		}
		return false;
	}

	private boolean isOpen(char c) {
		for (char[] ch : tokens) {
			if(ch[0] == c)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String expression = "{[][]{{}{}{}}{(){}}}";
		Parantheses obj = new Parantheses();
		System.out.println(obj.isBalanced(expression));
	}
}
