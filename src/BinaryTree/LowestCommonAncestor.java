package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTree.KthLevel.Node;

public class LowestCommonAncestor {
	
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
		
		public boolean getPath(Node root,int val,ArrayList<Node> li) {
			if(root==null) {
				return false;
			}
			li.add(root);
			if(root.data==val) {
				return true;
			}
			boolean pa1=getPath(root.left, val, li);
			boolean pa2=getPath(root.right, val, li);
			if(pa1||pa2) {
				return true;
			}
			li.remove(li.size()-1);
			return false;
		}
		
		public Node lowest(Node root,int v1,int v2) {
			ArrayList<Node>p1=new ArrayList<>();
			ArrayList<Node>p2=new ArrayList<>();
			getPath(root, v1, p1);
			getPath(root, v2, p2);
			
			int i=0;
			for(;i<p1.size()&&i<p2.size();i++) {
				if(p1.get(i)!=p2.get(i)) {
					break;
				}
			}
			Node ans=p1.get(i-1);
			return ans;
		}
		
		Node BestApproach(Node root,int v1,int v2) {
			if(root==null||root.data==v1||root.data==v2) {
				return root;
			}
			Node left=BestApproach(root.left, v1, v2);
			Node right=BestApproach(root.right, v1, v2);
			
			if(left==null) {
				return right;
			}
			if(right==null) {
				return left;
			}
			return root;
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
				}else {
					System.out.print(temp.data);
					if(temp.left!=null) {
						q.add(temp.left);
					}if(temp.right!=null) {
						q.add(temp.right);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		int arr[]={3,5,6,-1,-1,2,7,-1,-1,4,-1,-1,1,0,-1,-1,8,-1,-1};

        Node root=bt.buildTree(arr);
        // bt.levelOrder(root);
        Node a=bt.BestApproach(root,5,8);
        System.out.println(a.data);
	}

}
