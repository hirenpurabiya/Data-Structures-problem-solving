package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity=5;
	
	public void push(int value) {
		Stack last = getLastStack();
		System.out.println(last);
		if(last!=null && last.size()<capacity) {
			last.push(value);
		} else {
			Stack s=new Stack();
			s.push(value);
			stacks.add(s);
		} 
	}
	
	public Integer pop() {
		Stack last = getLastStack();
		if(last==null) return null;
		Integer i = (Integer) last.pop();
		if(last.size()==0) stacks.remove(last);
		return i;
	}
	
	public Stack getLastStack() {
		if(stacks.size()==0) 
			return null;
		else 
			return stacks.get(stacks.size()-1);
	}

	public static void main(String args[]) {
		SetOfStacks a = new SetOfStacks();
		a.push(10);
		a.push(20);
		a.push(30);
		a.push(40);
		a.push(50);
		a.push(60);
		a.push(70);
		
		System.out.println("ArrayList size: "+a.stacks.size());
		System.out.println((a.stacks.get(a.stacks.size()-2)).peek());
		System.out.println(a.getLastStack().peek());
		
		a.pop();
		a.pop();
		a.pop();
		
		System.out.println("ArrayList size: "+a.stacks.size());
		System.out.println(a.getLastStack().peek());
	}	
}
