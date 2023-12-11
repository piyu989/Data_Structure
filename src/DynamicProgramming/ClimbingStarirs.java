package DynamicProgramming;

public class ClimbingStarirs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ansForFour(5));
	}
	
	public static int ansForFour(int n) {
		if(n==0||n==1||n==2) {
			return n;
		}
		if(n==3) {
			return 4;
		}
		if(n==4) {
			return 7;
		}
		return ansForFour(n-1)+ansForFour(n-2)+ansForFour(n-3);
	}
	
	public static int ans(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    } 
}
