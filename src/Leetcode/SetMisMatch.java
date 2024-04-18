package Leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class SetMisMatch {

	public static void main(String[] args) {
//		int nums[]= {1,3,3};
		// 3,2
//		int nums[]= {1,2,2,4};
		int nums[]= {3,2,3,4,6,5};
		int ans[]=sol(nums);
		for(int i:ans) {
			System.out.print(i+" ");
		}
	}
	
	static int[] sol(int nums[]) {
		int ans[]=new int[2];
		int req=0;
		int cur=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(i<nums.length-1&&nums[i]==nums[i+1])ans[0]=nums[i];
			req+=i+1;
			cur+=nums[i];
		}
		ans[1]=req-cur+ans[0];
		return ans;
	}

}
