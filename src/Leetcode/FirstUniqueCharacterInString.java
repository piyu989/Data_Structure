package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		String s="leetcode";
		System.out.println(ans(s));
	}
	static int ans(String s) {
		Map<Character, Integer>mp=new LinkedHashMap<>();
		
		for(char c:s.toCharArray()) {
			mp.put(c, mp.getOrDefault(c, 0)+1);
		}
		
		for(int i=0;i<s.length();i++) {
			if(mp.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
	}

}
