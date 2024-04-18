package ThisWeek;

//https://leetcode.com/problems/string-to-integer-atoi/description/

public class StringToInteger_Atoi {
	public static void main(String args[]) {
		System.out.println(ans("             -45"));
	}

	public static int ans(String s) {
		if(s.isEmpty()||s.length()==0)return 0;
		
		s=s.trim();
		
		if(s.isBlank())return 0;
		
		int i=0;
		int sign=1;
		
		if(s.charAt(0)=='-') {
			sign=-1;
			i++;
		}else if(s.charAt(0)=='+') {
			sign=1;
			i++;
		}
		
		long result=0;
		
		while(i<s.length()&&Character.isDigit(s.charAt(i))) {
			result=result*10+(s.charAt(i)-'0');
			if(sign==-1&&-result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
			if(sign==1&&result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
			i++;
		}
		return (int)result*sign;
	}
	
}
