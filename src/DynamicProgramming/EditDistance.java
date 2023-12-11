package DynamicProgramming;

public class EditDistance {

	public static int editDistance(String a,String b) {
		int dp[][]=new int[a.length()+1][b.length()+1];
		
		for(int i=0;i<a.length()+1;i++) {
			for(int j=0;j<b.length()+1;j++) {
				if(i==0) {
					dp[i][j]=j;
				}else if(j==0) {
					dp[i][j]=i;
				}
			}
		}
		
		for(int i=1;i<a.length()+1;i++) {
			for(int j=1;j<b.length()+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					int add=dp[i][j-1]+1;
					int del=dp[i-1][j]+1;
					int rep=dp[i-1][j-1]+1;
					dp[i][j]=Math.min(add, Math.min(del, rep));
				}
			}
		}
		return dp[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistance("intention", "execution"));
	}

}
