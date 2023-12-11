package Leetcode;

import Leetcode.MaximumDepthOfBinaryTree.Node;

public class ValidateBST {

	static boolean ans(Node root) {
		return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	static boolean help(Node root,long min,long max) {
		if(root==null) {
			return true;
		}
		if(root.data<=min||root.data>=max) {
			return false;
		}
		return help(root.left, min, root.data)&&help(root.right, root.data, max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
