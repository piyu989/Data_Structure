package Hashing;

import java.util.HashSet;

public class CountDistinctElemeny {

	public static void main(String[] args) {
		int arr[]= {9,7,4,5,44,6,9,1,2,1};
		
		HashSet<Integer>hs=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			hs.add(arr[i]);
		}
		
		System.out.println(hs.size());
	}

}
