package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/?envType=daily-question&envId=2023-12-12

public class MaximumProductOfTwoElementsInArray {
	
	public static int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i!=j){
                    ans=Math.max(ans,(nums[i]-1)*(nums[j]-1));
                    // continue;
                }
            }
        }
        return ans;

    }
	static int ans(int nums[]) {
		int a1=Integer.MIN_VALUE;
		int a2=Integer.MIN_VALUE;
		
		for(int i:nums) {
			if(i>=a1) {
				a2=a1;
				a1=i;
			}else if(i>a2) {
				a2=i;
			}
		}
		return (a1-1)*(a2-1);
		
	}
	public static  int maxProduct2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,4,5,2};
		System.out.println(maxProduct(arr));
	}

}
