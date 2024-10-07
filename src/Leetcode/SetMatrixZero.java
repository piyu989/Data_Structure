package Leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{1,1,1},{1,0,1},{1,1,1}};
		
//		List<Integer>li=new ArrayList<>();
//
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                if(matrix[i][j]==0){
//                    for(int x=0;x<matrix.length;x++) {
//                    	matrix[i][0]=0;
//                    }
////                    for(int x=i;x>=0;x--) {
////                    	matrix[i][0]=0;
////                    }
//                    for(int x=0;x<matrix[0].length;x++) {
//                    	matrix[0][j]=0;
//                    }
////                    for(int x=j;x>=0;x--) {
////                    	matrix[0][j]=0;
////                    }
//                }
//            }
//        }
//
////        for(int i=0;i<li.size();i=i+2){
////            int temp=li.get(i);
////            int temp2=li.get(i+1);
////            for(int j=0;j<matrix.length;j++){
////                for(int k=0;k<matrix[0].length;k++) {
////                	if(j==temp || temp2==k) {
////                		matrix[j][k]=0;
////                	}
////                }
////            }
////        }
////		System.out.println(li);
////	
		optimize(matrix);
		
		for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }
		
	}
	
	static void optimize(int matrix[][]) {
		boolean rowZero=false;
		boolean colZero=false;
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				rowZero=true;
			}
		}
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i]==0) {
				colZero=true;
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[i][0]==0||matrix[0][j]==0) {
					matrix[i][j]=0;
				}
			}
		}
		
		if(rowZero) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0]=0;
			}
		}
		if(colZero) {
			for(int i=0;i<matrix[0].length;i++) {
				matrix[0][i]=0;
			}
		}
	}

}
