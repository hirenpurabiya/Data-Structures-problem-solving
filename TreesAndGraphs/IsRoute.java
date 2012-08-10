package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import StacksAndQueues.Node;

public class IsRoute {
	public static enum State {
		Unvisited, Visiting, Visited; 
	}
	
	public static boolean search(ArrayList<GraphNode> graph, GraphNode start, GraphNode end) {
		
		if(graph==null || start==null || end==null) {
			System.out.println("1");
			return false;
		}
		else if(start==end) {
			System.out.println("2");
			return true;
		}
		else {
			System.out.println("3");

			LinkedList<GraphNode> stack=new LinkedList<GraphNode>(); // will behave as a stack
			
			for(GraphNode g: graph) {
				g.state=State.Unvisited;
			}
			
			stack.add(start);
			GraphNode n,a;
			while(!stack.isEmpty()) {
				System.out.println("4");

				n=stack.removeFirst(); // equals to pop()
				for(int i=0;i<n.adjacentNodes.size();i++) {
					System.out.println("5");

					a=n.adjacentNodes.get(i);
					if(a.state==State.Unvisited) {
						System.out.println("6");

						if(a.data==end.data) {
							System.out.println("7");

							return true;
						}
						else {
							System.out.println("8");

							a.state=State.Visiting;
							stack.add(a);
						}			
					}
				}
				n.state=State.Visited;
			}
		}
		System.out.println("9");

		return false;
	}
	
	public static void main(String args[]) {
		
		GraphNode a=new GraphNode(1);
		GraphNode b=new GraphNode(2);
		GraphNode c=new GraphNode(3);
		GraphNode d=new GraphNode(4);
		GraphNode e=new GraphNode(5);
		GraphNode f=new GraphNode(6);
		GraphNode g=new GraphNode(7);
		GraphNode h=new GraphNode(8);
		GraphNode i=new GraphNode(9);
		
		a.adjacentNodes.add(b); a.adjacentNodes.add(c);
		b.adjacentNodes.add(f);
		c.adjacentNodes.add(d); c.adjacentNodes.add(e);
		e.adjacentNodes.add(h);
		f.adjacentNodes.add(e);
		g.adjacentNodes.add(e);
		h.adjacentNodes.add(i);
		i.adjacentNodes.add(g);
		
		ArrayList<GraphNode> graph = new ArrayList<GraphNode>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);
		graph.add(i);
		
		if(IsRoute.search(graph, a, f))
			System.out.println("There exists a route between the given graph nodes for the given graph!");
		else 
			System.out.println("There doesn't exist a route between the given graph nodes for the given graph!");
		
	}
}
