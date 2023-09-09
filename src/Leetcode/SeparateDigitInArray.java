package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/separate-the-digits-in-an-array/

public class SeparateDigitInArray {
	
	static int len(int n){
        int ans=0;

        while(n!=0){
            ans++;
            n=n/10;
        }

        return ans;
    }

    static int[] ans(int arr[]){
		int j=0;
		HashMap<Integer, Integer>map=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int l=len(arr[i]);
            while(l!=0){
                map.put(j, arr[i]/(int)Math.pow(10, l-1));
                // System.out.println(map.get(j));
                arr[i]%=(int)Math.pow(10, l-1);
                l--;
                j++;
            }
        }        
        
        int ans[]=new int[map.size()];
        j=0;
        for(int i=0;i<ans.length;i++){
            ans[j]=map.get(j);
            j++;
        }

		return ans;		
    }

    static int[] optimize(int arr[]) {
    	List<Integer>list=new ArrayList<>();
    	
    	for(int i=0;i<arr.length;i++) {
    		String s=arr[i]+"";
    		for(int j=0;j<s.length();j++) {
    			list.add(s.charAt(j)-'0');
    		}
    	}
    	
    	int ans[]=new int[list.size()];
    	for(int i=0;i<ans.length;i++) {
    		ans[i]=list.get(i);
    	}
    	return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {838};
		int ans[]=optimize(arr);
		for(int i:ans) {
			System.out.print(i+" ");
		}

  
	}	 

}
