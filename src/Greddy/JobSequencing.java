package Greddy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
	
	static class Job{
		int strtDate;
		int lstDate;
		int payment;
		public Job(int strtDate, int lstDate, int payment) {
			super();
			this.strtDate = strtDate;
			this.lstDate = lstDate;
			this.payment = payment;
		}
		
	}
	
	public static void main(String args[]) {
		int arr[][]= {{4,20},{1,10},{1,40},{1,30}};
		
		ArrayList<Job>li=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			li.add(new Job(i,arr[i][0],arr[i][1]));
		}
		
		Collections.sort(li,(a,b)->b.payment-a.payment);
		
		ArrayList<Integer>ans=new ArrayList<>();
		int time=0;
		
		for(int i=0;i<li.size();i++) {
			Job j=li.get(i);
			if(j.lstDate>time) {
				time++;
				ans.add(j.payment);
			}
		}
		System.out.println(ans);
	}
}
