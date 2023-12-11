	package DynamicProgramming;

public class ZeroOneKnapsack {
	
	static int knapsackTab(int vl[],int wt[],int W) {
		int dp[][]=new int[vl.length+1][W+1];
		int n=vl.length;
		
		for(int i=0;i<dp.length;i++) {
			//0th column
			dp[i][0]=0;
 		}
		for(int i=0;i<dp[0].length;i++) {
			//0th row
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=W;j++) {
				int v=vl[i-1];
				int w=wt[i-1];
				if(w<=j) {
					int incpro=v+dp[i-1][j-w];
					int expro=dp[i-1][j];
					dp[i][j]=Math.max(incpro, expro);
				}else {
					int expro=dp[i-1][j];
					dp[i][j]=expro;
				}
			}
		}
		return dp[n][W];
		
//		return 0;
	}
	
	static int knapsack(int wt[],int val[],int w,int n) {
		if(w==0||n==0) {
			return 0;
		}if(wt[n-1]<=w) {
			int ans1=val[n-1]+knapsack(wt, val, w-wt[n-1], n-1);
			int ans2=knapsack(wt, val, w, n-1);
			return Math.max(ans1, ans2);
		}else {
			return knapsack(wt, val, w, n-1);
		}
	}
	
	static int optimzieKnapsack(int wt[],int vl[],int w,int i,int dp[][]) {
		if(i==0||w==0) {
			return 0;
		}
		if(dp[i][w]!=-1) {
			return dp[i][w];
		}
		if(wt[i-1]<=w) {
			int a1=vl[i-1]+optimzieKnapsack(wt, vl, w-wt[i-1], i-1, dp);
			int a2=optimzieKnapsack(wt, vl, w, i-1, dp);
			dp[i][w]=Math.max(a1, a2);
			return dp[i][w];
		}else {
			dp[i][w]=optimzieKnapsack(wt, vl, w, i-1,dp);
			return dp[i][w];
		}
		
	}
	
	public static void main(String args[]) {
		int val[]= {15,14,10,45,30};
		int wt[]= {2,5,1,3,4};
		int w=7;
		int dp[][]=new int[val.length+1][w+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		
		System.out.println(knapsack(wt, val, w, val.length));
		System.out.println(optimzieKnapsack(wt, val, w, val.length, dp));
		System.out.println(knapsackTab(val, wt, w));
	}
}
