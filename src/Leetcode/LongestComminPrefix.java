package Leetcode;

public class LongestComminPrefix {

	static String ans(String[] arr) {
		if(arr.length==0) {
			return "";
		}
		String pre=arr[0];
		for(int i=1;i<arr.length;i++) {
			while(arr[i].indexOf(pre)!=0) {
				pre=pre.substring(0, pre.length()-1);
			}
		}
		return pre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]={"flower","flow","flight"};
		System.out.println(ans(arr));
	}

}
