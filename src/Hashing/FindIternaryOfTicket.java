package Hashing;

import java.util.HashMap;

public class FindIternaryOfTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String>hm=new HashMap<>();
		hm.put("Chennai", "Bengalru");
		hm.put("Mumbai", "Delhi");
		hm.put("Goa", "Chennai");
		hm.put("Delhi", "Goa");
		
		System.out.println((ans(hm));
	}
	
	static String ans(HashMap<String,String>hm) {
		HashMap<String, String>rhm=HashMap<String, String>;
		
		for(String s:hm.keySet()) {
			rhm.put(hm.get(s), s);
		}
		
		for(String s:hm) {
			if(!rhm.containsKey(s)) {
				return s;
			}
		}
		return null;
	}

}
