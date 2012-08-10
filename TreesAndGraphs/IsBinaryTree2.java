package TreesAndGraphs;

import java.util.ArrayList;

public class IsBinaryTree2 {
	static int last_visited=Integer.MIN_VALUE;
	public static boolean isBinaryTree2(TreeNode t) {
		if(t==null) return true; // Tree is empty 
		
		if(!isBinaryTree2(t.left)) 
			return false;
		
		if(t.data<last_visited)
			return false;
		else
			last_visited=t.data;
		
		if(!isBinaryTree2(t.right)) 
			return false;
		
		return true; // All fine
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
		TreeNode t9=new TreeNode(76);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.left=t8;
		t7.left=t9;
		
		if(IsBinaryTree2.isBinaryTree2(t1))
				System.out.println("Given tree is a binary tree!");
		else
			System.out.println("Given tree is not a binary tree!");	
	}
}
