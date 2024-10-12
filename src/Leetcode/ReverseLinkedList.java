package Leetcode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head = reverse(head);
		print(head);
	}	
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
	static Node reverse(Node head) {
		Node cur=head;
        Node prev=null;
        Node next;

        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
	}
}
