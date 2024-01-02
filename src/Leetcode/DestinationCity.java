package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/destination-city/description/?envType=daily-question&envId=2023-12-15

public class DestinationCity {

	static String ans(List<List<String>>path) {
		HashSet<String>ans=new HashSet<>();
		
		for(List<String>p:path)ans.add(p.get(1));
		for(List<String>p:path)ans.remove(p.get(0));
		
		return ans.iterator().next();
	}
	
	static String sol(List<List<String>>path) {
		HashMap<String, String>hm=new HashMap<>();
		
		for(List<String>i:path)hm.put(i.get(0), i.get(1));
		
		String ans=path.get(0).get(0);
		
		while(hm.containsKey(ans)) {
			ans=hm.get(ans);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> cityConnections = new ArrayList<>();

        // Adding city connections
        List<String> connection1 = new ArrayList<>();
        connection1.add("London");
        connection1.add("New York");
        cityConnections.add(connection1);

        List<String> connection2 = new ArrayList<>();
        connection2.add("New York");
        connection2.add("Lima");
        cityConnections.add(connection2);

        List<String> connection3 = new ArrayList<>();
        connection3.add("Lima");
        connection3.add("Sao Paulo");
        cityConnections.add(connection3);
        
        System.out.println(sol(cityConnections));
	}

}
