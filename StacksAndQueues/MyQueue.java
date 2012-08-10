package StacksAndQueues;

import java.util.Stack;

public class MyQueue<T> {
	Stack<T> s1, s2;
	
	public MyQueue() {
		s1=new Stack<T>();
		s2=new Stack<T>();
	}
	
	public int size() {
		return s1.size()+s2.size();
	}
	
	public void add(T value) {
		s1.push(value);
	}
	
	public T peek() {
		if(!s2.isEmpty()) return s2.peek();
		while(!s1.isEmpty()) s2.push(s1.pop());
		return s2.peek();
	}
	
	public T remove() {
		if(!s2.isEmpty()) return s2.pop();
		while(!s1.isEmpty()) s2.push(s1.pop());
		return s2.pop();
	}
	
	public static void main(String args[]) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.peek());
		System.out.println(q.s2);
		
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.s2);
		
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.s2);
		
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.s2);
	}
}



