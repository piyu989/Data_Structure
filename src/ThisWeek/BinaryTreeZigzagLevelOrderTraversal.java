package ThisWeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root=new Node(3);
		root.left=new Node(9);
		root.right=new Node(20);
		root.right.left=new Node(15);
//		root.left.right=new Node(14);
//		root.left.right.left=new Node(36);
		root.right.right=new Node(7);
		
		System.out.println(ans(root));

	}
	
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
	
	static List<List<Integer>> ans(Node root){
		if(root==null)return null;
		
		List<List<Integer>>ans=new ArrayList<>();
//		ans.add(List.of(root.data));
		
		Queue<Node>q=new LinkedList<>();
		int count=1;
		q.add(root);
		
		while(!q.isEmpty()) {
			int size=q.size();
			List<Integer>li=new ArrayList<>();
			for(int i=0;i<size;i++) {
				Node cur=q.remove();
				li.add(cur.data);
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			count++;
			if(count%2!=0) {
				Collections.reverse(li);
			}
			ans.add(li);
		}
		
		return ans;
	}

}
