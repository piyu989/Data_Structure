package BinarySearchTree;

import BinarySearchTree.ValidateBST.Node;

public class BalancedTree {

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
		Node createBST(int arr[],int strt,int end) {
			if(strt>end) {
				return null;
			}
			int mid=(strt+end)/2;
			Node root=new Node(arr[mid]);
			root.left=createBST(arr, strt, mid-1);
			root.right=createBST(arr, mid+1, end);
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("sita ram");
	}

}
