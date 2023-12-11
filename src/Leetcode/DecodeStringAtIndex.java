package Leetcode;

//https://leetcode.com/problems/decoded-string-at-index/submissions/1107616969/

public class DecodeStringAtIndex {
	
	public static String ans(String s,int k) {
		long size=0;
		
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))) {
				size=size*Integer.parseInt(""+s.charAt(i));
			}else {
				size++;
			}
		}
		
		for(int i=s.length()-1;i>=0;i--) {
			k%=size;
			if(k==0&&Character.isDigit(s.charAt(i))==false) {
				return s.charAt(i)+"";
			}
			if(Character.isDigit(s.charAt(i))) {
				size=size/Integer.parseInt(""+s.charAt(i));
			}else {
				size--;
			}
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(ans("leet2code3",10));
	}

}
