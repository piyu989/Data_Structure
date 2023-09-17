package Greddy;

import java.util.Arrays;

public class MinimumSumAbsoluteDifference {

	public static void main(String[] args) {
		int a[]= {2,1,3};
		int b[]= {1,2,3};
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ans=0;
		for(int i=0;i<a.length;i++) {
			ans=Math.abs(a[i]-b[i]);
		}
		System.out.println(ans);
	}

}
