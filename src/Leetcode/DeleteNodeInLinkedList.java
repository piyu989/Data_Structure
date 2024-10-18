package Leetcode;

import Leetcode.RemoveNthNodeFromEndofList.ListNode;

public class DeleteNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		ListNode node=head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		
		ans(node);
		print(head);
	}

	static void ans(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	static void print(ListNode head) {
		ListNode temp=head;
		
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}System.out.println("null");
	}
	
	public static ListNode head;
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
