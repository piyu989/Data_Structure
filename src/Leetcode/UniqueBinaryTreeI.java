package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/unique-binary-search-trees/description/

public class UniqueBinaryTreeI {

	static int help(int n,int dp[]) {
		if(n<=1) {
			return 1;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int ans=0;
		for(int i=1;i<=n;i++) {
			ans+=help(i-1,dp)*help(n-i,dp);
		}
		return dp[n]=ans;
	}
	
	static int ans(int n) {
		int []dp=new int[n+1];
		Arrays.fill(dp, -1);
		
		return help(n,dp);
	}
	
	static int usingTab(int n) {
		int dp[]=new int[n+1];
		
		dp[0]=dp[1]=1;
		
		//i represent number of nodes
		for(int i=2;i<=n;i++) {
			//j represent root node
			for(int j=1;j<=i;j++) {
				dp[i]+=dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(usingTab(3));
	}

}
