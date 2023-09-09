package BinaryTree;

import java.util.Scanner;

import BinaryTree.KthLevel.Node;

public class Univalued {

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
		
		boolean ans(Node root) {
			if(root==null||root.left==null||root.right==null) {
				return true;
			}
			else if(root.data!=root.left.data) {
				return false;
			}else if(root.data!=root.right.data) {
				return false;
			}
			boolean left=ans(root.left);
			boolean right=ans(root.right);
			return left&&right;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		int arr[]= {2,2,2,-1,-1,2,-1,-1,2,2,-1,-1,2,-1,-1};
		Node root=bt.buildTree(arr);
		System.out.println(bt.ans(root));
	}

}
