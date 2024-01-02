package Leetcode;

//https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2023-12-22

public class MaximumScoreAfterSplittingAString {
	
	static int getZero(String s) {
		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				ans++;
			}
		}
		return ans;
	}
	
	static int getOne(String s) {
		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				ans++;
			}
		}
		return ans;
	}
	
	static int ans(String s) {
		int max=Integer.MIN_VALUE;
		for(int i=1;i<s.length();i++) {
			int le=getZero(s.substring(0,i));
			int rig=getOne(s.substring(i, s.length()));
			max=Math.max(max, rig+le);
		}
		return max;
	}
	
	static int sol(String s) {
		int max=0;
		int le=0;
		int rig=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				rig++;
			}
		}
		
		for(int i=0;i<s.length()-1;i++) {
			if (s.charAt(i) == '0') le++;
            else rig--;
            max = Math.max(max, le+ rig);
		}
		
		return max;
	}
	
	static int optimal(String s) {
		int temp=s.charAt(0)=='0'?1:0;
		int ans=temp;
		int one=0;
		
		for(int i=1;i<s.length()-1;i++) {
			if(s.charAt(i)=='0')temp++;
			else {temp--;one++;}
			ans=Math.max(ans, temp);
		}
		
		one+=s.charAt(s.length()-1)=='1'?1:0;
		return ans+one;
	}
	
	public static void main(String args[]) {
//		String s="0111101";
		String s="011101";
//		String s="00111";
//		String s="1111";
		
		System.out.println(ans(s));
		System.out.println(sol(s));
		System.out.println(optimal(s));
	}
}
	