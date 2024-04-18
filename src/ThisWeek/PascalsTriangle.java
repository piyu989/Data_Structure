package ThisWeek;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	
	
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> ans=new ArrayList<>();
		
		ans.add(new ArrayList<>());
		ans.get(0).add(1);
		
		for(int i=1;i<numRows;i++) {
			List<Integer>temp=new ArrayList<>();
			List<Integer>prev=ans.get(i-1);
			
			temp.add(1);
			
			for(int j=1;j<i;j++) {
				temp.add(prev.get(j-1)+prev.get(j));
			}
			temp.add(1);
			ans.add(temp);
		}
		return ans;
	}

}
