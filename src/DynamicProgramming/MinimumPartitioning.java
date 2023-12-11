package DynamicProgramming;

public class MinimumPartitioning {

	static int ans(int arr[]) {
		int n=arr.length;
		int sum=0;
		for(int i:arr) {
			sum+=i;
		}
		int wt=sum/2;
		int dp[][]=new int[n+1][wt+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=wt;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		int sum1=dp[arr.length][wt];
		int sum2=sum-sum1;
		return Math.abs(sum1-sum2);
//		return dp[arr.length][wt];
	}
	
	public static void main(String[] args) {
		int arr[]= {36,-36};
		for(int i=0;i<arr.length;i++) {
			arr[i]=Math.abs(arr[i]);
		}
		System.out.println(ans(arr));
	}

}
