package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		List<List<Integer>> li=generate(5);
		System.out.println(li);
	}
	
	static public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans=new ArrayList<>();
		
		List<Integer>li=new ArrayList<>();
		li.add(1);
        ans.add(li);
		
		for(int i=1;i<numRows;i++) {
			List<Integer>temp=new ArrayList<>();
			List<Integer>prev=ans.get(i-1);
			temp.add(1);
			for(int j=1;j<ans.get(i-1).size();j++) {
				temp.add(prev.get(j-1)+prev.get(j));
			}
			temp.add(1);
			ans.add(temp);
		}
		
		return ans;
    }

}
