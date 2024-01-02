package Leetcode;

//https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/?envType=daily-question&envId=2023-12-13

public class SpecialPositionsInABinaryMatrix {

	static int ans(int arr[][]) {
		int ans=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==1&&check(i,j,arr)) {
					ans++;
				}
			}
		}
		return ans;
	}
	static boolean check(int i,int j,int arr[][]) {
		for(int k=0;k<arr.length;k++) {
			if(arr[i][k]==1&&k!=j) {
				return false;
			}
		}
		
		for(int k=0;k<arr[0].length;k++) {
			if(arr[k][j]==1&&k!=i) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int arr[][]={{1,2,3},{4,5,1},{1,23,32}};
        int ar[][]={{1,2,3},{5,1,6},{9,8,1}};
		
		System.out.println(ans(arr));
		System.out.println(ans(ar));
	}

}
