package Leetcode;

//https://leetcode.com/problems/balanced-binary-tree/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BalancedBinaryTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data=d;
			left=null;
			right=null;
		}
	}
	
	static boolean ans(Node root) {
		if(root==null) {
			return true;
		}
		int l=height(root.left);
		int r=height(root.right);
		return Math.abs(l-r)<=1&&ans(root.left)&&ans(root.right);
	}
	static int height(Node root) {
		if(root==null) {
			return 0;
		}
		int l=height(root.left)+1;
		int r=height(root.right)+1;
		return Math.max(l, r);
	}
	
	static class BT{
		void buildTree(Node root) {
			Scanner sc=new Scanner(System.in);
			System.out.print("enter element: ");
			while(true) {
				int n=sc.nextInt();
				if(n==-1)break;
				if(root==null) {
					root=new Node(n);
					return;
				}else {
					if(n>root.data) {
						root.right=new Node(n);
					}else {
						root.left=new Node(n);
					}
				}
			}
		}
		void levelOrder(Node root){
	        Queue<Node>q=new LinkedList<>();
	        q.add(root);
	        q.add(null);
	        while (!q.isEmpty()) {
	            Node cur=q.remove();
	            if(cur==null){
	                System.out.println();
	                if(q.isEmpty()){
	                    break;
	                }else{
	                    q.add(null);
	                }
	            }else{
	                System.out.print(cur.data+" ");
	                if(cur.left!=null){
	                    q.add(cur.left);
	                }
	                if(cur.right!=null){
	                    q.add(cur.right);
	                }
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(6);
		BT bt=new BT();
		bt.buildTree(root);
		bt.levelOrder(root);
	}

}
