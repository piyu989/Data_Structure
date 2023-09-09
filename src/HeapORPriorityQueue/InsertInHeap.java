package HeapORPriorityQueue;

import java.util.ArrayList;

public class InsertInHeap {
	
	static class MinHeap{
		private ArrayList<Integer>li=new ArrayList<>();
		
		private void heapify(int i) {
			int left=2*i+1;
			int right=2*i+2;
			int min=i;
			
			if(left<li.size()&&li.get(min)>li.get(left)) {
				min=left;
			}
			if(right<li.size()&&li.get(min)>li.get(right)) {
				min=right;
			}
			
			if(min!=i) {
				int temp=li.get(i);
				li.set(i, li.get(min));
				li.set(min, temp);
				
				heapify(min);
			}
		}
		
		public int remove() {
			int data=li.get(li.size()-1);
			
			//swap first with last
			li.set(li.size()-1,li.get(0));
			li.set(0,data);
			
			//delete last node
			li.remove(li.size()-1);
			
			heapify(0);
			
			return data;
			
		}
		
		public boolean isEmpty() {
			return li.isEmpty();
		}
		
		public int peek() {
			return li.get(0);
		}
		
		public void add(int val) {
			li.add(val);
			
			int childIdx=li.size()-1;	//childIdx
			int parentIdx=(childIdx-1)/2;	//parentIdx
			
			while(li.get(parentIdx)>li.get(childIdx)) {
				int temp=li.get(parentIdx);
				li.set(parentIdx, li.get(childIdx));
				li.set(childIdx, temp);
				childIdx=parentIdx;
				parentIdx=(childIdx-1)/2;	//parentIdx
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap heap=new MinHeap();
		heap.add(5);
		heap.add(10);
		heap.add(6);
		heap.add(4);
		heap.add(3);
//		while(!heap.isEmpty()) {
//			System.out.println(heap.peek());
//			heap.remove();
//		}
//		System.out.println(heap.peek());
		System.out.println(heap.remove());
	}

}
