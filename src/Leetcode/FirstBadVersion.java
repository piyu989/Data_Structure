package Leetcode;

//https://leetcode.com/problems/first-bad-version/description/
public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class VersionControl{
	public boolean isBadVersion(int n) {
		return true;
	}
}
class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=0;
        int right=n;

        while(left<right){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(left==right && isBadVersion(left)){
            return left;
        }
        return -1;
    }
}
