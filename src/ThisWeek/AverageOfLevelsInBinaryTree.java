package ThisWeek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(3);
		root.left=new Node(9);
		root.right=new Node(20);
		root.right.left=new Node(15);
		root.right.right=new Node(7);
		
		System.out.println(ans(root));
	}
	
	static class Node{
		int val;
		Node right;
		Node left;
		Node(int data){
			this.val=data;
			left=right=null;
		}
	}
	
	static List<Double> ans(Node root){
		List<Double>ans=new ArrayList<>();
		Queue<Node>q=new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			int size=q.size();
			Double sum=0.0;
			for(int i=0;i<size;i++) {
				Node cur=q.remove();
				sum+=cur.val;
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			ans.add(sum/size);
		}
		
		return ans;
	}

}
