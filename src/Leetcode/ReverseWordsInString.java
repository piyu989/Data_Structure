package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseWordsInString {

	static String ans(String s) {
		String arr[]=s.split("\s+");
		
		List<String>li=Arrays.asList(arr);
		Collections.reverse(li);
		
		s=String.join(" ", li);
		StringBuilder ans=new StringBuilder("");
		
		int temp=0;
		for(int i=s.length()-1;i>=0&&s.charAt(i)==' ';i--) {
			temp++;
		}
		ans=new StringBuilder(s.substring(0,s.length()-temp));
		
		return ans.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans("heloo   world"));
	}

}
