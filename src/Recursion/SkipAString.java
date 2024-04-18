package Recursion;

public class SkipAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="abcdefghccccc";
		String b="cd";
		String ans="";
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!='c') {
				ans+=a.charAt(i);
			}
		}
		System.out.println(ans);
	}
//	public static skipString(String s,String up) {
//		if(s.isEmpty()) {
//			return up;
//		}
//		if(s.startsWith(s)) {
//			s=s.substring(0)
//		}
//	}

}
