package Leetcode;

//https://leetcode.com/problems/longest-common-subsequence/description/

public class LongestIncreasingSubsequence {
	
	static int ans(int nums[]) {
		int ans[]=new int[nums.length];
			
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					ans[i]=Math.max(ans[i], ans[j]+1);
				}
			}
		}
		int m=0;
		
		for(int i:ans) {
			if(i>m) {
				m=i;
			}
		}
		return m+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {50,3,10,7,40,80};
		
		System.out.println(ans(arr));
	}

}
