package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/

public class InorderTree {
	
	static class Solution {
	    private List<Integer>ans=new ArrayList<>();
	    public List<Integer> inorderTraversal(TreeNode root) {
	        ans(root);
	        return ans;
	    }
	    private void ans(TreeNode root){
	        if(root==null){
	            return;
	        }
	        ans(root.left);
	        ans.add(root.val);
	        ans(root.right);
	    }
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
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>li=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        
        TreeNode cur=root;
        
        while(cur!=null||!st.isEmpty()) {
        	while(cur!=null) {
        		st.push(cur);
        		cur=cur.left;
        	}
        	cur=st.pop();
        	li.add(cur.val);
        	cur=cur.right;	
        }
        return li;
    }

	public static void main(String[] args) {
//		TreeNode root=new TreeNode(1);
//		TreeNode right=new TreeNode(2);
	}

}
