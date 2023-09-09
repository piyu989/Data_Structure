package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	static	List<List<Integer>> an = new ArrayList<List<Integer>>();
    
	public static List<List<Integer>> combine(int n, int k) {
		List<Integer> ans=new ArrayList<Integer>();
		rec(1,k,n,ans);
		return an;
	}

	public static void rec(int start,int k,int n,List<Integer>cur) {
		if(cur.size()==2) {
			an.add(new ArrayList<>(cur));
			return;
		}else {
			for(int i=start;i<=n;i++) {
				cur.add(i);
				rec(i+1, k, n, cur);
				cur.remove(cur.size()-1);
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> ans=combine(4, 2);
		System.out.println(ans);
//		System.out.println(an);
	}

}
