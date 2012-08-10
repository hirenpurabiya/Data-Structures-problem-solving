package TreesAndGraphs;

import java.util.ArrayList;

public class BinaryTreeWithMinimalHeight {
	
	public static TreeNode createBinaryTreeWithMinimalHeight(int arr[], int start, int end)  {
		if(end<start)
			return null;
		
		int mid=(start+end)/2;
		TreeNode t=new TreeNode(arr[mid]);
		t.left=createBinaryTreeWithMinimalHeight(arr, start, mid-1);
		t.right=createBinaryTreeWithMinimalHeight(arr, mid+1, end);
		return t;
	}
	
	public static void main(String args[]) {
		TreeNode t=BinaryTreeWithMinimalHeight.createBinaryTreeWithMinimalHeight(new int[]{1,2,3,4,5,6,7,8}, 0, 7);
		
		while(t!=null) {
			System.out.println(t.data);
			t=t.right;
		}
	}
}
