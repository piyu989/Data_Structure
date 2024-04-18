package ThisWeek;

public class AddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans=new ListNode();
        ListNode temp=ans;
        int carry=0;

        while(l1!=null||l2!=null){
            int v1=(l1==null)?0:l1.val;
            int v2=(l2==null)?0:l2.val;
            int sum=v1+v2+carry;
            carry=sum/10;
            temp.next=new ListNode(sum%10);
            temp=temp.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }

        return ans.next;

        // ListNode ans=new ListNode();
        // ListNode temp=ans;
        // int carry=0;

        // while(l1!=null||l2!=null){
        //     int v1=(l1==null)?0:l1.val;
        //     int v2=(l2==null)?0:l2.val;

        //     int sum=v1+v2+carry;
        //     temp.next=new Node(sum);
        // }

        // ListNode temp=new ListNode();
        // ListNode head=temp;
        // int carry=0;

        // while(l1!=null || l2!=null){
        //     int l1val=(l1!=null)?l1.val:0;
        //     int l2val=(l2!=null)?l2.val:0;

        //     int esi=l1val+l2val+carry;
        //     carry=esi/10;

        //     ListNode newNode=new ListNode(esi%10);
        //     temp.next=newNode;

        //     if(l1!=null)l1=l1.next;
        //     if(l2!=null)l2=l2.next;
        //     temp=temp.next;
        // }
        // if(carry>0){
        //     ListNode hh=new ListNode(carry);
        //     temp.next=hh;
        // }
        // return head.next;
    }
}