package DynamicProgramming;

public class MatrixChainMultiplilcation {

	static int ans(int arr[],int i,int j) {
		if(i==j) {
			return 0;
		}
		
		int min=Integer.MAX_VALUE;
		
		for(int k=i;k<=j-1;k++) {
			int a1=ans(arr, i, k);
			int a2=ans(arr, k+1, j);
			int a3=arr[i-1]*arr[j]*arr[k];
			int finalAns=a1+a2+a3;
			min=Math.min(min, finalAns);
		}
		return min;
	}
	
	static int sol(int arr[]) {
		int dp[][]=new int[arr.length][arr.length];
		
		for(int len=2;len<arr.length;len++) {
			for(int i=1;i<=arr.length-len;i++) {
				int j=i+len-1;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int a1=dp[i][k];
					int a2=dp[k+1][j];
					int a3=arr[i-1]*arr[j]*arr[k];
					dp[i][j]=Math.min(dp[i][j], a1+a2+a3);
				}
			}
		}
		return dp[1][arr.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,3};
		System.out.println(ans(arr, 1, arr.length-1));
		System.out.println(sol(arr));
	}

}
