package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/problems/majority-element/

public class MajorityElement {
	
	static int ans(int nums[]) {
		
		HashMap<Integer,Integer>hm=new HashMap<>();
		
		for(int i:nums) {
			hm.put(i, hm.getOrDefault(i, 0)+1);
		}
		int max=Integer.MIN_VALUE;
		
		for(int i:nums) {
			max=Math.max(max, hm.get(i));
		}
		
		for(Map.Entry entry:hm.entrySet()) {
			if(max==(int)entry.getValue()) {
				max=(int)entry.getKey();
				break;
			}
		}
		return max;
	}
	
	
	//initution for this is that if any element is occuring more 
	//than n/2 times it will dominant the array
	static int sol(int nums[]) {
		int count=0;
		int max=0;
		for(int i:nums) {
			if(count==0) {
				max=i;
			}
			if(i==max) {
				count++;
			}else {
				count--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {3,3,4};
		
		System.out.println(sol(nums));
	}

}
