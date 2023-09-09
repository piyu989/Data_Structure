package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class IterationOnHashSet {
	public static void main(String[] args) {
		HashSet<Integer>hs=new HashSet<>();
		hs.add(87);
		hs.add(9);
		hs.add(23);
		hs.add(1);
		
		Iterator<Integer> i=hs.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}
}
