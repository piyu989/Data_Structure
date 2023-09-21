package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TheKWeakestRowsInMatrix {
	
	static int lowest(HashMap<Integer,Integer>hm) {
		int l=Integer.MAX_VALUE;
		for(int i=0;i<hm.size();i++) {
			l=Integer.min(l, hm.get(i));
		}
		hm.remove(l);
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]={{1,1,0,0,0},
		             {1,1,1,1,0},
		             {1,0,0,0,0},
		             {1,1,0,0,0},
		             {1,1,1,1,1}};
		int k=3;
		
		HashMap<Integer,Integer>hm=new HashMap<>();
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[0].length;j++){
                sum+=arr[i][j];
            }
            hm.put(i,sum);
            min=Integer.min(min, sum);
        }
        int ans[]=new int[k];
        int temp=0;
        while(k!=0) {
        	ans[temp]=lowest(hm);
        	hm.remove(ans[temp]);
        	temp++;
        }
        for(int i:ans) {
        	System.out.println(i);
        }
	}

}
