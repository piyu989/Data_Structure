package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] num) {
        List<Integer>ans=new ArrayList<>();
        if(num.length==1){
            ans.add(num[0]);
            return ans;
        }
        if(num.length==2){
            if(num[0]==num[1]){ 
                ans.add(num[0]); 
                return ans;
            }
            for(int i:num)ans.add(i);
            return ans;
        }
        int k=num.length/3;
		Arrays.sort(num);
		
		int count=0;
        HashSet<Integer>hm=new HashSet<>();
        
		if(num[1]==num[0])count=1;
		for(int i=1;i<num.length;i++) {
			if(num[i]==num[i-1]) {count++;}
			else if(num[i]!=num[i-1]) {count=1;}

            if(count>k){
                hm.add(num[i]);
            }
		}
        ans=new ArrayList<>(hm);
        // List<Integer>tempppp=new ArrayList<>(hm);
        return ans;
    }
	
	static List<Integer>optimal(int nums[]){
		if (nums.length == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[0]);
            return ans;
        }

        int ele1=0,ele2=0,count1=0,count2=0;
        for(int i:nums){
            if(i==ele1)count1++;
            else if(i==ele2)count2++;
            else if(count1==0){ele1=i;count1=1;}
            else if(count2==0){ele2=i;count2=1;}
            else{count1--;count2--;}
        }

        count1=0;count2=0;
        int k=nums.length/3;
        for(int i:nums){
            if(i==ele1)count1++;
            else if(i==ele2)count2++;
        }
        List<Integer> ans = new ArrayList<>();

        if(count1>k)ans.add(ele1);
        if(count2>k&&ele1!=ele2)ans.add(ele2);

        return ans;
	}
	
	public static List<Integer> ans(int[] nums) {	
		HashMap<Integer,Integer>hm=new HashMap<>();
		
		List<Integer>li=new ArrayList<>();
        HashSet<Integer>hs=new HashSet<>();
		
		int k=nums.length/3;
        int temp=0;
		
		for(int i=0;i<nums.length;i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
			if(hm.get(nums[i])>k) {
                hs.add(nums[i]);
			}
		}
        li=new ArrayList<>(hs);
		return li;
    
//		List<Integer>li=new ArrayList<>(hm);
//		return li;
	}
	
	public static void main(String[] args) {
		int num[]= {3,3,3,3,3,3,3,5,5,5,4,67,65,2,10,9};
		
		System.out.println(ans(num));
		System.out.println(majorityElement(num));
		System.out.println(optimal(num));
	}
}
