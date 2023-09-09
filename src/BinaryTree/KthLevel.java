package BinaryTree;

import java.util.Scanner;

import BinaryTree.TopViewOfTree.Node;

public class KthLevel {

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
		
		public int ans(Node root,int n,int k) {
			if(root==null) {
				return -1;
			}if(root.data==n) {
				return 0;
			}
			int l=ans(root.left, n, k);
			int r=ans(root.right, n, k);
			
			if(l==-1&&r==-1) {
				return -1;
			}
			int max=Math.max(l,r);
			if(k==max+1) {
				System.out.println(root.data);
			}
			return max+1;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		int arr[]= {1,2,3,4,-1,-1,5,-1,-1,6,7,-1,-1,8,-1,-1,9,10,11,-1,-1,12,-1,-1,13,14,-1,-1,15,-1,-1,1,-1};
		Node root=bt.buildTree(arr);
		int n=bt.ans(root, 12,1);
		System.out.println(n);
//		
	}

}
