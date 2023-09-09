package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTree.KthLevel.Node;
import BinaryTree.LowestCommonAncestor.BinaryTree;

public class TransformtoSumTree {

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
		public int ans(Node root){
			if(root.left==null||root.right==null) {
				return 0;
			}
			int data=root.data;
			int left=ans(root.left);
			int right=ans(root.right);
			root.data=root.left.data+left+root.right.data+right;
			return data;
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
	}
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		int arr[]={1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,7,-1,-1};
//		Node root=bt.buildTree(arr);
		Node root=bt.buildTree(arr);
		bt.levelOrder(root);
		bt.ans(root);
        bt.levelOrder(root);
	}

}
