package Leetcode;

public class ElementAppearingMoreThan25InSortedArray {

	static int ans(int arr[]) {
		int k=(arr.length*25)/100;
		
		int ans=0,count=0;
		
		for(int i=0;i<arr.length;i++) {
			if(ans!=arr[i]) {
				ans=arr[i];
				count=1;
			}else if(ans==arr[i]) {
				count++;
			}
			if(count>k) {
				return ans;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method s
		int arr[]= {1,2,3,3};
		System.out.println(ans(arr));
	}

}
