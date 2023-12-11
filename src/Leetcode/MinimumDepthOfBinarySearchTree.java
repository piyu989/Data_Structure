package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

import Leetcode.BalancedBinaryTree.Node;

public class MinimumDepthOfBinarySearchTree {
	
	public static int ans(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			return 1;
		}
		int l=ans(root.left);
		int r=ans(root.right);
		return 1+(Math.min(l, r)>0?Math.min(l, r):Math.max(l, r));
	}
	
	static int sol(Node root) {
		if(root==null) {
			return 0;
		}
		Queue<Node>q=new LinkedList<>();
		q.add(root);
		
		int lev=1;
		
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Node cur=q.remove();
				if(cur.left==null&&cur.right==null) {
					return lev;
				}
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			lev++;
		}
		return lev;
	}
	
	public static void main(String args[]) {
		
	}
}
