package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	static List<List<Integer>> ans(int nums[]){
		Set<List<Integer>>ans=new HashSet<>();
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++) {
			int j=i+1;
			int k=nums.length-1;
			
			while(j<k) {
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==0) {
					ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
					j++;
					k--;
					while(j<k&&nums[j]==nums[j-1])j++;
					while(j<k&&nums[k]==nums[k+1])k--;
				}
				else if(sum>0) {
					k--;
				}
				else {
					j++;
				}
			}
		}
		return new ArrayList<>(ans);
	}
	
	public static void main(String args[]) {
		int nums[]={3,0,-2,-1,1,2};
        System.out.println(ans(nums));
	}
}
