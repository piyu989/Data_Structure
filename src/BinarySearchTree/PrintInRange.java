package BinarySearchTree;

import BinarySearchTree.DeleteANode.Node;
import BinarySearchTree.DeleteANode.Tree;

public class PrintInRange {
	
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
			}else {
				return root;
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
		void print(Node root,int v1,int v2) {
			if(root==null) {
				return;
			}
			if(root.data>=v1&&root.data<=v2) {
				System.out.print(root.data+" ");
			}
			if(root.data>1) 
				print(root.left, v1, v2);
			
			if(root.data<v2) 
				print(root.right, v1, v2);
			
		}
		void ans(Node root,int v1,int v2) {
			if(root==null) {
				return;
			}
			if(root.data>=v1&&root.data<=v2) {
				ans(root.left, v1, v2);
				System.out.print(root.data+" ");
				ans(root.right, v1, v2);
			}else if(root.data>v1) {
				ans(root.left, v1, v2);
			}else {
				ans(root.right, v1, v2);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[]= {10,30,39,40,44,45,48,50,55,60,65,70,72,75,80};
		Tree t=new Tree();
		Node root=null;
		for(int i=0;i<ar.length;i++) {
			root=t.buildTree(root, ar[i]);
		}
		t.inorder(root);
		System.out.println();
		t.ans(root,1,80);
	}

}
