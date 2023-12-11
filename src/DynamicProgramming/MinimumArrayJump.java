package DynamicProgramming;

import java.util.Arrays;

public class MinimumArrayJump {
	
	static int ans(int nums[]) {
		int curReach=0;
		int maxReach=0;
		int jump=0;
		for(int i=0;i<nums.length-1;i++) {
			maxReach=Math.max(maxReach, nums[i]+i);
			if(curReach==i) {
				jump++;
				if(maxReach>=nums.length-1) {
					break;
				}curReach=maxReach;
			}
		}
		return jump;
	}

	static int jump(int arr[]) {
		int n=arr.length;
		int dp[]=new int[n];
		Arrays.fill(dp, -1);
		
		dp[n-1]=0;
		
		for(int i=n-2;i>=0;i--) {
			int steps=arr[i];
			int ans=Integer.MAX_VALUE;
			
			for(int j=i+1;j<=steps+i && j<n;j++) {
				if(dp[j]!=-1) {
					ans=Math.min(ans, dp[j]+1);
				}
			}
			if(ans!=Integer.MAX_VALUE) {
				dp[i]=ans;
			}
		}
		
		return dp[0];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,1,1,1,1};
		System.out.println(ans(arr));
	}

}
