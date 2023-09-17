package Greddy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[]= {60,100,120};
		int weight[]= {10,20,30};
		int w=50;
		double ratio[][]=new double[val.length][2];
		
		for(int i=0;i<val.length;i++) {
			ratio[i][0]=i;
			//here we stored their ratio
			ratio[i][1]=val[i]/(double)weight[i];
		}
		//this is sort in ascending order
		Arrays.sort(ratio,Comparator.comparingDouble(e->e[1]));
		
		int capacity=w;
		int ans=0;
		
		for(int i=ratio.length-1;i>=0;i--) {
			int idx=(int)ratio[i][0];
			if(capacity>=weight[idx]) {
				capacity-=weight[idx];
				ans+=val[idx];
			}else {
				ans+=ratio[i][1]*capacity;
				break;
			}
		}
		System.out.println(ans);
		
		
	}
}
