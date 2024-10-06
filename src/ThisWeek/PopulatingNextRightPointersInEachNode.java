package ThisWeek;

public class PopulatingNextRightPointersInEachNode {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node next;
		
		Node(int _val) {
			data = _val;
	        left = null;
	        right = null;
	        next = null;
	    }
	}
	
	static Node connect(Node root) {
		if(root==null)return null;
		
		Node temp=root;
		
		while(temp.left!=null) {
			Node cur=temp;
			while(cur!=null) {
				cur.left.next=cur.right;
				if(cur.next!=null) {
					cur.right.next=cur.next.left;
				}
				cur=cur.next;
			}
			temp=temp.left;
		}
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
