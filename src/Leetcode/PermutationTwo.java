package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;

//https://leetcode.com/problems/permutations-ii/description/

import java.util.List;
import java.util.Set;

public class PermutationTwo {

	static List<List<Integer>>ans(int nums[]){
		List<List<Integer>>ans=new ArrayList<>();
		Set<List<Integer>>set=new HashSet<>();
		
		backtrack(nums, ans, 0, set);
		
		return ans;
	}
	
	static void backtrack(int nums[],List<List<Integer>>ans,int n,Set<List<Integer>>set) {
		if(n==nums.length) {
			List<Integer>per=tolist(nums);
			if(set.add(per)) {
				ans.add(per);
			}return;
		}else {
			for(int i=n;i<nums.length;i++) {
				swap(i,n,nums);
				backtrack(nums, ans, n+1, set);
				swap(i,n,nums);
			}
		}
	}
	static List<Integer> tolist(int[]nums) {
		List<Integer>li=new ArrayList<>();
		for(int i:nums) {
			li.add(i);
		}return li;
	}
	static void swap(int i,int j,int nums[]) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1,2};
		System.out.println(ans(arr));
	}

}
