package HeapORPriorityQueue;

import java.util.PriorityQueue;

public class NearbyCars {

	static class Points implements Comparable<Points>{
		int x;
		int y;
		int dist;
		public Points(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Points p) {
			return this.dist-p.dist;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{3,3},{5,-1},{-2,4}};
		int k=2;
		PriorityQueue<Points>p=new PriorityQueue<>();
		
		for(int i=0;i<arr.length;i++) {
			int dist=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
			p.add(new Points(arr[i][0], arr[i][1], dist));
		}
		for(int i=0;i<k;i++) {
			Points temp=p.remove();
			System.out.println(temp.x+" "+temp.y);
		}

	}

}
