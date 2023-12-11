package DynamicProgramming;

public class FibonaccuNumber {
	
	static int fibTabulation(int n) {
		int fb[]=new int[n+1];
		fb[0]=0;
		fb[1]=1;
		
		for(int i=2;i<=n;i++) {
			fb[i]=fb[i-1]+fb[i-2];
		}
		return fb[n];
	}
	
	public static void main(String args[]) {
//		int[]n= {1,2,3};
		System.out.println(fib(999,new int[9999999]));
		System.out.println(fibTabulation(999));
//		System.out.println(fib(0,new int[100]));
//		System.out.println(fib(1,new int[100]));
//		System.out.println(fib(2,new int[100]));
//		System.out.println(fib(3,new int[100]));
//		System.out.println(fib(4,new int[100]));
//		System.out.println(fib(5,new int[100]));
	}
	static int fib(int n,int[]f) {
		if(n==0||n==1) {
			return n;
		}
		if(f[n]!=0) {
			return f[n];
		}
			f[n]=fib(n-1,f)+fib(n-2,f);
			return f[n];
	}
}
