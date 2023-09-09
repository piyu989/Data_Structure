package BinarySearchTree;

public class BuildBST {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	static class Tree{
//		Node root;
//		Tree(){
//			this.root=null;
//		}
		
//		void addNode(int val) {
//			root=add(root,val);
//		}
		Node add(Node root,int val) {
			if(root==null) {
				return new Node(val);
			}
			if(val>root.data) {
				root.right=add(root.right, val);
			}else if(val<root.data) {
				root.left=add(root.left, val);
			}else {
				return root;
			}return root;
		}
//		void inorder() {
//			if(root==null) {
//				return;
//			}
//			inorder(root.left);
//			System.out.print(root.data+" ");
//			inorder(root.right);
//		}
		int idx=1;
		boolean isAvailable(Node root,int val) {
			if(root==null) {
				return false;
			}
			if(root.data==val) {
				return true;
			}
			else if(val>root.data) {
				return isAvailable(root.right, val);
			}else {
				return isAvailable(root.left, val);
			}
		}
		int search(Node root,int val) {
			if(root==null) {
				System.out.println("element not found");
				return -1;
			}
			if(val==root.data) {
				System.out.println("value find at level "+idx);
				return val;
			}else if(val>root.data) {
				idx++;
				return search(root.right,val);
			}else {
				idx++;
				return search(root.left,val);
			}
		}
		
		void delete(Node root,int val) {
			if(root==null) {
				return;
			}
			System.out.println("opop");
			if(root.data==val&&root.left!=null||root.right==null) {
				root=root.left;
			}else if(root.data==val&&root.left==null||root.right!=null) {
				root=root.right;
			}else if(root.data==val&&root.left==null||root.right==null) {
				root=null;
			}
			
		}
		
		Node buildTree(Node root,int val) {
			if(root==null) {
				return new Node(val);
			}
			if(val<root.data) {
				root.left=buildTree(root.left, val);
			}else{
				root.right=buildTree(root.right, val);
			}return root;
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
		int arr[]= {54,3,23,11,90,2,1};
		Tree t=new Tree();
		Node root=null;
		for(int i=0;i<arr.length;i++) {
			root=t.buildTree(root, arr[i]);
		}
		t.inorder(root);
		System.out.println();
		t.delete(root, 53);
//		t.inorder(root);
//		t.search(root, 111);
//		System.out.println(t.isAvailable(root, 111));
	}

}
