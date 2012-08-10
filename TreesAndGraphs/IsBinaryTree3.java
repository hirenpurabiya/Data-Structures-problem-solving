package TreesAndGraphs;

public class IsBinaryTree3 {
	
	public static boolean isBinaryTree3(TreeNode t) {
		return isBinaryTree3(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBinaryTree3(TreeNode t, int min, int max) {
		if(t==null) return true;
		
		if(t.data<min || t.data>max) return false;
		
		if(!isBinaryTree3(t.left, min, t.data) || !isBinaryTree3(t.right, t.data, max))
			return false;
		/*if(!isBinaryTree3(t.left, min, t.data)) return false;
		
		if(t.data<min || t.data>max) return false;
		
		if(!isBinaryTree3(t.right, t.data, max)) return false;
		*/
		return true;
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
		TreeNode t9=new TreeNode(79);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.left=t8;
		t7.left=t9;
		
		if(IsBinaryTree3.isBinaryTree3(t1))
				System.out.println("Given tree is a binary tree!");
		else
			System.out.println("Given tree is not a binary tree!");	
	}
}
