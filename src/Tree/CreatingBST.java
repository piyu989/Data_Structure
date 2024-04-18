package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreatingBST {
	public static void main(String args[]) {
		ABC bt=new ABC();
		Node root=new Node();
//		int val;
//		Scanner sc=new Scanner(System.in);
		
//		int arr[]= {4,32,3223,2,0};
		
//		while((val=sc.nextInt())!=-1) {
//			root=bt.insert(val);
//		}
		int arr[]= {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<arr.length;i++) {
			root=bt.insert(arr[i]);
		}
		
		
//		root=bt.selfBalancingTree(arr);
		bt.inorder(root);
		System.out.println();
//		bt.levelOrder(root);
		bt.display(root, "root node is: ");
		System.out.println();
		System.out.println(bt.isBalanced());
//		sc.close();
	}
}
class Node{
	int data;
	Node left;
	Node right;
	int height;
	Node(int val){
		height=1;
		data=val;
		left=right=null;
	}
	Node(){
		left=right=null;
		height=0;
	}
}
class ABC{

	private Node root;
	
	Node insert(int val) {
		return root=insert(root,val);
	}
	
	int height(Node root) {
		if(root==null){return 0;}
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	Node insert(Node root,int val) {
		if(root==null) {
			return new Node(val);
		}
		if(val>root.data) {
			root.right=insert(root.right, val);
		}else {
			root.left=insert(root.left, val);
		}
		if(root.right!=null && root.right!=null) {
			root.height=Math.max(height(root.left), height(root.right))+1;
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
	void levelOrder(Node root) {
		if(root==null) {
			System.out.println("khali");
			return;
		}
		Queue<Node>q=new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node cur=q.remove();
			if(cur==null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				System.out.print(cur.data+" ");
				if(cur.left!=null)q.add(cur.left);
				if(cur.right!=null) q.add(cur.right);
			}
		}
	}
	boolean isBalanced() {
		return isBalanced(root);
	}
	void display(Node root,String details) {
		if(root==null) {
			return;
		}
		System.out.println(details+" "+root.data);
		display(root.left, "left child of "+root.data+" : ");
		display(root.right, "right child of "+root.data+" : ");
		
	}
	private boolean isBalanced(Node root) {
		if(root==null)return true;
		return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
	}
	
	Node selfBalancingTree(int arr[]) {
		return root=selfBalancingTree(arr, 0, arr.length-1);
	}
	
	Node selfBalancingTree(int arr[],int strt,int end) {
		if(strt>end) {
			return null;
		}
		int mid=strt+(end-strt)/2;
		Node node=new Node(arr[mid]);
		node.left=selfBalancingTree(arr, strt, mid-1);
		node.right=selfBalancingTree(arr, mid+1,end);
		return node;
	}
}