package TreesAndGraphs;

import java.util.ArrayList;

public class FindSum {
	public static void findSum(TreeNode t, int sum, ArrayList<Integer> buffer, int level) {
		if(t==null) return;
		int tmp=sum;
		buffer.add(t.data);
		
		for(int i=level;i>-1;i--) {
			tmp-=buffer.get(i);
			if(tmp==0) print(buffer, i, level);
		}
		
		ArrayList<Integer> c1=(ArrayList<Integer>)buffer.clone();
		ArrayList<Integer> c2=(ArrayList<Integer>)buffer.clone();
		findSum(t.left, sum, c1, level+1);
		findSum(t.right, sum, c2, level+1);
	}

	private static void print(ArrayList<Integer> buffer, int level, int i2) {
		System.out.println();
		for(int i=level;i<=i2;i++)
			System.out.print(buffer.get(i)+" ");
	}
	
	public static void main(String args[]) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(5);
		TreeNode t4=new TreeNode(6);
		TreeNode t5=new TreeNode(3);
		TreeNode t6=new TreeNode(0);
		TreeNode t7=new TreeNode(1);
		
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		
		ArrayList<Integer> buffer=new ArrayList<Integer>();
		System.out.println("Paths whos sum equals to "+t4.data+" are: ");
		FindSum.findSum(t1, t4.data, buffer, 0);
	}
}
