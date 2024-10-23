package Leetcode;

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
	
	static Node ans(Node l1,Node l2) {
		int rem=0;
		Node ans=new Node(-1);
		Node temp=ans;
		
		while(l1!=null||l2!=null|rem!=0) {
			int sum=rem;
			if(l1!=null) {
				sum+=l1.data;
				l1=l1.next;
			}
			if(l2!=null) {
				sum+=l2.data;
				l2=l2.next;
			}
			rem=sum%10;
			sum=sum/10;
			temp.next=new Node(sum);
			temp=temp.next;
		}
		return ans.next;
	}
	public static void main(String args[]) {

	}
}
