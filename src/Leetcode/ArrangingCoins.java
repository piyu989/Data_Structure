package Leetcode;

public class ArrangingCoins {
	
	static int ans(int n) {
		int i=0,j=n;
		
		while(i<=j) {
			int mid=(i+j)/2;
			long trgt=((long)mid*(mid+1))/2;
			if(trgt==n) {
				return mid;
			}else if(trgt>n)j=mid-1;
			else i=mid+1;
		}
		return j;
	}
	
	public static void main(String args[]) {

	}
}
