package Leetcode;

public class JumpGame {
	public static void main(String args[]) {
		int arr[]= {2,3,1,1,4};
		System.out.println(jump(arr));
	}
	
	static boolean jump2(int nums[]) {
		int first=0;
		
		for(int i=0;i<nums.length-1;i++) {
			if(first<i)return false;
			first=Math.max(first, nums[i]+i);
			if(first>=nums.length) {
				return true;
			}
		}
		return false;
	}
	
	static boolean jump(int nums[]) {
		int lstIndex=nums.length-1;
		
		for(int i=nums.length-2;i>=0;i--) {
			if(nums[i]+lstIndex>lstIndex) {
				lstIndex=i;
			}
		}
		
		return lstIndex==0;
	}
}
