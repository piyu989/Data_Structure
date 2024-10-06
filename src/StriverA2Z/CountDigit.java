package StriverA2Z;

//https://www.geeksforgeeks.org/problems/count-digits5716/1

public class CountDigit {

	public static void main(String[] args) {
		System.out.println(ans(10059));
	}

	static int ans(int N) {
		int ans=0;
		int temp=N;
		
		while(temp>=10) {
			int x=temp%10;
			if(x==0) {
				temp/=10;
				continue;
			}
			if(N%x==0||temp==1)ans++;
			temp/=10;
		}
		if(N%temp==0 ||temp==1)ans++;

		return ans;
	}
}
