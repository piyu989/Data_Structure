package ThisWeek;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		
	}
	public static int ans(int nums[]) {
		int maxsum=nums[0];
		int cursum=0;
		
		for(int i=0;i<nums.length;i++) {
			cursum+=nums[i];
			maxsum=Math.max(maxsum, cursum);
			if(cursum<0) cursum=0;
		}
		return maxsum;
	}
}
