package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
	static public void nextPermutation(int[] arr) {
		for(int i=arr.length-2;i>=0;i--) {
			int idx=i+1;
			if(arr[idx]>arr[i]) {
				int temp=arr[idx];
				arr[idx]=arr[i];
				arr[i]=temp;
				break;
			}
		}
    }
	public static void main(String args[]) {
		int arr[]= {1,3,2};
		nextPermutation(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
