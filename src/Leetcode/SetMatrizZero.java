package Leetcode;

//https://leetcode.com/problems/set-matrix-zeroes/

import java.util.ArrayList;
import java.util.List;

public class SetMatrizZero {
	
	public static void setZeroes(int[][] arr) {
        List<Integer>li=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    li.add(i);
                    li.add(j);
                }
            }
        }
        
        int temp=0;
        while(!li.isEmpty() &&temp<li.size()){
            makeZero(arr,li.get(temp++),li.get(temp++));
        }

    }
    static void makeZero(int arr[][],int i,int j){
        int m=i,n=j;

        while(m>=0){
            arr[m--][j]=0;
        }
        m=i;
        n=j;
        while(n>=0){
            arr[m][n--]=0;
        }
        n=j;
        m=i;
        while(m<arr.length){
            arr[m++][n]=0;
        }
        m=i;
        n=j;
        while(n<arr[0].length){
            arr[m][n++]=0;
        }
    }
    
    static void ans(int arr[][]) {
    	boolean firstRow=false;
    	boolean firstCol=false;
    	
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<arr[0].length;j++) {
    			if(arr[i][j]==0) {
    				if(i==0)firstRow=true;
    				if(j==0)firstCol=true;
    				arr[i][0]=0;
    				arr[0][j]=0;
    			}
    		}
    	}
    	
    	for(int i=1;i<arr.length;i++) {
    		for(int j=1;j<arr[0].length;j++) {
    			if(arr[i][0]==0||arr[0][j]==0) {
    				arr[i][j]=0;
    			}
    		}
    	}
    	
    	if(firstRow) {
    		for(int i=0;i<arr[0].length;i++) {
    			arr[0][i]=0;
    		}
    	}
    	if(firstCol) {
    		for(int i=0;i<arr.length;i++) {
    			arr[i][0]=0;
    		}
    	}
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[][]={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        
//        setZeroes(arr);
        ans(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
	}

}
