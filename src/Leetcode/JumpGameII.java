package Leetcode;

//https://leetcode.com/problems/jump-game-ii/submissions/1109527718/

public class JumpGameII {
	
	static int ans(int arr[]) {
		int curReach=0;
		int maxReach=0;
		int jump=0;
		
		for(int i=0;i<arr.length-1;i++) {
			maxReach=Math.max(maxReach, arr[i]+i);
			if(i==curReach) {
				jump++;
				if(maxReach>=arr.length-1) {
					break;
				}
				curReach=maxReach;
			}
		}
		return jump;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,1,1,1,1};
		System.out.println(ans(arr));
	}

}
