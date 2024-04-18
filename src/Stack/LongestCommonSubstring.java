package Stack;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(ans("babad"));
	}
	static String ans(String s) {
		int strt=0,end=0;
		
		for(int i=0;i<s.length();i++) {
			int l1=expand(s, i, i);
			int l2=expand(s, i, i+1);
			int l=Math.max(l1, l2);
			if(l>end-strt) {
				strt=i-(l-1)/2;
				end=i+(l/2);
			}
		}
		
		return s.substring(strt,end+1);
	}
	
	static int expand(String s,int strt,int end) {
		while(strt>=0&&end<s.length()&&s.charAt(end)==s.charAt(strt)) {
			strt--;end++;
		}
		return end-strt-1;
	}
//	
//	static String ans(String s) {
//		int strt=0,end=0;
//		
//		for(int i=0;i<s.length();i++) {
//			int l1=expand(s, i, i);
//			int l2=expand(s, i, i+1);
//			int l=Math.max(l1, l2);
//			if(l>end-strt) {
//				strt=i-(l-1)/2;
//				end=i+(l/2);
//			}
//		}
//		
//		return s.substring(strt,end+1);
//	} 
//	
//	static int expand(String s,int strt,int end) {
//		while(strt>=0&&end<s.length()&&s.charAt(strt)==s.charAt(end)) {
//			strt--;
//			end++;
//		}
//		return end-strt-1;
//	}
//	
}
