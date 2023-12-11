package Leetcode;

//https://leetcode.com/problems/transpose-matrix/submissions/1116623985/?envType=daily-question&envId=2023-12-10

public class TransposeMatrix {

	static int[][] transpose(int arr[][]){
		int ans[][]=new int[arr[0].length][arr.length];
		
		for(int i=0;i<ans[0].length;i++) {
			for(int j=0;j<ans.length;j++) {
				ans[j][i]=arr[i][j];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,2,3},{4,5,6}};
		arr=transpose(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
	}

}
