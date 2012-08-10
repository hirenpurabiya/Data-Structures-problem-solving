package TreesAndGraphs;

public class IsSubtree {
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if(t2==null) return true; // Empty tree is always a subtree.
		else return subTree(t1, t2);
	}
	
	public static boolean subTree(TreeNode t1, TreeNode t2) {
		if(t1==null) return false; // Big tree is over. 
		if(t1.data==t2.data) return matchTree(t1, t2);
		return (subTree(t1.left, t2) || subTree(t1.right, t2));
		
	}

	private static boolean matchTree(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null)
			return true; // Both trees are empty.
		if(t1==null || t2==null) return false; // Big tree empty and subtree still not found.
		if(t1.data!=t2.data)
			return false;
		return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
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
		TreeNode t9=new TreeNode(3);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.left=t8;
		t7.left=t9;
		
		if(IsSubtree.containsTree(t1, t9))
			System.out.println("Given tree 2 is subtree of tree 1!");
		else 
			System.out.println("Given tree 2 is not subtree of tree 1!");
		
	}

}
