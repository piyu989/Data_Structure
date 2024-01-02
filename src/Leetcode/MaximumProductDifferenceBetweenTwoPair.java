package Leetcode;

//https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/?envType=daily-question&envId=2023-12-18

import java.util.Arrays;
import java.util.HashMap;

public class MaximumProductDifferenceBetweenTwoPair {
	
	static int ans(int arr[]) {
		int max=Integer.MIN_VALUE,max1=Integer.MIN_VALUE,min=Integer.MAX_VALUE,min1=Integer.MAX_VALUE;
		
		for(int i:arr) {
			if(i>max) {
				max1=max;
				max=i;
			}else if(i>max1) {
				max1=i;
			}
			if(i<min) {min1=min;min=i;}
			else if(i<min1)min1=i;
		}
		return (max*max1)-(min*min1);
	}
	
	public static void main(String args[]) {
		int arr[]= {4,2,5,9,7,4,8};
		
		System.out.println(ans(arr));
	}

}
