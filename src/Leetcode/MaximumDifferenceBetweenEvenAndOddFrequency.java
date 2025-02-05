package Leetcode;

import java.util.HashMap;

public class MaximumDifferenceBetweenEvenAndOddFrequency {
	public static void main(String args[]) {
		String s="abcabcab";

		int oddSum = Integer.MIN_VALUE;
        int evenSum = Integer.MAX_VALUE;
        HashMap<Character, Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++) {
        	hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(int freq:hm.values()) {
        	if(freq%2==0) {
        		evenSum = Math.min(freq, evenSum);
        	}else {
        		oddSum = Math.max(oddSum, freq);
        	}
        }
//        if(evenSum==Integer.MIN_VALUE || oddSum==Integer.MIN_VALUE) return -1;
        System.out.println(oddSum-evenSum);
        
	}
}
