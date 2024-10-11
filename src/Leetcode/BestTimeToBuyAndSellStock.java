package Leetcode;

public class BestTimeToBuyAndSellStock {
	public static void main(String args[]) {
		int arr[]= {7,1,5,3,6,4};
		
		int min=Integer.MAX_VALUE;
		int profit=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}else if(arr[i]-min>profit) {
				profit=arr[i]-min;
			}
		}
		System.out.println(profit);
	}
}
