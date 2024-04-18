package HeapORPriorityQueue;

public class HeapSort {
	
	static void heapfiy(int i,int n,int arr[]) {
		int left=2*i+1;
		int right=2*i+2;
		int max=i;
		
		if(left<n&&arr[left]>arr[max]) {
			max=left;
		}
		if(right<n&&arr[right]>arr[max]) {
			max=right;
		}
		if(max!=i) {
			int temp=arr[max];
			arr[max]=arr[i];
			arr[i]=temp;
			heapfiy(max, n, arr);
		}
	}
	
	static void sort(int arr[]) {
		//max heap
		int n=arr.length;
		for(int i=n/2;i>=0;i--) {
			heapfiy(i,n,arr);
		}
		
		//heapify
		for(int i=n-1;i>=1;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			heapfiy(0,i,arr); 
		}
	}

	public static void main(String[] args) {
		int ar[]= {32,23,1,22,11,0,2};
		sort(ar);
		for(int i:ar) {
			System.out.println(i);
		}
	}

}
