package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.PrintInRange.Node;
import BinarySearchTree.PrintInRange.Tree;

public class RootToLeaveNode {

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
		void printPath(ArrayList<Integer> li) {
			for(int i=0;i<li.size();i++) {
				System.out.print(li.get(i)+" ");
			}
			System.out.println("NULL");
		}
		void levelOrder(Node root) {
			 Queue<Node>q=new LinkedList<>();
	            q.add(root);
	            q.add(null);
	            while(!q.isEmpty()){
	                Node temp=q.remove();
	                if(temp==null){
	                    System.out.println();
	                    if(q.isEmpty()){
	                        break;
	                    }else{
	                        q.add(null);
	                    }
	                }
	                else{
	                    System.out.print(temp.data+" ");
	                    if(temp.left!=null){
	                        q.add(temp.left);
	                    }if(temp.right!=null){
	                        q.add(temp.right);
	                    }
	                }
	            }
		}
		void path(Node root,ArrayList<Integer>li) {
			if(root==null) {
				return;
			}
			li.add(root.data);
			if(root.left==null&&root.right==null) {
				printPath(li);
			}
			path(root.left, li);
			path(root.right, li);
			li.remove(li.size()-1);
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[]= {8,5,3,6,10,11,14};
		Tree t=new Tree();
		Node root=null;
		for(int i=0;i<ar.length;i++) {
			root=t.buildTree(root, ar[i]);
		}
		t.inorder(root);
		System.out.println();
		t.levelOrder(root);
		t.path(root, new ArrayList<Integer>());
	}

}
