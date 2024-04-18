package Tree;

import java.util.Scanner;

public class CreateingTree {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int val){
			this.data=val;
			this.left=null;
			this.right=null;
		}
	}
	
	private static Node root;
	
	public static void add() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter root node: ");
		int val=sc.nextInt();
		root=new Node(val);
		completeTree(sc,root);
	}
	
	private static void completeTree(Scanner sc,Node root) {
		System.out.println("do you want to add at left of "+root.data+": ");
		boolean left=sc.nextBoolean();
		if(left) {
			System.out.println("enter left element of "+root.data+": ");
			root.left=new Node(sc.nextInt());
			completeTree(sc, root.left);
		}
		System.out.println("do you want to add at right of "+root.data+": ");
		
		boolean right=sc.nextBoolean();
		if(right) {
			System.out.println("enter right element of "+root.data+": ");
			root.right=new Node(sc.nextInt());
			completeTree(sc, root.right);
		}
	}
	static void display() {
		display(root);
	}
	private static void display(Node root) {
		if(root==null)return;
		System.out.print(root.data+" ");
		display(root.left);
		display(root.right);
	}
	
	public static void main(String args[]) {
//		Scanner sc=new Scanner(System.in);
//		add();
//		display();
		BT bt=new BT();
		bt.create();
		bt.print();
		
	}
}

class BT{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val){
            this.data=val;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;
    
    void create(){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter root element: ");
        root=new Node(sc.nextInt());
        create(root);
    }
    void create(Node root){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter left "+root.data+": ");
        int leval=sc.nextInt();
        if(leval==-1){
            root.left=null;
        }else{
            root.left=new Node(leval);
            create(root.left);
        }
        
        System.out.print("enter right "+root.data+": ");
        int leva=sc.nextInt();
        if(leva==-1){
            root.right=null;
            // return;
        }else{
            root.right=new Node(leva);
            create(root.right);
        }
    }
    void print(){
        // System.out.print(root.data+" ");
        print(root);
    }
    void print(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }
    
}

//class BT{
//	private Node root;
//	static class Node{
//		int data;
//		Node left;
//		Node right;
//		Node(int val){
//			this.data=val;
//			this.left=null;
//			this.right=null;
//		}
//	}
//	
//	public void preetyPrinting() {
//		preetyPrinting(root,0);
//	}
//	private void preetyPrinting(Node root,int level) {
//		if(root==null)return;
//		
//		preetyPrinting(root.right,level+1);
//		if(level!=0) {
//			for(int i=0;i<level-1;i++) {
//				System.out.print("|\t\t");
//			}
//			System.out.println("|----------->"+root.data);
//		}else {
//			System.out.println(root.data);
//		}
//		preetyPrinting(root.left,level+1);
//	}
//	
//	void display() {
//		display(root);
//	}
//	void display(Node root) {
//		if(root==null)return;
//		System.out.print(root.data+" ");
//		display(root.left);
//		display(root.right);
//	}
//	void createTree() {
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter root node: ");
//		root=new Node(sc.nextInt());
//		createTree(root);
//		sc.close();
//	}
//	void createTree(Node root) {
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter left of "+root.data+": ");
//		int val=sc.nextInt();
//		if(val==-1) {
//			root.left=null;
//		}else {
//			root.left=new Node(val);
//			createTree(root.left);
//		}
//		
//		System.out.print("Enter right of "+root.data+": ");
//		int va=sc.nextInt();
//		if(va==-1) {
//			root.right=null;
//			return;
//		}else {
//			root.right=new Node(va);
//			createTree(root.right);
//		}
//		sc.close();
//	}
//}
