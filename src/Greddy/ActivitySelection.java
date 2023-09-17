package Greddy;

import java.util.ArrayList;

public class ActivitySelection{
	public static void main(String args[]) {
		int strt[]= {1,3,0,5,8,5};
		int end[]= {2,4,6,7,9,9};
		
		ArrayList<Integer>li=new ArrayList<>();
		
		int maxAct=1;
		int lstAct=end[0];
		li.add(strt[0]);
		for(int i=1;i<strt.length;i++) {
			if(strt[i]>=lstAct) {
				maxAct++;
				li.add(strt[i]);
				lstAct=end[i];
			}
		}
		for(int i:li) {
			System.out.println(i);
		}
		System.out.println(maxAct);
		
	}
}