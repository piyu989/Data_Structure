package Hashing;

import java.util.HashSet;

public class UnionAndIntersection{
	public static void main(String args[]) {
		int arr[]= {7,3,9};
		int arr2[]= {6,3,9,2,9,4};
		
		HashSet<Integer> hs=new HashSet<>();
		//For Union
		for(int i=0;i<arr.length||i<arr2.length;i++) {
			if(i<arr.length) {
				hs.add(arr[i]);
			}
			if(i<arr2.length) {
				hs.add(arr2[i]);
			}
		}
		System.out.println(hs);
		
		hs.clear();
		
		//For intersection
		for(int i:arr) {
			hs.add(i);
		}
		
		for(int i:arr2) {
			if(hs.contains(i)) {
				hs.remove(i);
				System.out.print(i+" ");
			}
		}
		
	}
}