package Recursion;

public class ReverseNumber {
	
	static int ans1(int n) {
		return help1(n,0);
	}
	static int help1(int n,int ans) {
		if(n==0) {
			return ans;
		}
		ans=ans*10+n%10;
		return help1(n/10,ans);
	}
	
	static int ans2(int n) {
		int digit=(int)(Math.log10(n)+1);
		return help2(n,digit);
	}
	
	static int help2(int n,int digit) {
		if(n==0) {
			return n;
		}
		int rem=n%10;
		return rem*(int)Math.pow(10, digit-1)+help2(n/10,digit-1);
	}
	
	public static void main(String args[]) {
		int n=1234;
		System.out.println(ans2(n));
	}
}
