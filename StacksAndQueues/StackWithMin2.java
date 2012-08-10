package StacksAndQueues;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2=new Stack<Integer>();
	}
	
	public void push(int value) {
		if(value<this.min())
			s2.push(value);
		super.push(value);
	}
	
	public Integer pop() {
		int value=super.pop();
		if(value==min())
			s2.pop();
		return value;
	}

	private int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}
	
	public static void main(String args[]) {
		StackWithMin2 a = new StackWithMin2();
		a.push(-1);
		a.push(100);
		a.push(34);
		a.push(-34);
		a.push(900);
		
		System.out.println("Minimum value in the stack is: "+a.min());
		
		a.pop();
		a.pop();
		System.out.println("Minimum value in the stack is: "+a.min());
	}
}
