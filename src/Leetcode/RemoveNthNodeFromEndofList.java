package Leetcode;

import Leetcode.ReverseLinkedList.Node;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(4);
		
		head=removeNthFromEnd(head, 3);
		print(head);
		
	}
	
	static void print(ListNode head) {
		ListNode temp=head;
		
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}System.out.println("null");
	}
	
	public static ListNode head;
	
	static public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1){
            return null;
        }
        if(head.next.next==null && n==1){
            head.next=null;
            return head;
        }else if(head.next.next==null && n==2){
            head=head.next;
            return head;
        }
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }

        temp=head;
        if(size==n) {
        	head=head.next;
        	return head;
        }
        n=size-n;
        while(head!=null){
            n--;
            if(n==0&&head.next!=null){
                head.next=head.next.next;
            }
            head=head.next;
        }
        return temp;
    }

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
}
