package HeapORPriorityQueue;

import java.util.PriorityQueue;

public class WeakestSoldier {
	
	static class Row implements Comparable<Row>{
		int data;
		int idx;
		Row(int data,int idx){
			this.data=data;
			this.idx=idx;
		}
		@Override
		public int compareTo(Row r) {
			if(r.data==this.data) {
				return this.idx-r.idx;
			}else {
				return this.data-r.data;	
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
		PriorityQueue<Row>q=new PriorityQueue<>();
		int k=2;
		
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=0;j<arr[0].length;j++) {
				count+=arr[i][j]==1 ? 1:0;
			}
			q.add(new Row(count,i));
		}
		
		for(int i=0;i<k;i++) {
			Row temp=q.remove();
			System.out.println(temp.idx);
		}
	}

}
