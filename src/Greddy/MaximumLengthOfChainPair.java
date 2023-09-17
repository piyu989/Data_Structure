package Greddy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfChainPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{5,24},{39,60},{5,28},{27,40},{50,90}};
		
		Arrays.sort(arr,Comparator.comparingDouble(e->e[1]));
		int lstmax=arr[0][1];
		int ans=1;
		for(int i=0;i<arr.length;i++) {
			if(lstmax<arr[i][0]) {
				lstmax=arr[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}

}
