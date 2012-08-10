package StacksAndQueues;

public class Queues {
	Node first, last;
	
	public void enqueue(Node n) {
		if(first==null) {
			last=new Node(n.data);
			first=last;
		} else {
			last.next=n;
			last=last.next;
		}
	}
	
	public Node dequeue() {
		if(first==null)
			return null;
		else {
			Node n=first;
			first=first.next;
			return n;
		}
	}

}
