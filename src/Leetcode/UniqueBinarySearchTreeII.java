package Leetcode;

//https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {

	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
			this.right=null;
			this.left=null;
		}
	}
	
	static List<Node> ans(int n){
		return helper(1,n);
	}
	
	static List<Node> helper(int strt,int end){
		if(strt>end) {
			List<Node>base=new ArrayList<>();
			base.add(null);
			return base;
		}
		List<Node> ans=new ArrayList<>();
		
		for(int i=strt;i<=end;i++) {
			List<Node>left=helper(strt,i-1);
			List<Node>right=helper(i+1,end);
			for(Node l:left) {
				for(Node r:right) {
					Node root=new Node(i);
					root.left=l;
					root.right=r;
					ans.add(root);
				}
			}
			
		}
		return ans;
	}
	
	static List<Node> dp[][];
	
	static List<Node> sol(int n){
		dp=new List[n+1][n+1];
		return help(1,n);
	}
	
	static List<Node> help(int strt,int end){
		ArrayList<Node>ans=new ArrayList<>();
		if(strt>end) {
			ans.add(null);
			return ans;
		}
		
		if(dp[strt][end]!=null)return dp[strt][end];
		
		for(int i=strt;i<=end;i++) {
			List<Node>left=help(strt,i-1);
			List<Node>right=help(i+1,end);
			
			for(Node l:left) {
				for(Node r:right) {
					Node root=new Node(i);
					root.left=l;
					root.right=r;
					ans.add(root);
				}
			}
		}
		return dp[strt][end]=ans;
	}
	
	static void printTree(Node root, String prefix) {
        if (root != null) {
            System.out.println(prefix + root.data);
            printTree(root.left, prefix + "L ");
            printTree(root.right, prefix + "R ");
        }
    }
	
	
	public static void main(String[] args) {
		List<Node>li=sol(1);
        for(Node r:li){
            printTree(r, "");
            System.out.println("-------------");
        }
	}

}
