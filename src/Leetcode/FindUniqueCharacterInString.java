package Leetcode;

import java.util.HashMap;

public class FindUniqueCharacterInString {
	
	static int ans(String s) {
		HashMap<Character, Integer>hm=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
		}
//		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(hm.get(s.charAt(i))==1) {
				return i;
			}
		}return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans("lleetcode"));
	}

}
