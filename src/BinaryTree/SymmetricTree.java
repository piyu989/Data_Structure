package BinaryTree;

//https://leetcode.com/problems/symmetric-tree/

import Leetcode.InorderTree.TreeNode;

public class SymmetricTree {
	
	public boolean isSymmetricc(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)return true;

        if(t1==null||t2==null)return false;
        return (t1.val==t2.val)&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { 
	    	this.val = val;
	    }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	static boolean isSymmetric(TreeNode root) {
		return ans(root.left,root.right);
	}

	static boolean ans(TreeNode left,TreeNode right) {
		if(left==null&&right==null) {
			return true;
		}
		if(left==null||right==null) {
			return false;
		}
		if(left.val!=right.val) {
			return false;
		}
		return ans(left.left,right.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sita ram");
	}

}
