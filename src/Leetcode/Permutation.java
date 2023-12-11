package Leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/

public class Permutation {
	public static void main(String args[]) {
		int num[]={1,2};
        List<List<Integer>>li=sol(num);
        System.out.println(li);
	}
	static List<List<Integer>>sol(int nums[]){
		List<List<Integer>>ans=new ArrayList<>();
		ans(ans,nums,0);
		return ans;
	}
	static void ans(List<List<Integer>>ans,int nums[],int strt) {
		if(strt==nums.length) {
			ans.add(tolist(nums));
			return;
		}
		for(int i=strt;i<nums.length;i++) {
			swap(i,strt,nums);
			ans(ans,nums,strt+1);
			swap(i,strt,nums);
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
}
