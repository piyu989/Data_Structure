package Leetcode;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
	
	static int[][] ans(int arr[][]){
        int ans[][]=new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int k=0;k<arr[0].length;k++){    
                int oneRow=0;
                int oneCol=0;
                int zeroRow=0;  
                int zeroCol=0;
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]==0){
                        zeroCol++;
                    }else{
                        oneCol++;
                    }
                }

                for(int j=0;j<arr.length;j++){
                    if(arr[j][k]==0){
                        zeroRow++;
                    }else{
                        oneRow++;
                    }
                }
                ans[i][k]=oneRow+oneCol-zeroRow-zeroCol;
            }
        }
        return ans;
    }
	
	static int[][] sol(int arr[][]) {
		int rowCount[]=new int[arr.length];
        int colCount[]=new int[arr[0].length];
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                rowCount[i]+=arr[i][j];
                colCount[j]+=arr[i][j];
            }
        }

        int ans[][]=new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                int oneRow=rowCount[i];
                int oneCol=colCount[j];
                int zeroRow=arr.length-oneRow;
                int zeroCol=arr[0].length-oneCol;
                ans[i][j]=oneRow+oneCol-zeroRow-zeroCol;
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
