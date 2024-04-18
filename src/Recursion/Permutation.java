package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String args[]) {
		System.out.println(countPermutation("", "abcdefghij"));
	}
	
	static int countPermutation(String pro,String unpro) {
		if(unpro.isBlank()) {
			System.out.println(pro+" ");
			return 1;
		}
		
		int count=0;
		
		for(int i=0;i<=pro.length();i++) {
			char c=unpro.charAt(0);
			String f=pro.substring(0,i);
			String s=pro.substring(i,pro.length());
			count+=countPermutation(f+c+s, unpro.substring(1));
		}
		return count;
	}
	
	
	static List<String> permutationn(String pro,String unpro){
        List<String>li=new ArrayList<>();
        if(unpro.isEmpty()){
            li.add(pro);
            return li;
        }
        char c=unpro.charAt(0);
        for(int i=0;i<=pro.length();i++){
            String f=pro.substring(0,i);
			String s=pro.substring(i,pro.length());
			li.addAll(permutationn(f+c+s, unpro.substring(1)));
        }
        return li;
    } 

    static void permutation(String pro,String unpro){
        if(unpro.isBlank()) {
			System.out.print(pro+" ");
			return;				
		}				
        				
		char c=unpro.charAt(0);

		for(int i=0;i<= pro.length();i++) {
			String f=pro.substring(0,i);
			String s=pro.substring(i,pro.length());
			permutation(f+c+s, unpro.substring(1));
		}
    }
}
