package Leetcode;

import java.util.*;

//https://leetcode.com/problems/valid-anagram/description/?envType=daily-question&envId=2023-12-16

public class ValidAnagram {
	static boolean sol(String s,String t){
		s=s.toLowerCase();
		t=t.toLowerCase();

		char sr[]=s.toCharArray();
		char tr[]=t.toCharArray();

		Arrays.sort(sr);
		Arrays.sort(tr);

		return Arrays.equals(sr, tr);
	}

	static boolean ans(String s,String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		HashMap<Character,Integer>hm=new HashMap<>();
		HashMap<Character,Integer>ht=new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
		}
		
		for(int i=0;i<t.length();i++) {
			ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0)+1);
		}
		System.out.println(ht);
		System.out.println(hm);
		for(int i=0;i<s.length();i++) {
			char tt=s.charAt(i);
			int c=0;
			int cc=0;
            if(hm.get(tt)!=null){
				c+=hm.get(tt);
                // continue;
            }
			if(ht.get(tt)!=null){
				cc+=ht.get(tt);
                // continue;
            }
            if(c!=cc) {
                return false;
			}
		}
		
		return true;
	}

	static boolean optimize(String s,String t){
		if(s.length()!=t.length()){
			return false;
		}
		Map<Character,Integer>hm=new HashMap<>();
		for(char c:s.toCharArray()) hm.put(c, hm.getOrDefault(c, 0)+1);

		for(char c:t.toCharArray()){
			if(hm.get(c)==null)return false;
			int count=hm.get(c);
			if(count==0){
				return false;
			}
			hm.put(c, count-1);
		}
		return true;

	}

	public static void main(String args[]) {
		System.out.println(ans("nagaram", "anagram"));
	}
}
