package BinarySearchTree;

import BinarySearchTree.RootToLeaveNode.Node;

public class ValidateBST {

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
		boolean validate(Node root) {
			if(root==null) {
				return true;
			}
			
			boolean lef=validate(root.left);
			if(root.left!=null&&root.right!=null) {
				if(root.left.data>root.data||root.right.data<root.data) {
					return false;
				}
			}
			boolean rig=validate(root.right);
			
			return lef||rig;
		}
		boolean validate(Node root,Node min,Node max) {
			if(root==null) {
				return true;
			}
			if(max!=null&&root.data>=max.data) {
				return false;
			}else if(min!=null&&root.data<=min.data) {
				return false;
			}
			return validate(root.left, min,root)&&validate(root.right, root, max);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[]= {12,12,1,1,12};
		Node root=null;
		Tree t=new Tree();
		for(int i=0;i<ar.length;i++) {
			root=t.buildTree(root, ar[i]);
		}
		t.inorder(root);
		System.out.println();
		System.out.println(t.validate(root,null,null));
	}

}
