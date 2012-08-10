package TreesAndGraphs;

public class CommonAncestor2 {
	static int TWO_NODES_FOUND=2;
	static int ONE_NODE_FOUND=1;
	static int NO_NODES_FOUND=0;
	
	// Checks how many "special" nodes are located under this root
	int covers(TreeNode root, TreeNode p, TreeNode q) {
		int ret=NO_NODES_FOUND;
		if(root==null) return ret;
		if(root==p || root==q) ret+=1;
		ret+=covers(root.left, p, q);
		if(ret==2) return ret;
		return ret+covers(root.right, p, q);
	}
	
	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p==q && (root.left==q || root.right==q)) return root;
		
		int nodesFromLeft=covers(root.left, p, q);
		if(nodesFromLeft==TWO_NODES_FOUND) {
			if(root.left==p || root.left==q) return root.left;
			else return commonAncestor(root.left, p, q);
		} else if(nodesFromLeft==ONE_NODE_FOUND) {
			if(root==p) return p;
			else if(root==q) return q;
		}
		
		int nodesFromRight=covers(root.right, p, q);
		if(nodesFromRight==TWO_NODES_FOUND) {
			if(root.right==p || root.right==q) return root.right;
			else return commonAncestor(root.right, p, q);
		} else if(nodesFromRight==ONE_NODE_FOUND) {
			if(root==p) return p;
			else if(root==q) return q;
		}
		
		if(nodesFromLeft==ONE_NODE_FOUND || nodesFromRight==ONE_NODE_FOUND) {
			return root;
		} else return null;
	}
	
	public static void main(String args[]) {
		TreeNode t1=new TreeNode(50);
		TreeNode t2=new TreeNode(25);
		TreeNode t3=new TreeNode(75);
		TreeNode t4=new TreeNode(12);
		TreeNode t5=new TreeNode(37);
		TreeNode t6=new TreeNode(62);
		TreeNode t7=new TreeNode(87);
		TreeNode t8=new TreeNode(6);
		TreeNode t9=new TreeNode(77);
		
		t1.left=t2; t1.right=t3;
		t2.left=t4; t2.right=t5; //t2.parent=t1;
		t3.left=t6; t3.right=t7; //t3.parent=t1;
		t4.left=t8; //t4.parent=t2;
		//t5.parent=t2;
		//t6.parent=t3;
		t7.left=t9; //t7.parent=t3;
		//t8.parent=t4;
		//t9.parent=t7;
		TreeNode t10=new TreeNode(34);
		TreeNode ancestor=CommonAncestor.commonAncestor(t1, t8, t5);
		if(ancestor!=null)
			System.out.println(ancestor.data);
		else
			System.out.println(ancestor);
	}

}
