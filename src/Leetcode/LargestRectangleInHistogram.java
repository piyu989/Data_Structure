package Leetcode;

//https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	static int ans(int arr[]) {
		if(arr.length==1) {
			return arr[0];
		}
		int ans=arr[0];
		int cur=0;
		int width=1;
		
		for(int i=0;i<arr.length;i++) {
			int temp=i;
			
			while(temp>=0&&arr[temp]>=arr[i]) {
				if(i==temp)temp--;
				else {
					temp--;
					width++;
				}	
			}
			temp=i;
			while(temp<arr.length&&arr[temp]>=arr[i]) {
				if(i==temp)temp++;
				else {
					temp++;
					width++;
				}
			}
			cur=arr[i]*width;
			ans=Math.max(ans, cur);
			width=1;
		}
		return ans;
	}
	
	static int[]prev(int arr[]){
		int ans[]=new int[arr.length];
		
		Stack<Integer>st=new Stack<>();
		st.add(-1);
		
		for(int i=0;i<arr.length;i++) {
			int cur=arr[i];
			while(st.peek()!=-1 && arr[st.peek()]>=cur) {
				st.pop();
			}
			ans[i]=	st.peek();
			st.add(i);
		}
		
		return ans;
	}
	static int[]next(int arr[]){
		int ans[]=new int[arr.length];
		
		Stack<Integer>st=new Stack<>();
		st.add(-1);
		
		for(int i=arr.length-1;i>=0;i++) {
			int cur=arr[i];
			while(st.peek()!=-1 && arr[st.peek()]>=cur) {
				st.pop();
			}
			ans[i]=	st.peek();
			st.add(i);
		}
		
		return ans;
	}
	
	static int largestArea(int arr[]) {
		int ans=Integer.MIN_VALUE;
		
		int prev[]=prev(arr);
		int next[]=next(arr);
		
		for(int i=0;i<arr.length;i++) {
			int l=arr[i];
			if(next[i]==-1) {
				next[i]=arr.length;
			}
			int b=prev[i]-next[i]-1;
			int temp=l*b;
			ans=Math.max(temp, ans);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int arr[]= {2,4};
		System.out.println(ans(arr));
	}

}
