package StacksAndQueues;

import java.util.Stack;

public class SortStack {
	public Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp=s.pop();
			while(!r.isEmpty() && r.peek()>tmp) 
				s.push(r.pop());
			r.push(tmp);
		}
		return r;
	}
	
	public static void main(String args[]) {
		SortStack ss=new SortStack();
		Stack<Integer> s=new Stack<Integer>();
		s.push(5);
		s.push(-1);
		s.push(100);
		s.push(6);
		s.push(21);
		s.push(-10);
		s.push(71);
		s.push(0);
		
		System.out.println(ss.sort(s));
	}
}
