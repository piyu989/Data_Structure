package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class IndianCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		Integer arr[]= {500,2000,100,50,20,10,5,2,1};
		Arrays.sort(arr,Collections.reverseOrder());

		int ans=0;
		ArrayList<Integer>li=new ArrayList<>();
//		int cur=0;
		int amt=20015;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=amt) {
				while(arr[i]<=amt) {
					ans++;
//					cur+=arr[i];
//					System.out.println(cur);
					amt-=arr[i];
					li.add(arr[i]);
				}
			}
		}
		System.out.println(ans);
		System.out.println(li);
	}

}
