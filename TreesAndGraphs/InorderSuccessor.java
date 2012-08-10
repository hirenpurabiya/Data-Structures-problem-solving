package TreesAndGraphs;

public class InorderSuccessor {
	public static TreeNode inorderSuccessor(TreeNode t) {
		if(t!=null) {
			TreeNode p;
			if(t.parent==null || t.right!=null) {
				p=leftMostChild(t.right);
			} else {
				while((p=t.parent)!=null) {
					if(p.left==t)
						return p;
					t=p;
				}
			}
			return p;
		}
		return null;
	}
	
	public static TreeNode leftMostChild(TreeNode t) {
		if(t==null) return null;
		while(t.left!=null) {
			t=t.left;
		} return t;
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
		t2.left=t4; t2.right=t5; t2.parent=t1;
		t3.left=t6; t3.right=t7; t3.parent=t1;
		t4.left=t8; t4.parent=t2;
		t5.parent=t2;
		t6.parent=t3;
		t7.left=t9; t7.parent=t3;
		t8.parent=t4;
		t9.parent=t7;
		
		
		TreeNode a=new TreeNode(50);
		TreeNode b=new TreeNode(40);
		TreeNode c=new TreeNode(30);
		TreeNode d=new TreeNode(20);
		a.left=b;
		b.left=c;
		c.left=d;
		
		TreeNode successor=InorderSuccessor.inorderSuccessor(t1);
		if(successor!=null)
			System.out.println("The successor of given node "+t1.data+" is "+successor.data);
		else
			System.out.println("There is no successor for the given node "+t1.data);
	}
}
