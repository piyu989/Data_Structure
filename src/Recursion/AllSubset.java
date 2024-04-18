package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {

	public static void main(String args[]){
//        allSubsequence("", "abc");
		int arr[]={1,2,3};

        List<List<Integer>>hs=new ArrayList<>();

        hs.add(new ArrayList<>());
        for(int i:arr){
            for(int j=0;j<hs.size();j++){
                List<Integer>li=new ArrayList<>(hs.get(j));
                li.add(i);	
                hs.add(li);
            }	
        }
        System.out.println(hs);
    }

    static void allSubsequence(String pro,String unpro) {
		if(unpro.isBlank()) {
			System.out.println(pro);
			return;
		}
		allSubsequence(pro, unpro.substring(1));
		allSubsequence(pro+unpro.charAt(0), unpro.substring(1));
	}

}
