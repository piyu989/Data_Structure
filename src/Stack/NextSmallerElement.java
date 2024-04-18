package Stack;

import java.util.Stack;

public class NextSmallerElement {
	public static void main(String args[]) {
		int arr[]= {3,1,5,4,2,1};
		int ans[]=ans(arr);
		for(int i:ans) {
			System.out.print(i+" ");
		}
	}
	static int[] ans(int arr[]) {
		int ans[]=new int[arr.length];
		
		Stack<Integer>st=new Stack<>();
		st.add(-1);
		
		for(int i=arr.length-1;i>=0;i--) {
			int cur=arr[i];
			while(st.peek()>=cur) {
				st.pop();
			}
			ans[i]=st.peek();
			st.add(arr[i]);
		}
		
		return ans;
	}
}
