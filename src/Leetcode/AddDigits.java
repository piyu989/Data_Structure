package Leetcode;

import java.util.ArrayList;

//https://leetcode.com/problems/add-digits/
public class AddDigits {

	public static void main(String[] args) {
		int n=38;
		String s=n+"";
		int ans=0;
		
		while(ans<=9) {
			for(int i=0;i<s.length();i++) {
				ans+=Integer.parseInt(s.charAt(i)+"");
			}
		}
		System.out.println(ans);
	}

}
