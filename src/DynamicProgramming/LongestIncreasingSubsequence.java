package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {

	static int longestIncreasingSubsequence(int arr1[]) {
		HashSet<Integer>hs=new HashSet<>();
		for(int i=0;i<arr1.length;i++) {
			hs.add(arr1[i]);
		}

		int i=0;
		int arr2[]=new int[hs.size()];
		for(int t:hs) {
			arr2[i++]=t;
		}
		
		Arrays.sort(arr2);
		
		return ans(arr1,arr2);
	}
	
	static int ans(int nums1[],int nums2[]) {
		int dp[][]=new int[nums1.length+1][nums2.length+1];
		
		for(int i=1;i<nums1.length+1;i++) {
			for(int j=1;j<nums2.length+1;j++) {
				if(nums1[i-1]==nums2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[nums1.length][nums2.length];
		
	}
	
	static int ans(int nums[]) {
		int temp[]=new int[nums.length];
		
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					temp[i]=Math.max(temp[i], temp[j]+1);
				}
			}
		}
		int ans=0;
		for(int i:temp) {
			if(i>ans) {
				ans=i;
			}
		}
		return ans+1;
	}
	
	public static void main(String[] args) {
		int arr[]= {50,3,10,7,40,80};
		
		System.out.println(longestIncreasingSubsequence(arr));
		System.out.println(ans(arr));
		
	}

}
