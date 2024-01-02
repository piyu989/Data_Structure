package Recursion;

public class Palandrome {

	static boolean ans1(int n) {
		int digit=(int)Math.log10(n)+1;
		return help1(n,digit);
	}
	
	static boolean help1(int n,int digit) {
		if(n<=9) {
			return true;
		}
		if(n%10==n/(int)Math.pow(10, digit-1)) {
			n=n/10;
			digit=(int)Math.log10(n)+1;
			n=n%(int)Math.pow(10, digit-1);
			return help1(n,digit-1);
		}
		return false;
	}
	
	static int reverse(int n,int re) {
		if(n==0) {
			return re;
		}else {
			re=re*10+n%10;
			return reverse(n/10, re);
		}
	}
	
	static boolean palandrome(int n) {
		return n==reverse(n,0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=98689;
//		int n=98;
//		n=n/10;
//		n=n%10;
//		System.out.println(n);
//		System.out.println(ans1(n));
		System.out.println(palandrome(n));
	}

}
