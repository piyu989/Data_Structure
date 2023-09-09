package HeapORPriorityQueue;

import java.util.PriorityQueue;

public class ConnectNRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,3,3,4,6};
		
		PriorityQueue<Integer> p=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			p.add(arr[i]);
		}
		int ans=0;
		while(p.size()!=1) {
			int m1=p.remove();
			int m2=p.remove();
			ans+=m1+m2;
			p.add(m1+m2);
		}
		System.out.println(ans);
	}

}
