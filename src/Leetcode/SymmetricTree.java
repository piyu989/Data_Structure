package Leetcode;

import BinarySearchTree.MirrorOfBST.Node;

public class SymmetricTree {

	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
		}
	}
	static class Tree{
		Node buildTree(Node root,int val) {
			if(root==null) {
				return new Node(val);
			}
			if(val<root.data) {
				root.left=buildTree(root.left, val);
			}else if(val>root.data) {
				root.right=buildTree(root.right, val);
//			}else {
//				return root;
			}
			return root;
		}
		void inorder(Node root) {
			if(root==null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	
		public boolean isSymmetric(Node root) {
			return isMirror(root,root);
	    }
		public boolean isMirror(Node t1,Node t2) {
			if(t1==null&&t2==null)return true;
			if(t1==null||t2==null)return false;
			return (t1.data==t2.data)&&isMirror(t1.left, t2.right)&&isMirror(t1.right, t2.left);
		}
	}
	
	
	public static void main(String args[]) {
		System.out.println("Sita ram");
	}
	
}
