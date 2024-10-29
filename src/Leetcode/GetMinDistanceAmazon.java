package Leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetMinDistanceAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> center=new ArrayList<>();
		List<Integer> des=new ArrayList<>();
		center.add(1);
		center.add(2);
		center.add(2);

		des.add(5);
		des.add(2);
		des.add(4);
		
		System.out.println(getMinDistance(center, des));
		
	}
	public static long getMinDistance(List<Integer> center, List<Integer> destination) {
	    // Write your code here
		Collections.sort(center);
		Collections.sort(destination);
		
		long ans=0l;
		
		for(int i=0;i<center.size();i++) {
			ans+=Math.abs(center.get(i)-destination.get(i));
		}
		
		return ans;

	}

}
