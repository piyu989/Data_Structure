package Greddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySessionUnoreder{
	public static void main(String args[]) {
		int strt[]= {2 ,6 ,4, 1, 4 ,2, 3};
		int end[]= {4,10,9,9,4,5,4};
		int activity[][]=new int[strt.length][3];
		for(int i=0;i<strt.length;i++) {
			activity[i][0]=i;
			activity[i][1]=strt[i];
			activity[i][2]=end[i];
		}
		
		Arrays.sort(activity,Comparator.comparingDouble(e->e[2]));

		int max=0;
		ArrayList<Integer>li=new ArrayList<>();
		li.add(activity[0][0]);
		int lstMax=activity[0][2];
		
		for(int i=0;i<strt.length;i++) {
			if(activity[i][1]>=lstMax) {
				lstMax=activity[i][1];
				max++;
				li.add(activity[i][0]);
			}
		}
		System.out.println(max);
		
	}
}