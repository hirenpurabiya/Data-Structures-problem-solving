package TreesAndGraphs;
import java.util.ArrayList;
import java.util.LinkedList;

public class FindLevelLinkList {
	
	public static ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		int level=0;
		list.add(root);
		result.add(level, list);
		
		while(true) {
			list = new LinkedList<TreeNode>();
			for(int i=0;i<result.get(level).size();i++) {
				TreeNode n= (TreeNode) result.get(level).get(i);
				if(n!=null) {
					if(n.left!=null) 
						list.add(n.left);
					if(n.right!=null)
						list.add(n.right);
				}
			}
			if(list.size()>0) {
				result.add(level+1, list);
			} else {
				break;
			}
			level++;
		}
		return result;
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
		
		ArrayList<LinkedList<TreeNode>> result = FindLevelLinkList.findLevelLinkList(t1);
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i).get(0).data);

	}
}
