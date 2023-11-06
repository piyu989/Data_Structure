package Leetcode;
//https://leetcode.com/problems/find-the-town-judge/description/

public class FindJudgeOfTheTown {
	
	static int ans(int n,int t[][]) {
		int count[]=new int[n+1];

        for(int i=0;i<t.length;i++){
            count[t[i][0]]--;
            count[t[i][1]]++;
        }
        for(int i=1;i<n;i++){
            if(count[i]==n-1) return i;
        }
        return -1;
	}
		
	public static void main(String args[]) {
		int t[][]= {{1,2}};
		System.out.println(ans(2, t));
	}
}
