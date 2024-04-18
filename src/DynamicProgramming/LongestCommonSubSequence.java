package DynamicProgramming;

public class LongestCommonSubSequence {
	
	static int lcs(String a,String b,int sa,int sb) {
		if(sa==0||sb==0) {
			return 0;
		}
		
		if(a.charAt(sa-1)==b.charAt(sb-1)) {
			return lcs(a, b, sa-1, sb-1)+1;
		}else {
			return Math.max(lcs(a, b, sa-1, sb), lcs(a, b, sa, sb-1));
		}
	}
	
	static int lcs2(String a,String b,int sa,int sb,int dp[][]) {
		if(sa==0||sb==0) {
			return 0;
		}
		if(dp[sa][sb]!=-1) {
			return dp[sa][sb];
		}
		if(a.charAt(sa-1)==b.charAt(sb-1)) {
			return dp[sa][sb]=lcs(a, b, sa-1, sb-1)+1;
		}else {
			return dp[sa][sb]=Math.max(lcs(a, b, sa-1, sb), lcs(a, b, sa, sb-1));
		}
	}
	
	static int lcs3(String a,String b,int sa,int sb) {
		int dp[][]=new int[sa+1][sb+1];
		for(int i=0;i<sa+1;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<sb+1;i++) {
			dp[0][i]=0;
		}
		for(int i=1;i<sa+1;i++) {
			for(int j=1;j<sb+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[sa][sb];
	}

	public static void main(String[] args) {
//		System.out.println(lcs("abcdge", "abedg", 6, 5));
		String a="abcdge";
		String b="aeg";
		int dp[][]=new int[a.length()+1][b.length()+1];

		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
//		System.out.println(lcs2(a, b, a.length(), b.length(), dp));
		System.out.println(lcs3(a, b, a.length(), b.length()));
	}

}
