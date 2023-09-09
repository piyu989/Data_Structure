package HeapORPriorityQueue;

import java.util.PriorityQueue;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer>q=new PriorityQueue<>();
		q.add(3);
		q.add(1);
		q.add(0);
		q.add(34);
		q.add(32);
		

		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
	}

}
