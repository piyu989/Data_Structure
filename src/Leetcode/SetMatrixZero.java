package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{1,1,1},{1,0,1},{1,1,1}};
		
		 List<Integer>li=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    li.add(i);
                    li.add(j);
                }
            }
        }

        for(int i=0;i<li.size();i=i+2){
            int temp=li.get(i);
            int temp2=li.get(i+1);
            for(int j=0;j<matrix.length;j++){
                for(int k=0;k<matrix[0].length;k++) {
                	if(j==temp || temp2==k) {
                		matrix[j][k]=0;
                	}
                }
            }
        }
		System.out.println(li);
		
		for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }
		
	}

}
