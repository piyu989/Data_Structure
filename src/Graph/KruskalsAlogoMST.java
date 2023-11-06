package Graph;

import java.util.ArrayList;
import java.util.Collections;

//import java.util.ArrayList;
//import java.util.Collections;
public class KruskalsAlogoMST {

	static class Edge implements Comparable<Edge> {
		int src;
		int des;
		int wei;
		public Edge(int s,int d,int w) {
			this.des=d;
			this.src=s;
			this.wei=w;
		}
		@Override
		public int compareTo(Edge e) {
			return this.wei-e.wei;
		}
	}
	
	static int size=4;
	static int rnk[]=new int[size];
	static int parent[]=new int[size];
	
	public static void init() {
		for(int i=0;i<size;i++) {
			parent[i]=i;
			rnk[i]=0;
		}
	}
	
	public static int find(int n) {
		if(n==parent[n]) {
			return n;
		}
		return parent[n]=find(n);
	}
	
	static void union(int a,int b) {
		int parA=find(a);
		int parB=find(b);
		
		if(rnk[parA]==rnk[parB]) {
			parent[parB]=parA;
			rnk[parA]++;
		}
		else if(rnk[parA]<rnk[parB]) {
			parent[parA]=parB;
		}else {
			parent[parB]=parA;
		}
	}
	
	static void createGraph(ArrayList<Edge>graph) {
		graph.add(new Edge(0,1,10));
		graph.add(new Edge(0,2,15));
		graph.add(new Edge(0,3,30));
		graph.add(new Edge(1,3,40));
		graph.add(new Edge(2,3,50));
	}
	
	static int ans(ArrayList<Edge> graph) {
		Collections.sort(graph);
		int count=0;
		int ans=0;
		
		for(Edge e:graph) {
			if(count<size-1) {
				int parA=e.src;
				int parB=e.des;
				if(parA!=parB) {
					union(parA, parB);
					count++;
					ans+=e.wei;
				}
			}
		}
		return ans;
	}

    public static void main(String[] args) {
        ArrayList<Edge>graph=new ArrayList<>();
    	init();
        createGraph(graph);
        System.out.println(ans(graph));
    }
}