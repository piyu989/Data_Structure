package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElement {
	
	static int[] ans(int nums[],int k) {
		HashMap<Integer,Integer>hm=new HashMap<>();
		List<Integer>li[]=new List[nums.length+1];
		
		for(int i:nums) {
			hm.put(i, hm.getOrDefault(i,0)+1);
		}
		
		for(int i:hm.keySet()) {
			int freq=hm.get(i);
			if(li[freq]==null) {
				li[freq]=new ArrayList<>();
			}
			li[freq].add(i);
		}
		
		int ans[]=new int[k];
		k=0;
		
		for(int i=li.length-1;i>=0;i--) {
			if(k==ans.length) {
				break;
			}
			if(li[i]!=null) {
				for(int j:li[i]) {
					ans[k++]=j;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1,1,2,2,3};
		int an[]=ans(arr,1);
		for(int i:an) {
        	System.out.println(i);
        }
	}

}
