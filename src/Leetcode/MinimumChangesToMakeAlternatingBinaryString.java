package Leetcode;

//https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/submissions/1127630641/?envType=daily-question&envId=2023-12-24

public class MinimumChangesToMakeAlternatingBinaryString {

	static int ans(String s) {
		return Math.min(count(s,s.charAt(0)), count(s,(s.charAt(0)=='0')?'1':'0')+1);
	}
	static int count(String s,char c) {
		int ans=0;
		
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==c) {
				ans++;
				c=(s.charAt(i)=='0')?'1':'0';
			}else {
				c=s.charAt(i);
			}
		}
		return ans;
	}
	
	public static void main(String args[]) {
		 String s="0100";
        // String s="10010100";
        // String s="01010101";
        // String s="110010";
        // String s="10";
//        String s="1111";
        // String s="11101010";
        System.out.println(ans(s));
	}
}
