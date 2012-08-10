package LinkedLists;

import java.util.Hashtable;

public class Node {
	Node next=null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next!=null) {
			n=n.next;
		}
		n.next=end;
	}
	
	public Node deleteNode(Node head, int d) {
		Node n=head;
		if(n.data == d) {
			return head.next;
		}
		
		while(n.next!=null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n=n.next;
		}
		System.out.println("The node to be deleted doesn't exist in the given linked list!");
		return head;
	}
	
	public void printLinkedList() {
		Node n=this;
		System.out.println("Linked List: ");
		
		do {
			System.out.print(n.data+"->");
			n=n.next;
		} while(n.next!=null);	
		System.out.print(n.data);
	}
	
	public static void deleteDups(Node n) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node previous=null;
		while(n.next!=null) {
			if(table.containsKey(n.data)) {
				previous.next=n.next;
			} else {
				table.put(n.data, true);
				previous=n;
			}
			n=n.next;
		}
	}	
	
	public static void deleteDups2(Node n) {
		if(n==null) return;
		Node previous=n;
		Node current=previous.next;
		
		while(current!=null){
			Node runner=n;
			while(runner!=current) {
				if(runner.data==current.data) {
					Node temp = current.next;
					previous.next=temp;
					current=temp;
					break;
				}
				runner=runner.next;
			}
			if(runner==current) {
				previous=current;
				current=previous.next;
			}
		}
	}
	
	public static Node nthToLast(Node head, int n) {
		if(head==null || n<1)
			return null;
		int totalNodes=0;
		Node ll=head;
		while(ll!=null) {
			totalNodes++;
			ll=ll.next;
		}
		//System.out.println("\n"+totalNodes);
		ll=head;
		int nthToLastNode = totalNodes-n+1;
		//System.out.println(nthToLastNode);
		int nthNode=1;
		while(ll!=null) {
			if(nthNode==nthToLastNode){
				return ll;
			}
			ll=ll.next;
			nthNode++;
		}
		return null;
		/*
	 	Node p1=head, p2=head;
		for(int i=0;i<n-1;i++) {
			if(p2==null)
				return null; // the list was less than n elements
			p2=p2.next;
		}
		while(p2.next!=null) {
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
		*/
	}
	
	public static boolean deleteNode(Node n) {
		if(n==null) 
			return false;
		if(n.next==null) {
			n=null;
			return true;
		}
		Node next=n.next;
		n.data=next.data;
		n.next=next.next;
		return true;
	}
	
	public static Node addLists(Node n, Node m) {
		if(n==null && m==null)
			return null;
		
		int value=n.data+m.data;
		int carry=value/10;
		System.out.println("\nValue: "+value%10+", Carry: "+carry);

		Node result=new Node(value%10);
		Node sum=result;
		boolean done=true;
		while(done) {
			if(n.next!=null) {
				n=n.next;
				value=n.data;
			}
			
			if(m.next!=null) {
				m=m.next;
				value+=m.data;
			}
			
			value+=carry;
			carry=value/10;
			
			System.out.println("Value: "+value%10+", Carry: "+carry);
			if(carry==0 && n.next==null && m.next==null) 
				done=false;

			sum.next=new Node(value%10);
			sum=sum.next;
			value=0;
		}
		return result;	
	}
	
	public static Node findBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;
		
		while(n2.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
			if(n1==n2)
				break;
		}
		
		if(n2.next==null) {
			return null;
		}
		
		n1=head;
		while(n1!=n2) {
			n1=n1.next;
			n2=n2.next;
		}
		return n2;
	}
	
	public static void main(String args[]) {
		Node linkedList = new Node(1);
		linkedList.appendToTail(2);
		linkedList.appendToTail(3);
		linkedList.appendToTail(4);
		linkedList.appendToTail(5);
		linkedList.appendToTail(6);
		linkedList.appendToTail(7);
		linkedList.appendToTail(8);
		linkedList.appendToTail(9);
		linkedList.appendToTail(10);
		
		linkedList.printLinkedList();
		Node.deleteDups2(linkedList);
		linkedList.printLinkedList();
		
		Node nthToLastNode=Node.nthToLast(linkedList, 8);
		//System.out.println("\nThe 8th to last element in the link list is: "+nthToLastNode.data);
		
		if(Node.deleteNode(linkedList.next.next))
			linkedList.printLinkedList();
		
		
		Node n=new Node(0);
		Node m=new Node(0);
		
		n.appendToTail(0);
		n.appendToTail(0);
		
		m.appendToTail(0);
		m.appendToTail(0);
		
		int a = 18;
		//System.out.println("\nValue a/10: "+a/10);
		//System.out.println("Carry a%10: "+a%10);
		Node result = Node.addLists(n, m);
		result.printLinkedList();
		
		
		Node ll1 = new Node(1);
		Node ll2=new Node(2);
		Node ll3=new Node(3);
		Node ll4=new Node(4);
		Node ll5=new Node(5);
		Node ll6=new Node(6);
		Node ll7=new Node(7);
		Node ll8=new Node(8);
		Node ll9=new Node(9);
		Node ll10=new Node(10);
		
		ll1.next=ll2;
		ll2.next=ll3;
		ll3.next=ll4;
		ll4.next=ll5;
		ll5.next=ll6;
		ll6.next=ll7;
		ll7.next=ll8;
		ll8.next=ll9;
		ll9.next=ll10;
		ll10.next=ll6;
		
		Node loopBeginning=Node.findBeginning(ll1);

		if(loopBeginning!=null) {
			System.out.println("The starting point of the loop in the given link list is: "+loopBeginning.data);
		} else {
			System.out.println("The given link list has no loops!");			
		}
	}
}
