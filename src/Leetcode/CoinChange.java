package Leetcode;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/coin-change/

public class CoinChange {

	static int ans(int coins[],int amount) {
		int dp[]=new int[amount+1];
		for(int i=1;i<=amount;i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int c:coins) {
				if(c<=i&&dp[i-c]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], 1+dp[i-c]);
				}
			}
		}
		if(dp[amount]!=Integer.MAX_VALUE) {
			return dp[amount];
		}return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method s
	      int arr[]={186,419,83,408};
	        System.out.println(ans(arr,6249));
	}

}
