package com.segmentTree;

//https://web.telegram.org/k/#@hot_muslim_girl_village_gf_bf
//https://web.telegram.org/k/#-2091306972

public class CreatingST {

	static int tree[];
	static void init(int n) {
		tree=new int[4*n];
	}
	static int create(int arr[],int i,int strt,int end) {
		if(strt==end) {
			tree[i]=arr[strt];
			return arr[strt];
		}
		int mid=(end+strt)/2;
		create(arr, i*2+1, strt, mid);
		create(arr, i*2+2, mid+1, end);
		tree[i]=tree[2*i+1]+tree[2*i+2];
		return tree[i];
	}
	
	static int getSumUtil(int i,int si,int sj,int qi,int qj) {
		if(qi>=sj||qj<=si) {
			return 0;
		}
		else if(si>=qi&&sj<=qj) {
			return tree[i];
		}else {
			int mid=(si+sj)/2;
			int l=getSumUtil(2*i+1,si, mid, qi, qj);
			int r=getSumUtil(2*i+2,mid+1, sj, qi, qj);	
			return l+r;
		}
	}
	
	static int getSum(int arr[],int qi,int qj){
		return getSumUtil(0,0,arr.length-1,qi,qj);
	}
	
//	static void update(int arr[],int idx,int newVal) {
//		arr[idx]=newVal;
//		create(arr, 0, 0, arr.length-1);
//	}
	
	static void update(int arr[],int idx,int newVal) {
		int n=arr.length;
		int diff=newVal-arr[idx];
		arr[idx]=newVal;
		
		updateUtil(0,0,n-1,idx,diff);
	}
	static void updateUtil(int i,int si,int sj,int idx,int diff) {
		if(idx>=sj||idx<=si) {
			return;
		}
		tree[i]+=diff;
		if(si!=sj) {
			int mid=(si+sj)/2;
			updateUtil(2*i+1, si, mid, idx, diff);
			updateUtil(2*i+2, mid+1, sj, idx, diff);
		}
	}
	
	
	public static void main(String args[]) {
		int arr[]={1,2,3,4,5,6,7,8};
		int n=arr.length;
		init(n);
		create(arr, 0, 0, n-1);
		
		System.out.println(getSum(arr, 2, arr.length));
		
		update(arr, 2, 2);
		
		System.out.println(getSum(arr, 2, arr.length-1));
		
		
	}
}
