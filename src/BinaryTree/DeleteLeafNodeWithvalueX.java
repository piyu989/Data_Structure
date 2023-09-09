package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTree.KthLevel.Node;

public class DeleteLeafNodeWithvalueX {

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
		void ans(Node root,int x) {
			if(root==null) {
				return;
			}
			if(root.left.data==x&&root.left.left==null&&root.left.right==null) {
				root.left=null;
				return;
			}
//			if(root.left==null&&root.right==null&&root.data==x) {
//				root=null;
//				return;
//			}
			ans(root.left, x);
			ans(root.right, x);
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,-1,-1,4,-1,-1,5,4,-1,-1,5,-1,-1,1,1};
		BinaryTree bt=new BinaryTree();
		Node root=bt.buildTree(arr);
		bt.levelOrder(root);
		bt.ans(root, 4);
		bt.levelOrder(root);
	}

}
