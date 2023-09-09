package Leetcode;


//https://leetcode.com/problems/range-sum-of-bst/description/
public class RangeSumBST {

	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
		}
	}
	static class Tree{
		int ans=0;
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
		int ans(Node root,int v1,int v2) {
			if(root==null) {
				return 0;
			}
			if(root.data>=v1&&root.data<=v2) {
				ans+=root.data;
			}
			if(root.data>v1) {
				ans(root.left, v1, v2);
			}
			if(root.data<v2) {
				ans(root.right, v1, v2);
			}
			return ans;
		}
	}

	
	public static void main(String args[]) {
		int ar[]= {10,5,15,3,7,18};
		Tree t=new Tree();
		Node root=null;
		for(int i=0;i<ar.length;i++) {
			root=t.buildTree(root, ar[i]);
		}
		t.inorder(root);
		t.ans(root, 7,15);
		System.out.println();
		System.out.println(t.ans);
	}
}
