package Leetcode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class MaximumDepthOfBinaryTree {
	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	static int ans(Node root) {
		if(root==null){
            return 0;
        }
        int ans=Math.max(ans(root.left),ans(root.right))+1;
        return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
