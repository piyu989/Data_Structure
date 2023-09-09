package Recursion;

public class TowerOfHanoi {
	
	static void ans(int n,char source,char help,char destination) {
		if(n==1) {
			System.out.println("move disk "+n+" from "+source+" to "+destination);
			return;
		}
		ans(n-1,source, destination, help);
		System.out.println("move disk from "+n+" from "+source+" to "+destination);
		ans(n-1, help, source, destination);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ans(2	, 'A', 'B', 'C');
	}

}
