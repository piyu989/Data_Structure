package StriverA2Z;

public class ReverseInteger {
	public static void main(String args[]) {
		System.out.println(reverse(98777897));
	}
	public static int reverse(int x) {
		if(x/10==0)return x;
		
		int ans=0;
		while(x>10) {
			ans=ans*10+x%10;
			x=x/10;
		}
		ans=ans*10+x;
		
		return ans;
	}
}
