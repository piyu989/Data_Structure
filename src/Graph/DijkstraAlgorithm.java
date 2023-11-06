package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Graph.AllPathFromsrctoDes.Edge;

public class DijkstraAlgorithm {
	
	static class Edge{
	    int src;
	    int des;
	    int wei;
	    Edge(int src,int des,int wei){
	        this.src=src;
	        this.des=des;
	        this.wei=wei;
	    }
	}
	
	static void createTree(ArrayList<Edge>graph[]){
	    for(int i=0;i<graph.length;i++){
	        graph[i]=new ArrayList<>();
	    }
	
		graph[0].add(new Edge(0, 1,2));
		graph[0].add(new Edge(0, 2,4));
			
		graph[1].add(new Edge(1, 3,7));
		graph[1].add(new Edge(1, 2,1));
	
		graph[2].add(new Edge(2, 4,3));
	
		graph[3].add(new Edge(3, 5,1)); 	
		
		graph[4].add(new Edge(4, 3,2));
		graph[4].add(new Edge(4, 5,5));
	} 
    
    static class Pair implements Comparable<Pair>{
    	int n;
    	int path;
    	public Pair(int n,int path) {
    		this.n=n;
    		this.path=path;
    	}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.path-o.path;
		}
    }
    
    static void dijkstra(ArrayList<Edge>graph[],int src) {
    	int dis[]=new int[graph.length];
    	boolean vis[]=new boolean[graph.length];
    	for(int i=0;i<graph.length;i++) {
    		if(i!=src) {
    			dis[i]=Integer.MAX_VALUE;
    		}
    	}
    	
    	PriorityQueue<Pair>pq=new PriorityQueue<>();
    	pq.add(new Pair(src,0));
    	
    	while(!pq.isEmpty()) {
    		Pair cur=pq.remove();
    		if(!vis[cur.n]) {
    			vis[cur.n]=true;
    			for(int i=0;i<graph[cur.n].size();i++) {
    				Edge e=graph[cur.n].get(i);
    				int u=e.src;
    				int v=e.des;
    				int wt=e.wei;
    				
    				if(dis[u]+wt<dis[v]) {
    					dis[v]=dis[u]+wt;
    					pq.add(new Pair(v,dis[v]));
    				}
    			}
    		}
    	}
    	for(int i:dis) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
    
	
	public static void main(String args[]) {
		ArrayList<Edge>grpah[]=new ArrayList[6];
		createTree(grpah);
		dijkstra(grpah, 0);
	}
}
