package Leetcode;

public class KadaniAlgorithm {
	public static void main(String args[]) {
		
	}

	static int ans(int nums[]) {
		if(nums.length==1)return nums[0];
        int ans=nums[0];
        int max=0;

        for(int i:nums){
            max+=i;
            ans=Math.max(max,ans);
            if(max<0)max=0;
        }
        return ans;
	}
	
}
