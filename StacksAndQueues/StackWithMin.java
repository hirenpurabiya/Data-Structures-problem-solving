package StacksAndQueues;

import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class StackWithMin extends Stack<NodeWithMin> {
	public void push(int value) {
		int min = Math.min(value, min());
		super.push(new NodeWithMin(value, min));
	}
	
	private int min() {
		if(this.isEmpty()) 
			return Integer.MAX_VALUE;
		else
			return peek().min;
	}
	public static void main(String args[]) {
		StackWithMin a = new StackWithMin();
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

class NodeWithMin {
	int value;
	int min;
	
	public NodeWithMin(int v, int m) {
		value=v;
		min=m;
	}
}
