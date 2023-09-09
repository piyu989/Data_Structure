package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTree.LowestCommonAncestor.Node;

public class MinimumDistanceBetTwoNode {

	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static class BinaryTree{
		int idx=-1;
		public Node buildTree(int arr[]){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node root=new Node(arr[idx]);
            root.left=buildTree(arr);
            root.right=buildTree(arr);
            return root;
        }
		Node buildTree() {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter element: ");
			int data=sc.nextInt();
			if(data==-1) {
				return null;
			}
			Node newNode=new Node(data);
			newNode.left=buildTree();
			newNode.right=buildTree();
			return newNode;
		}
		
		
		public Node lca(Node root,int v1,int v2) {
			if(root==null||root.data==v1||root.data==v2) {
				return root;
			}
			Node left=lca(root.left, v1, v2);
			Node right=lca(root.right, v1, v2);
			
			if(right==null) {
				return left;
			}
			if(left==null) {
				return right;
			}
			return root;
		}
		public int minDist(Node root,int v1,int v2) {
			Node com=lca(root, v1, v2);
			int left=getPath(com,v1);
			int right=getPath(com,v2);
			
			return left+right;
		}
		void levelOrder(Node root) {
			Queue<Node>q=new LinkedList<>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()) {
				Node temp=q.remove();
				if(temp==null) {
					System.out.println();
					if(q.isEmpty()) {
						break;
					}else {
						q.add(null);
					}
				}
				else {
					System.out.print(temp.data+" ");
					if(temp.left!=null) {
						q.add(temp.left);
					}
					if(temp.right!=null) {
						q.add(temp.right);
					}
				}
			}
		}
		public int getPath(Node root,int v) {
			if(root==null) {
				return -1;
			}if(root.data==v) {
				return 0;
			}
			int left=getPath(root.left, v);
			int right=getPath(root.right, v);
			if(left==-1&&right==-1) {
				return -1;
			}else if(left==-1&&right!=-1) {
				return right+1;
			}else {
				return left+1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		int arr[]= {1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,7,-1,-1};
		Node root=bt.buildTree(arr);
		bt.levelOrder(root);
		System.out.println(bt.minDist(root, 5, 6));
//		bt.levelOrder(root);
	}

}
