package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class Day10_MinStack {
	
	private static List<Integer> stack;
	
	public Day10_MinStack() {
		stack = new ArrayList<>();
	}
	
	public void push(int x) {
		stack.add(x);
	}
	
	public void pop() {
		stack.remove(stack.size()-1);
	}
	
	public int top() {
		
		return stack.get(stack.size()-1);
	}
	
	public int getMin() {
		
		int min = stack.get(0);
		
		for (int item : stack) {
			if (item < min) {
				min = item;
			}
		}
		
		return min;
	}
	
	public static void printStack() {
		
		System.out.print("[ ");
		
		for (int i=0; i<stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
		
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Day10_MinStack myStack = new Day10_MinStack();
		
		myStack.push(151);
		myStack.push(12);
		myStack.push(-2);
		myStack.push(14);
		myStack.push(58);
		
		printStack();
		
		myStack.pop();
		
		int topElement = myStack.top();
		int minimumElement = myStack.getMin();
		
		printStack();
		
		System.out.println("Top Element: " + topElement);
		System.out.println("Min Element: " + minimumElement);
		
	}

}
