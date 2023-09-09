package BinarySearchTree;

import BinarySearchTree.ValidateBST.Node;

public class MirrorOfBST {

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
		Node mirror(Node root) {
			if(root==null) {
				return null;
			}
			Node left=mirror(root.left);
			Node righ=mirror(root.right);
			root.left=righ;
			root.right=left;
			return root;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {12,1,21,22,2,4,3,9,33};
		Node root=null;
		Tree t=new Tree();
		for(int i=0;i<arr.length;i++) {
			root=t.buildTree(root, arr[i]);
		}
		t.inorder(root);
		root=t.mirror(root);
		System.out.println();
		t.inorder(root);
	}

}
