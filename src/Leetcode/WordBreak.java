package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	static boolean ans(String s, List<String> wordDict) {
		
	}
	
	static void h(String s,List<String> word,List<String>li,int i,String temp) {
		if(i==s.length()) {
			return;
		}
		if
		char c=s.charAt(i);
		h(s.substring(1), word, li, i, temp+c);
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        List<String>li=new ArrayList<>();
        help(s,"",li);
        int temp=0;
//        System.out.println(li+"\n");
        for(int i=0;i<wordDict.size();i++){
            if(li.contains(wordDict.get(i))){
                temp++;
//                return true;
            }
            if(temp==wordDict.size()){
                return true;
            }
        }
        return false;
    }
    public static void help(String pro,String unpro,List<String> li){
        if(pro.isEmpty()){
            li.add(unpro);
            return;
        }
        char c=pro.charAt(0);
        help(pro.substring(1),unpro+c,li);
        help(pro.substring(1),unpro,li);
    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>li=new ArrayList<>();
//		li.add("and");
//		li.add("sand");
//		li.add("dog");
//		li.add("leet");
		li.add("b");
		System.out.println(ans("a", li));
	}

}
