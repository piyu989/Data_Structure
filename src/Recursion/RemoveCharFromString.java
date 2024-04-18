package Recursion;

public class RemoveCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="piyushpadsadfwosiufhosjdnv";
//		System.out.println(s.substring(1));
//		System.out.println(ans("piyush","",'i'));
		System.out.println(skipString(s, "piyush"));
	}
	
	static String skipString(String s,String skip) {
		if(s.isEmpty()||s.isBlank()) {
			return "";
		}
		if(s.startsWith(skip)) {
			return skipString(s.substring(skip.length()), skip);
		}else {
			return s.charAt(0)+skipString(s.substring(1), skip);
		}
	}
	
	static String ans(String s,String ans,char c) {
		if(s.isBlank()||s.isEmpty()) {
			return ans;
		}
		if(s.charAt(0)!=c) {
			ans+=s.charAt(0);
			return ans(s.substring(1), ans, c);
		}else {
			return ans(s.substring(1), ans, c);
		}
	}

}
