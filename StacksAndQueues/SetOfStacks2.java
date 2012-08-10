package StacksAndQueues;

import java.util.ArrayList;

class Stack2 {
	private int capacity;
	public Node top, bottom;
	public int size=0;
	
	public Stack2(int capacity) {
		this.capacity=capacity;
	}
	
	public boolean isAtCapacity() {
		return size==capacity;
	}
	
	public boolean push(int value) {
		if(size>=capacity)
			return false;
		size++;
		Node n = new Node(value);
		if(size==1)
			bottom=n;
		join(n, top);
		top=n;
		return true;	
	}
	
	private void join(Node above, Node below) {
		if(below!=null)
			below.above=above;
		if(above!=null)
			above.below=below;
	}
	
	public int pop() {
		Node t=top;
		top=top.below;
		size--;
		return t.data;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int removeBottom() {
		Node b=bottom;
		bottom=bottom.above;
		
		if(bottom!=null)
			bottom.below=null;
		size--;
		return b.data;
		
	}
}

public class SetOfStacks2 {
	private int capacity;
	private ArrayList<Stack2> stacks = new ArrayList<Stack2>();
	
	public SetOfStacks2(int capacity) {
		this.capacity=capacity;
	}
	
	public Stack2 getLastStack() {
		if(stacks.size()==0)
			return null;
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int value) {
		Stack2 last=getLastStack();
		if(last!=null && !last.isAtCapacity()) {
			last.push(value);
		} else {
			Stack2 s=new Stack2(capacity);
			s.push(value);
			stacks.add(s);
		}
	}
	
	public int pop() {
		Stack2 last=getLastStack();
		int value=last.pop();
		if(last.size==0) 
			stacks.remove(last);
		return value;
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack2 stack=stacks.get(index);
		int removed_item;
		
		if(removeTop) 
			removed_item=stack.pop();
		else 
			removed_item=stack.removeBottom();
		
		if(stack.isEmpty())
			stacks.remove(index);
		else if(stacks.size()>index+1) {
			int v=leftShift(index+1, false);
			stack.push(v);
		}
		
		return removed_item;	
	}
	
	public Integer peek() {
		if(stacks.size()==0) 
			return null;
		return stacks.get(stacks.size()-1).top.data;
	}
	
	public Integer peekAt(int index) {
		if(stacks.size()==0) 
			return null;
		return stacks.get(index).top.data;
	}
	
	public static void main(String args[]) {
		SetOfStacks2 a = new SetOfStacks2(2);
		a.push(10);
		a.push(20);
		a.push(30);
		a.push(40);
		a.push(50);
		a.push(60);
		a.push(70);
		
		System.out.println("ArrayList size: "+a.stacks.size());
		System.out.println(a.peek());
		System.out.println(a.peekAt(0));
		System.out.println(a.peekAt(1));
		System.out.println(a.peekAt(2));
		System.out.println(a.peekAt(3));
		
		a.pop();
		a.pop();
		a.pop();
		
		System.out.println("ArrayList size: "+a.stacks.size());
		System.out.println(a.peek());
	}
}