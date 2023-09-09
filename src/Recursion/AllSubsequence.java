package Recursion;

public class AllSubsequence {

	public static void ans(String pro,String unpro) {
		if(unpro.isEmpty()) {
			System.out.print(pro+" ");
			return;
		}
		char c=unpro.charAt(0);
		ans(pro, unpro.substring(1));
		ans(pro+c, unpro.substring(1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ans("","abc");
	}

}
