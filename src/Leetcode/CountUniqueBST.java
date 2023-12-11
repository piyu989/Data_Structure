package Leetcode;

//https://leetcode.com/problems/unique-binary-search-trees/description/

public class CountUniqueBST {
	
	static int ans(int n) {
		int dp[]=new int[n+1];
		
		dp[0]=dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				int leftSubTree=dp[j];
				int rightSubTree=dp[i-j-1];
				dp[i]+=leftSubTree*rightSubTree;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans(5));
	}

}
