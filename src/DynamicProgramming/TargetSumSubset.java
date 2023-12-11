package DynamicProgramming;

public class TargetSumSubset {
	
	static boolean ans(int arr[],int trgt) {
		boolean dp[][]=new boolean[arr.length+1][trgt+1];
		for(int i=0;i<arr.length+1;i++) {
			dp[i][0]=true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				int v=arr[i-1];
				if(v<=j&&dp[i-1][j-v]==true) {
					dp[i][j]=true;
				}else if(dp[i-1][j]==true) {
					dp[i][j]=true;
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[]={1,2,3,4,18};
        System.out.println(ans(ar,19));
	}

}
