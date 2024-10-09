package Leetcode;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/next-permutation/submissions/1416261122/

public class NextPermutation {
	static public void nextPermutation(int[] arr) {
		int idx=-1;
		
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]<arr[i+1]) {
				idx=i;
				break;
			}
		}
		if(idx!=-1) {
			Arrays.sort(arr);
		}
		
		for(int i=arr.length-1;i>idx;i--) {
			if(arr[i]>arr[idx]) {
				int temp=arr[i];
				arr[i]=arr[idx];
				arr[idx]=temp;
				break;
			}
		}
		Arrays.sort(arr,idx+1,arr.length);
    }
	public static void main(String args[]) {
		int arr[]= {1,3,2};
		nextPermutation(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
