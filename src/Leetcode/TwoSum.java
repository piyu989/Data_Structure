package Leetcode;

import java.util.HashMap;

public class TwoSum {

	static int[] ans(int num[],int trgt) {
		int ans[]=new int[2];
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int i=0;i<num.length;i++) {
			if(hm.containsKey(trgt-num[i])) {
				ans[0]=i;
				ans[1]=hm.get(trgt-num[i]);
				break;
			}else {
				hm.put(num[i], i);
			}
		}
		return ans;
	}
	
	public static void main(String args[]) {
		int nums[]= {2,7,11,15};
		int ans[]=ans(nums, 9);
		
		for(int i:ans) {
			System.out.println(i);
		}
	}
}
