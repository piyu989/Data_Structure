package Leetcode;

import Leetcode.ReverseLinkedList.Node;

public class AddTwoNumber {
	static void print(Node head) {
		Node temp=head;
		
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}System.out.println("null");
	}
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public static void main(String args[]) {
		System.out.println("sita ram");
	}
}
