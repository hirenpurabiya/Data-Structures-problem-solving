package TreesAndGraphs;

import java.util.ArrayList;

public class IsBinaryTree {
	static int index=0;
	public static void isBinaryTree(TreeNode t, int array[]) {
		if(t==null) return; 
		if(t.left!=null) isBinaryTree(t.left, array);
		array[index]=t.data;
		index++;
		if(t.right!=null) isBinaryTree(t.right, array);
		return;
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
		TreeNode t9=new TreeNode(86);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.left=t8;
		t7.left=t9;
		
		ArrayList<TreeNode> tree=new ArrayList<TreeNode>();
		tree.add(t1);
		tree.add(t2);
		tree.add(t3);
		tree.add(t4);
		tree.add(t5);
		tree.add(t6);
		tree.add(t7);
		tree.add(t8);
		tree.add(t9);
		
		int array[]=new int[tree.size()];
		IsBinaryTree.isBinaryTree(t1, array);
		for(int i=1;i<array.length;i++) {
			if(array[i]<array[i-1]) {
				System.out.println("Given tree is not a binary tree!");
				return;
			}
		}
		System.out.println("Given tree is a binary tree!");	
	}
}
