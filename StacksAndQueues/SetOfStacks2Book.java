package StacksAndQueues;

import java.util.ArrayList;

class StackBook {
	private int capacity;
	public Node top, bottom;
	public int size=0;
	
	public StackBook(int capacity) {
		this.capacity=capacity;
	}
	
	public boolean isAtCapacity() {
		return size == capacity;
	}
	
	public void join(Node above, Node below) {
		if(below!=null) 
			below.above = above;
		if(above!=null) 
			above.below = below;
	}
	
	public boolean push(int v) {
		if(size>=capacity)
			return false;
		size++;
		Node n=new Node(v);
		if(size==1)
			bottom=n;
		join(n, top);
		top=n;
		return true;
	}
	
	public int pop() {
		Node t = top;
		top = top.below;
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

public class SetOfStacks2Book {
	ArrayList<StackBook> stacks = new ArrayList<StackBook>();
	public int capacity;
	
	public SetOfStacks2Book(int capacity) {
		this.capacity=capacity;
	}
	
	public StackBook getLastStack() {
		if(stacks.size()==0)
			return null;
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int v) {
		StackBook last=getLastStack();
		if(last!=null && !last.isAtCapacity()) {
			last.push(v);
		} else {
			StackBook stack=new StackBook(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		StackBook last=getLastStack();
		//System.out.println(stacks.size());
		int v=last.pop();
		if(last.size==0)
			stacks.remove(stacks.size()-1);
		return v;
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		StackBook stack = stacks.get(index);
		int removed_item;
		if(removeTop) 
			removed_item=stack.pop();
		else
			removed_item=stack.removeBottom();
		
		if(stack.isEmpty()) {
			stacks.remove(index);
		} else if(stacks.size()>index+1) {
			int v=leftShift(index+1, false);
			stack.push(v);
		}
			
		return removed_item;
	}
	
	public Integer peek() {
		if(stacks.size()==0)
			return null;
		return (stacks.get(stacks.size()-1)).top.data;
	}
	
	public Integer peekAt(int index) {
		if(stacks.size()==0)
			return null;
		return (stacks.get(index)).top.data;
	}
	
	public static void main(String args[]) {
		SetOfStacks2Book a = new SetOfStacks2Book(5);
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
		
		a.pop();
		a.pop();
		a.pop();
		
		System.out.println("ArrayList size: "+a.stacks.size());
		System.out.println(a.peek());
	}
}

/*package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks2 {
	ArrayList<MyStack> stacks = new ArrayList<MyStack>();
	int capacity;
	
	public SetOfStacks2(int c) {
		capacity=c;
	}
	
	public void push(MyStack node) {
		MyStack last = getLastStack();
		System.out.println(last);
		if(last!=null && last.size()<capacity) {
			((MyStack)last.peek()).next=node;
			last.push(node.value);
		} else {
			MyStack s=new MyStack(node.value);
			if(stacks.size()>0) {
				MyStack lastStackTop = getTop(stacks.size()-1);
				lastStackTop.next=s;
			}
			s.push(novalue);
			stacks.add(s);
		} 
	}
	
	public Integer pop() {
		MyStack last = getLastStack();
		if(last==null) return null;
		Integer i = (Integer) last.pop();
		if(last.size()==0) stacks.remove(last);
		return i;
	}
	
	public Integer popFromStack(int stackNo) {
		if(stacks.size()<stackNo) {
			System.out.println("Sorry total set of stacks is less than the entered stack number!");
			return null;
		} else {
			MyStack nextStackBottom = ((MyStack)stacks.get(stackNo).peek()).next;
			MyStack newNextStackBottom = ((MyStack)stacks.get(stackNo).peek()).next.next;
			Integer i = (Integer)stacks.get(stackNo).pop();
			stacks.remove(((MyStack)stacks.get(stackNo).peek()).next);
			stacks.get(stackNo).push(nextStackBottom);
			((MyStack)stacks.get(stackNo).peek()).next=newNextStackBottom;
			return i;
		}
	}
	
	public MyStack getTop(int stackNo) {
		if(stacks.size()<stackNo) {
			System.out.println("Sorry total set of stacks is less than the entered stack number!");
			return null;
		} else {
			return (MyStack) stacks.get(stackNo).peek();
		}
	}
	
	private MyStack getLastStack() {
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

class MyStack extends Stack {
	MyStack next=null;
	int value;
	public MyStack(int v) {
		value=v;
	}
}*/