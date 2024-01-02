package Leetcode;

//https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/

public class LargestCommonSubstringBetweenTwoCharacter {

	static int ans(String s) {
		for(int i=s.length()-1;i>0;i--) {
			for(int j=0;j+i<s.length();j++) {
				if(s.charAt(j)==s.charAt(i+j))return i-1;
			}
		}
		return -1;
	}
	
	static int sol(String s) {
		int ans=-1;
		int max=-1;
		String temp=s.substring(0,s.length());
		
		char c=s.charAt(0);
		
		for(int i=0;i<s.length();i++) {
			ans=0;
			temp=s.substring(i+1,s.length());
			if(temp.contains(c+"")) {
				ans++;
			}
			c=s.charAt(i);
			if(ans!=0) max=Math.max(max, ans);
			ans=-1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
