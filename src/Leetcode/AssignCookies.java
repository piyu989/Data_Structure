package Leetcode;

//https://leetcode.com/problems/assign-cookies/description/

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		int g[]={1,2,3};
        int s[]={1,1};   
        
        System.out.println(ans(g,s));
	}
	
	static int ans(int g[],int s[]) {
		int i=0,j=0,ans=0;
		
		Arrays.sort(s);
		Arrays.sort(g);
		
		while(i<g.length&&j<s.length) {
			if(g[i]<=s[j]) {
				ans++;i++;j++;
			}else {
				j++;
			}
		}
		return ans;
		
	}

}
