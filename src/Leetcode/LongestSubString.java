package Leetcode;

//https://leetcode.com/problems/longest-palindromic-substring/description/

public class LongestSubString {

	static String ans(String s) {
		int strt=0;
		int end=0;
		
		for(int i=0;i<s.length();i++) {
			int l1=expand(s, i, i);
			int l2=expand(s, i, i+1);
			int l=Math.max(l1, l2);
			if(l>end-strt) {
				strt=i-(l-1)/2;
				end=i+l/2;
			}
		}
		return s.substring(strt, end+1);
	}
	
	static int expand(String s,int strt,int end) {
		while(strt>=0&&end<s.length()&&s.charAt(strt)==s.charAt(end)){
			strt--;
			end++;
		}
		return end-strt-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="babad";
		System.out.println(ans(s));
	}
}
