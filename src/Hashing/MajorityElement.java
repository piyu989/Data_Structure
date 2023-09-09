package Hashing;

import java.util.HashMap;
import java.util.Set;

/*hashmap are unordered map
 * */

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {9,9,7,6,9,1,1,1,1,3};
		int n=arr.length/3;
		
		HashMap<Integer, Integer>hm=new HashMap<>();
//		HashMap<Integer, Integer>ans=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
		}
		
		Set<Integer> set=hm.keySet();
		
		for(int i:set) {
			if(hm.get(i)>=n) {
				System.out.println(i+" = "+hm.get(i));
			}
		}

	}

}
