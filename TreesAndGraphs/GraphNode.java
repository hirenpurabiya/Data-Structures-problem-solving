package TreesAndGraphs;

import java.util.ArrayList;

public class GraphNode {
	ArrayList<GraphNode> adjacentNodes = new ArrayList<GraphNode>();
	int data;
	IsRoute.State state;
	public GraphNode(int d) {
		data=d;
	}
	
}
