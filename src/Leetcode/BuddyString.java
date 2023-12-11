package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/buddy-strings/description/?envType=daily-question&envId=2023-11-14

public class BuddyString {
	
	static boolean ans(String s,String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		if(s.equals(t)) {
			HashSet<Character>hs=new HashSet<>();
			for(char c:s.toCharArray()) {
				hs.add(c);
				if(hs.size()<s.length()) {
					return true;
				}else {
					return false;
				}
			}
		}
		List<Integer>li=new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=t.charAt(i)) {
				li.add(i);
			}
		}
		
		if(li.size()==2&&s.charAt(li.get(0))==t.charAt(li.get(1))&&s.charAt(li.get(1))==t.charAt(li.get(0))) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans("abba", "caba"));
	}

}
