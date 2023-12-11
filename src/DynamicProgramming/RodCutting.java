package DynamicProgramming;

public class RodCutting {
	
	static int ans(int leng[],int pri[],int W) {
		int dp[][]=new int[leng.length+1][W+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(leng[i-1]<=j) {
					dp[i][j]=Math.max(pri[i-1]+dp[i][j-leng[i-1]], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static void main(String args[]) {
		int l[]= {1,2,3,4,5,6,7,8};
		int p[]= {1,5,8,9,10,17,17,20};
		System.out.println(ans(l, p, 8));
	}
}
