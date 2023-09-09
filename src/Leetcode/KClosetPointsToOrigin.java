package Leetcode;

import java.util.PriorityQueue;

public class KClosetPointsToOrigin {
	
	public static int[][] mine(int[][] arr, int k) {
        int ans[][]=new int[k][2];
        PriorityQueue<Integer> p=new PriorityQueue<>(); 

        for(int i=0;i<arr.length;i++){
            int dist=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
            p.add(dist);
        }
        
        int temp=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<arr.length;j++){
                int dist=arr[j][0]*arr[j][0]+arr[j][1]*arr[j][1];
                if(dist==p.peek()){
                    ans[temp][0]=ans[j][0];
                    ans[temp][1]=ans[j][1];
                    temp++;
                    break;
                }
            }
        }
        return ans;
    }
	
	public static int[][] ans(int[][] arr, int k) {
		int ans[][]=new int[k][2];
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])); 
        for(int[] i:arr){
            p.add(i);
            if(p.size()>k){
                p.remove();
            }
        }
        while(k-->0){
            ans[k]=p.remove();
        }
        return ans;
    }

	public static void main(String[] args) {
		int arr[][]= {{0,1},{0,1}};
		int k=2;
		int ans[][]=ans(arr,2);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
        
	}

}
