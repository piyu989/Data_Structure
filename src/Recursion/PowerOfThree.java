package Recursion;

// https://leetcode.com/problems/power-of-three/
public class PowerOfThree {
	public static  boolean isPowerOfThree(int n) {
		int k=1162261467;
    	return n>0&&k%3==0;
	}
    public static boolean isPowerOfThre(int n) {
        if(n==2||n<=0||n==2147483647){
                    return false;
                }
                if(n==1){
                    return true;
                }
                return help(n,3,1);
    }
    public static boolean help(int n,int x,int pow){
        if(x==n){
            return true;
        }
        if(x>n){
            return false;
        }
        return help(n,(int)Math.pow(3,pow),pow+1);
    }
	public static void main(String args[]) {
		System.out.println(isPowerOfThree(9));
	}
}
