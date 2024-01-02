package Recursion;

public class CountZero {

	static int count1(int n) {
		return help1(n,0);
	}
	static int help1(int n,int count) {
		if(n<=9) {
			return count;
		}
		if(n%10==0)return help1(n/10,count+1);
		else return help1(n/10, count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count1(9009));
	}	

}
