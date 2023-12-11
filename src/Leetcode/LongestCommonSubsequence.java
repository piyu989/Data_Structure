package Leetcode;

//https://leetcode.com/problems/longest-common-subsequence/description/

public class LongestCommonSubsequence {

	static int ans(String a,String b) {
		int dp[][]=new int[a.length()+1][b.length()+1];
		for(int i=0;i<a.length()+1;i++) {
			for(int j=0;j<b.length()+1;j++) {
				dp[i][j]=-1;
			}
		}
		return help(a,b,a.length(),b.length(),dp);
	}
	
	static int help(String a,String b,int sa,int sb,int dp[][]) {
		if(sa==0||sb==0) {
			return 0;
		}if(dp[sa][sb]!=-1) {
			return dp[sa][sb];
		}if(a.charAt(sa-1)==b.charAt(sb-1)) {
			return dp[sa][sb]=help(a,b,sa-1,sb-1,dp)+1;
		}else {
			return dp[sa][sb]=Math.max(help(a, b, sa-1, sb, dp), help(a, b, sa, sb-1, dp));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans("abcde", "ace"));
	}

}
