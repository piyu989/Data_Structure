package HeapORPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {

	static class Pair implements Comparable<Pair>{
		int val;
		int idx;
		
		public Pair(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair p) {
			return p.val-this.val;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,-1,-3,5,5,6,7};
		PriorityQueue<Pair>p=new PriorityQueue<>();
		int k=3;
		int ans[]=new int[arr.length-k+1];
		
		for(int i=0;i<k;i++) {
			p.add(new Pair(arr[i],i));
		}
		ans[0]=p.peek().val;
		
		for(int i=k;i<arr.length;i++) {
			if(p.isEmpty()&&p.peek().idx<=(i-k)) {
				p.remove();
			}
			p.add(new Pair(arr[i],i));
			ans[i-k+1]=p.peek().val;
		}
		
		for(int i:ans) {
			System.out.print(i+" ");
		}
		

	}

}
