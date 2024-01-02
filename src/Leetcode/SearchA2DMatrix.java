package Leetcode;

public class SearchA2DMatrix {

	static boolean ans(int matrix[][],int target) {
		boolean ans=false;
		for(int i=0;i<matrix.length;i++) {
			if(target>matrix[i][1]) {
				for(int j=0;j<matrix[0].length;j++) {
					if(matrix[i][j]==target)ans=true;
				}
			}
		}
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==target)ans=true;
			}
		}
		return ans;
	}
	
	
	
	public static void main(String[] args) {

	}

}
