package Leetcode;

import java.util.ArrayList;
import java.util.List;

import Leetcode.MaximumDepthOfBinaryTree.Node;

//https://leetcode.com/problems/binary-tree-postorder-traversal/description/

public class PostOrderTraversal {
	
	static List<Integer>ans(Node root){
		List<Integer>li=new ArrayList<>();
		temp(root,li);
		return li;
	}
	
	static void temp(Node root,List<Integer>li) {
		if(root==null) {
			return;
		}
		temp(root.left,li);
		temp(root.right,li);
		li.add(root.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
