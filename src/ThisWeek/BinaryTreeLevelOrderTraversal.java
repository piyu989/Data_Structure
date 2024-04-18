package ThisWeek;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sita ram");
		
		Node root=new Node(3);
		root.left=new Node(9);
		root.right=new Node(20);
		root.right.left=new Node(15);
		root.right.right=new Node(7);
		
		System.out.println(ans(root));
	}
	
	static List<List<Integer>> ans(Node root){
		List<List<Integer>>ans=new ArrayList<>();
		List<Integer>temp=new ArrayList<>();
		Queue<Node>q=new LinkedList<>();
		
		temp.add(root.data);
		temp.add(null);
		
		while(!q.isEmpty()) {
			Node cur=q.remove();
//			temp.add(cur.data);
			if(cur==null) {
				if(q.isEmpty()) {
					break;
				}
				else {
					ans.add(temp);
					q.add(null);
					temp.clear();
				}
			}
			else {
				if(cur.left!=null) {
					temp.add(cur.data);
					q.add(cur.left);
				}
				if(cur.right!=null) {
					temp.add(cur.data);
					q.add(cur.right);
				}
			}
		}
		
		return ans;
	}

}
