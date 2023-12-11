package DynamicProgramming;

public class UnboundedKnapsack {
	
	static int bounded(int val[],int wt[],int W) {
		int dp[][]=new int[val.length+1][W+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(wt[i-1]<=j) {
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-i][j]; 
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	static int unbounded(int val[],int wt[],int W) {
		int dp[][]=new int[val.length+1][W+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(wt[i-1]<=j) {
					dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vl[]= {15,14,10,45,30};
		int wt[]= {2,5,1,3,4};
		int W=7;
		System.out.println(bounded(vl, wt, W));
		System.out.println(unbounded(vl, wt, W));
	}

}
