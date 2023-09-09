package BinarySearchTree;

public class DeleteANode {

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
		Node del(Node root,int val) {
			if(root==null) {
				return null;
			}
			if(val>root.data) {
				root.right=del(root.right, val);
			}else if(val<root.data) {
				root.left=del(root.left, val);
			}else {
				if(root.left==null&&root.right==null) {
					return null;
				}
				if(root.left==null) {
					return root.right;
				}else if(root.right==null) {
					return root.left;
				}
				Node temp=inOrder(root.right);
				root.data=temp.data;
				root.right=del(root.right, temp.data);

			}
			return root;
		}
		Node inOrder(Node root) {
			while(root.left!=null) {
				root=root.left;
			}
			return root;
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
		root=t.del(root, 40);
		System.out.println();
		t.inorder(root);
	}

}
