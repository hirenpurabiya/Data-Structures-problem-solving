package TreesAndGraphs;

public class CommonAncestor {
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//if(p==null || q==null)
		//	return null;
		if(covers(root.left, p) && covers(root.left, q))
			return commonAncestor(root.left, p, q);
		if(covers(root.right, p) && covers(root.right, q))
			return commonAncestor(root.right, p, q);
		return root;
	}
 
	public static boolean covers(TreeNode root, TreeNode p) {
		if(root==null) return false;
		if(root==p) return true;
		return covers(root.left, p) || covers(root.right, p);
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
		TreeNode ancestor=CommonAncestor.commonAncestor(t1, t8, t10);
		if(ancestor!=null)
			System.out.println(ancestor.data);
		else
			System.out.println(ancestor);
	}
}