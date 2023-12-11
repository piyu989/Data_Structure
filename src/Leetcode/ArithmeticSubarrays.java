package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
	
	static List<Boolean> ans(int num[],int l[],int r[]){
		List<Boolean>a=new ArrayList<>();
		
		for(int i=0;i<l.length;i++) {
			int temp[]=Arrays.copyOfRange(num, l[i], r[i]+1);
			a.add(isArthemitic(temp));
		}
		
		return a;
	}
	static boolean isArthemitic(int temp[]) {
		if(temp.length<=2)return true;
		
		Arrays.sort(temp);
		int dif=temp[1]-temp[0];
		
		for(int i=2;i<temp.length;i++) {
			if(temp[i]-temp[i-1]!=dif)return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={4,6,5,9,3,7};
        int l[]={0,0,2};
        int r[]={2,3,5};
        List<Boolean>ans=ans(arr, l, r);

        System.out.println(ans);
	}

}
