package Leetcode;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		

		ListNode l2=new ListNode(3);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(9);
		
		head=mergeTwoList(l1, l2);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	static ListNode head;
	
	static ListNode mergeTwoList(ListNode l1,ListNode l2) {
		ListNode temp=new ListNode(-1);
		ListNode ans=temp;
		
		while(l1!=null&&l2!=null) {
			if(l1.val>l2.val) {
				temp.next=l2;
				l2=l2.next;
				temp=temp.next;
			}else {
				temp.next=l1;
//				System.out.println(l1.val);
//				System.out.println(l2.val);
				l1=l1.next;
				temp=temp.next;
			}
		}
		while(l1!=null) {
			temp.next=l1;
			l1=l1.next;
			temp=temp.next;
		}
		while(l2!=null) {
			temp.next=l2;
			l2=l2.next;
			temp=temp.next;
		}
		return ans.next;
	}
	
	static class ListNode {
		int val;
 		ListNode next;
 		ListNode() {}
 		ListNode(int val) { this.val = val; }
 		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 

}
