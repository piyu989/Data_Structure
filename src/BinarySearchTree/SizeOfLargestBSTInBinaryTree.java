package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.ConvertBstToBalancedBst.Node;

public class SizeOfLargestBSTInBinaryTree {

	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
		}
	}
	static int ans=0;
	static class Tree{
		Node buildTree(Node root,int val) {
			if(root==null) {
				return new Node(val);
			}
			if(val<root.data) {
				root.left=buildTree(root.left, val);
			}else if(val>root.data) {
				root.right=buildTree(root.right, val);
			}
			return root;
		}
		public void levelOrde(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node t=q.remove();
                if(t==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(t.data+" ");
                    if(t.left!=null){
                        q.add(t.left);
                    }
                    if(t.right!=null){
                        q.add(t.right);
                    }
                }
            }
            
        }
		void inorder(Node root) {
			if(root==null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		boolean isBST(Node root) {
			if(root==null) {
				return true;
			}
			if(root.data>root.left.data&&root.left!=null) {
				return false;
			}if(root.data>root.right.data&&root.right!=null) {
				return false;
			}
			return isBST(root.left)&&isBST(root.right);
		}
		public Info getInfo(Node root) {
			if(root==null) {
				return new Info(0, Integer.MAX_VALUE,Integer.MIN_VALUE ,true);
			}
			Info left=getInfo(root.left);
			Info right=getInfo(root.right);
			int size=left.size+right.size+1;
			int min=Math.min(root.data, Math.min(left.min, right.min));
			int max=Math.max(root.data, Math.max(left.max, right.max));
			if(root.data>=right.min||root.data<=left.max) {
				return new Info(size, min, max, false);
			}if(root.data>left.min&&root.data<right.max) {
				ans=Math.max(ans, size);
				return new Info(size, min, max, true);
			}
			return new Info(size, min, max, false);
		}
	}
	static class Info{
		int size;
		int min;
		int max;
		boolean isBST;
		public Info(int size, int min, int max, boolean isBST) {
			super();
			this.size = size;
			this.min = min;
			this.max = max;
			this.isBST = isBST;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(50);
		root.left=new Node(30);
		root.left.left=new Node(5);
		root.left.right=new Node(20);
		
		root.right=new Node(60);
		root.right.left=new Node(45);
		root.right.right=new Node(70);
		root.right.right.left=new Node(65);
		root.right.right.right=new Node(80);
		Tree t=new Tree();
//		t.inorder(root);
		Info i=t.getInfo(root);
		System.out.println(ans);
	}

}
