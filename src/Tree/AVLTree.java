package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AVLTree {
	
//	static class TT{
		static class Node {
			int data, height;
			Node left, right;
			Node(int data) {
			this.data = data;
			height = 1;
			}
			}
			public static Node root;
			public static int height(Node root) {
			if (root == null)
			return 0;
			return root.height;
			}
			// Right rotate subtree rooted with y
			public static Node rightRotate(Node y) {
			Node x = y.left;
			Node T2 = x.right;
			// rotation using 3 nodes
			x.right = y;
			y.left = T2;
			// update heights
			y.height = Math.max(height(y.left), height(y.right)) + 1;
			x.height = Math.max(height(x.left), height(x.right)) + 1;
			// x is new root
			return x;
			}
			// Left rotate subtree rooted with x
			public static Node leftRotate(Node x) {
			Node y = x.right;
			Node T2 = y.left;
			// rotation using 3 nodes
			y.left = x;
			x.right = T2;
			// update heights
			x.height = Math.max(height(x.left), height(x.right)) + 1;
			y.height = Math.max(height(y.left), height(y.right)) + 1;
			// y is new root
			return y;
			}
			// Get Balance factor of node
			public static int getBalance(Node root) {
			if (root == null)
			return 0;
			return height(root.left) - height(root.right);
			}
			public static Node insert(Node root, int key) {
			if (root == null)
			return new Node(key);
			if (key < root.data)
			root.left = insert(root.left, key);
			else if (key > root.data)
			root.right = insert(root.right, key);
			else
			return root; // Duplicate keys not allowed
			// Update root height
			root.height = 1 + Math.max(height(root.left), height(root.right));
			// Get root's balance factor
			int bf = getBalance(root);
			// Left Left Case
			if (bf > 1 && key < root.left.data)
			return rightRotate(root);
			// Right Right Case
			if (bf < -1 && key > root.right.data)
			return leftRotate(root);
			// Left Right Case
			if (bf > 1 && key > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
			}
			// Right Left Case
			if (bf < -1 && key < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
			}
			return root; //returned if AVL balanced
		}

	public static void main(String args[]) {
		
//		TT t=new TT();
		
		
		for(int i=0;i<1000;i++) {
			root=insert(root, i);
		}
//		for(int i=1;i<5;i++) {
////			root=insert(root, i);
//		}
		System.out.println(root.height);
//		System.out.println();
//		levelOrder(root);
	}
	
//	public static void levelOrder(Node root) {
//		Queue<Node>q=new LinkedList<>();
//		q.add(root);
//		q.add(null);
//		
//		while(!q.isEmpty()) {
//			Node cur=q.remove();
//			if(cur==null) {
//				System.out.println();
//				if(q.isEmpty()) {
//					break;
//				}else {
//					q.add(null);
//				}
//			}else {
//				System.out.print(cur.data+" ");
//				if(cur.left!=null)q.add(cur.left);
//				if(cur.right!=null)q.add(cur.right);
//			}
//		}
//	}
//	
//	static class Node{
//		int data,height;
//		Node right,left;
//		Node(int data){
//			this.data=data;
//			height=1;
//			right=left=null;
//		}
//		Node(){
//			height=0;
//			right=left=null;
//		}
//	}
//	public static Node root;
//	
//	public static int height(Node root) {
//		if(root==null)return 0;
//		return root.height;
//	}
//	
//	public static Node rotateRight(Node y) {
//		Node x=y.left;
//		Node t2=x.right;
//		
//		x.right=y;
//		y.left=t2;
//		y.height=Math.max(height(y.left), height(y.right))+1;
//		x.height=Math.max(height(x.left), height(x.right))+1;
//		
//		return x;
//	}
//	
//	public static Node rotateLeft(Node x) {
//		Node y=x.right;
//		Node t2=y.left;
//		
//		y.left=x;
//		x.right=t2;
//		
//		x.height=Math.max(height(x.left), height(x.right))+1;
//		y.height=Math.max(height(y.left), height(y.right))+1;
//		
//		return y;
//	}
//	
//	public static int getBalance(Node root) {
//		if(root==null)return 0;
//		return height(root.left)-height(root.right);
//	}
//	
//	public static Node insert(Node root,int key) {
//		if(root==null)return new Node(key);
//		
//		if(key<root.data) {
//			root.left=insert(root.left, key);
//		}
//		else if(key>root.data) {
//			root.right=insert(root.right,key);
//		}
//		else {
//			return root;
//		}
//		root.height=1+Math.max(height(root.left), height(root.right));
//		
//		int balFac=getBalance(root);
//		
//		if(balFac>1&&key<root.left.data) {
//			return rotateRight(root);
//		}
//		if(balFac<-1&&key>root.right.data) {
//			return rotateLeft(root);
//		}
//		
//		if(balFac>1&&key>root.left.data) {
//			root.left=rotateLeft(root.left);
//			return rotateRight(root);
//		}
//		if(balFac<-1&&key<root.right.data) {
//			root.right=rotateRight(root.right);
//			return rotateLeft(root);
//		}
//		return root;
//	}
	
}

