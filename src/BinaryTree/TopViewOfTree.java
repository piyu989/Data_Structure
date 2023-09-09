package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopViewOfTree {

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
		
		static class Info{
			int val;
			Node root;
			Info(Node root,int val){
				this.root=root;
				this.val=val;
			}
		}
		
		public void topMost(Node root) {
			Queue<Info>q=new LinkedList<>();
			HashMap<Integer,Node> map=new HashMap<>();
			q.add(new Info(root,0));
			q.add(null);
			int min=0,max=0;
			
			while(!q.isEmpty()) {
				Info cur=q.remove();
				if(cur==null) {
					if(q.isEmpty()) {
						break;
					}else {
						q.add(null);
					}
				}
				else {
					if(!map.containsKey(cur.val)) {
						map.put(cur.val, cur.root);
					}
					if(cur.root.left!=null) {
						q.add(new Info(cur.root.left,cur.val-1));
						min=Math.min(min, cur.val-1);
					}
					if(cur.root.right!=null) {
						q.add(new Info(cur.root.right,cur.val+1));
						max=Math.max(max, cur.val+1);
					}
				}
			}
			for(int i=min;i<=max;i++) {
				System.out.println(map.get(i).data);
			}
		}
		
		void traversal(Node root) {
			if(root==null) {
				return;
			}
			System.out.println(root.data);
			traversal(root.left);
			traversal(root.right);
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
		// TODO Auto-generated method stub
		BinaryTree t=new BinaryTree();
		Node root=t.buildTree();
		t.levelOrder(root);
		
		t.topMost(root);
	
	}

}
