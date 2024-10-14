package Leetcode;

public class MiddleOfLinkedList {
	static Node head;
	public static void main(String args[]) {
		head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head=findMiddle(head);
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	static Node findMiddle(Node head) {
		Node first=head;
		Node second=head;
		
		while(second!=null&&second.next!=null) {
			first=first.next;				
			second=second.next.next;	
		}
		return first;
	}	
}
