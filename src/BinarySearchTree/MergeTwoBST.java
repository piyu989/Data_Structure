package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.SizeOfLargestBSTInBinaryTree.Node;

public class MergeTwoBST {


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
		void getInorder(Node root,ArrayList<Integer>li) {
			if(root==null) {
				return;
			}
			getInorder(root.left, li);
			li.add(root.data);
			getInorder(root.right, li);
		}
		Node mergeNode(Node r1,Node r2) {
			ArrayList<Integer>l1=new ArrayList<>();
			ArrayList<Integer>l2=new ArrayList<>();
			getInorder(r1, l1);
			getInorder(r2, l2);
			mergeTwoList(l1, l2);
			return createBalancedTree(0, l1.size()-1, l1);
		}
		void mergeTwoList(ArrayList<Integer>l1,ArrayList<Integer>l2) {
			l1.addAll(l2);
			Collections.sort(l1);
		}
		Node createBalancedTree(int strt,int end,ArrayList<Integer>li) {
			if(strt>end) {
				return null;
			}
			int mid=(strt+end)/2;
			Node cur=new Node(li.get(mid));
			cur.left=createBalancedTree(strt, mid-1, li);
			cur.right=createBalancedTree(mid+1, end, li);
			return cur;
		}
		
		void inorder(Node root) {
			if(root==null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node r1=new Node(1);
		r1.left=new Node(3);
		r1.left.left=new Node(6);
		r1.right=new Node(2);
		
		Node r2=new Node(2);
		r2.left=new Node(1);
		r2.left=new Node(4);
		r2.right=new Node(3);
		r2.right.right=new Node(7);
		
		Tree t=new Tree();
		Node root=t.mergeNode(r1, r2);
//		System.out.println(t.inorder(root));
		t.inorder(root);
		System.out.println();
		t.levelOrde(root);
				
		
	}

}
