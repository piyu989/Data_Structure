package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayOrNot {
	
	static boolean isSorted(int arr[]) {
		return help(arr,0);
	}
	
	static boolean help(int arr[],int i) {
		if(i==arr.length-1) {
			return true;
		}
		if(arr[i]>arr[i+1])return false;
		return help(arr,i+1);
	}
	
	static List<Integer> search(int arr[],int trgt,int i){
		List<Integer> li=new ArrayList<>();
		if(i==arr.length) {
			return li;
		}
		if(arr[i]==trgt) {
			li.add(i);
		}
		List<Integer>fromBelowCalls=search(arr, trgt, i+1);
		li.addAll(fromBelowCalls);
		return li;
	}
	
	public static void main(String args[]) {
		int arr[]= {1,2,3,4,5,6,6,6,7,1};
		
		System.out.println(isSorted(arr));
		System.out.println(search(arr, 6, 0));
	}
}
