package Graph;

public class DisjointSet {
	
	static int n=7;
	static int[] rnk=new int[n];
	static int[]par=new int[n];
	
	static void init() {
		for(int i=0;i<n;i++) {
			par[i]=i;
		}
	}
	
	static int find(int x) {
		if(x==par[x]) {
			return x;
		}
		return par[x]=find(par[x]);	
	}
	
	static void union(int a,int b) {
		int parA=find(a);
		int parB=find(b);
		
		if(rnk[parA]==rnk[parB]) {
			par[parB]=parA;
			rnk[parA]++;
		}else if(rnk[parA]<rnk[parB]) {
			par[parA]=parB;
		}else {
			par[parB]=parA;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		union(1, 3);
		System.out.println(find(3));
//		union(2, 4);
		union(5, 6);
		union(1, 6);
		union(1	, 5);
		System.out.println(rnk[1]);
		System.out.println(find(3));
		union(1,5);
	}

}
