package StacksAndQueues;

public class Stacks {
	Node top;
	
	public Node pop() {
		if(top!=null) {
			Node n=top;
			top=top.next;
			return n;
		}
		return null;
	}
	
	public void push(Node n) {
		Node t=new Node(n.data);
		t.next=top;
		top=n;
	}
}
