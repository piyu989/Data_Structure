package Recursion;

public class RotatedBinarySearch {
	
	static int search(int arr[],int trgt,int i,int j) {
		if(i>j)return -1;
		int mid=(i+j)/2;
		if(arr[mid]==trgt) {
			return mid;
		}
		if(arr[i]<=arr[mid]) {
			if(arr[i]<=trgt&&arr[mid]>=trgt) {
				return search(arr,trgt,i,mid-1);
			}else {
				return search(arr,trgt,mid+1,j);
			}
		}
		
		if(arr[mid]<=trgt&&trgt<=arr[j])return search(arr, trgt, mid+1, j);
		else return search(arr, trgt, i, mid-1);
	}
	
	public static void main(String args[]) {
		int arr[]= {7,2,3};
		System.out.println(search(arr, 7, 0, arr.length-1));
	}
}
