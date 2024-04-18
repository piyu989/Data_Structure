package Recursion;

public class DiceProblem {
	public static void main(String args[]) {
//		ans("",5);
		int t=anss("",5);
		int ans=t*300;
		System.out.println(ans);
	}
	static int anss(String p,int trgt) {
		if(0==trgt) {
//			System.out.println(p);
			return 1;
		}
		int ans=0;
		for(int i=1;i<=6&&i<=trgt;i++) {
			ans+=anss(p+i, trgt-i);
		}
		return ans;
	}
//	static void ans(String p,int trgt) {
//		if(0==trgt) {
//			System.out.println(p);
//			return;
//		}
//		for(int i=1;i<=6&&i<=trgt;i++) {
//			ans(p+i, trgt-i);
//		}
//	}
}
