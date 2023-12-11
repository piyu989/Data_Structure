package Leetcode;

//https://leetcode.com/problems/climbing-stairs/description/

public class ClimbStair {
	
	public static int ans(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
