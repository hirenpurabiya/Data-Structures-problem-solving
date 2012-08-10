package TreesAndGraphs;

public class IsBalanced {
	public int maxHeight(TreeNode t) {
		if(t==null)
			return 0;
		return 1+Math.max(maxHeight(t.left), maxHeight(t.right));
	}
	
	public int minHeight(TreeNode t) {
		if(t==null)
			return 0;
		return 1+Math.min(minHeight(t.left), minHeight(t.right));
	}
	
	public boolean isBalanced(TreeNode t) {
		return (maxHeight(t)-minHeight(t)) <= 1 ;
	}
	
	public static void main(String args[]) {
		IsBalanced i=new IsBalanced();
		
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
		
		if(i.isBalanced(t1))
			System.out.println("Given tree is balanced tree!");
		else 
			System.out.println("Given tree is not balanced tree!");
		
	}
}
