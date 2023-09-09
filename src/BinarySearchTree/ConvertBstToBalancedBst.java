package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.BalancedTree.Node;

public class ConvertBstToBalancedBst {
	
	static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data=data;
		}
	}
	static class Tree{
		Node buildTree(Node root,int val) {
			if(root==null) {
				return new Node(val);
			}
			if(val<root.data) {
				root.left=buildTree(root.left, val);
			}else if(val>root.data) {
				root.right=buildTree(root.right, val);
			}
			return root;
		}
		public void levelOrde(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node t=q.remove();
                if(t==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(t.data+" ");
                    if(t.left!=null){
                        q.add(t.left);
                    }
                    if(t.right!=null){
                        q.add(t.right);
                    }
                }
            }
            
        }
		void inorder(Node root) {
			if(root==null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		void getInorder(Node root,ArrayList<Integer>li) {
			if(root==null) {
				return;
			}
			getInorder(root.left, li);
			li.add(root.data);
			getInorder(root.right, li);
		}
		Node balancedBST(Node root) {
			if(root==null) {
				return null;
			}
			ArrayList<Integer>li=new ArrayList<>();
			getInorder(root,li);
			root=createBalancedBST(li, 0, li.size()-1);
			return root;
		}
		Node createBalancedBST(ArrayList<Integer>li,int strt,int end) {
			if(strt>end) {
				return null;
			}
			int mid=(strt+end)/2;
			Node root=new Node(li.get(mid));
			root.left=createBalancedBST(li, strt, mid-1);
			root.right=createBalancedBST(li,mid+1,end);
			return root;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(8);
		root.left=new Node(6);
		root.left.left=new Node(5);
		root.left.left.left=new Node(3);
		root.right=new Node(10);
		root.right.right=new Node(11);
		root.right.right.right=new Node(12);
		
		Tree t=new Tree();
		t.inorder(root);
		t.levelOrde(root);
		System.out.println();
//		t.balancedBST(root);
		root=t.balancedBST(root);
		t.inorder(root);
		t.levelOrde(root);
		
	}

}
