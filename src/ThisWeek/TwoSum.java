package ThisWeek;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,7,11,15};
		int trgt=9;
		int ans[]=new int[2];
		
		HashMap<Integer, Integer>hm=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(hm.containsKey(trgt-arr[i])) {
				ans[0]=i;
				ans[1]=hm.get(trgt-arr[i]);
			}
			hm.put(arr[i], i);
		}
	}

}
