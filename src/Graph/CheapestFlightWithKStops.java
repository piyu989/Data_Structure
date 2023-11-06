package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph.DijkstraAlgorithm.Edge;

public class CheapestFlightWithKStops {
	
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
	
	    static class Info{
	    	int v;
	    	int cost;
	    	int stops;
			public Info(int v, int costs, int stops) {
				super();
				this.v = v;
				this.cost = costs;
				this.stops = stops;
			}
	    }
	    
	    static void createGraph(int flights[][],ArrayList<Edge>graph[]) {
	    	for(int i=0;i<graph.length;i++) {
	    		graph[i]=new ArrayList<>();
	    	}
	    	
	    	for(int i=0;i<flights.length;i++) {
	    		int src=flights[i][0];
	    		int des=flights[i][1];
	    		int wei=flights[i][2];
	    		
	    		Edge e=new Edge(src,des,wei);
	    		graph[src].add(e);
	    	}
	    }
	    
	    static int cheapestFlight(int n,int flight[][],int src,int des,int k) {
	    	ArrayList<Edge>graph[]=new ArrayList[n];
	    	createGraph(flight,graph);
	    	
	    	int dis[]=new int[n];
	    	
	    	for(int i=0;i<n;i++) {
	    		if(i!=src) {
	    			dis[i]=Integer.MAX_VALUE;
	    		}
	    	}
	    	
	    	Queue<Info>q=new LinkedList<>();
	    	q.add(new Info(src,0,0));
	    	
	    	while(!q.isEmpty()) {
	    		Info cur=q.remove();
	    		
	    		if(k<cur.stops) {
	    			break;
	    		}
	    		
	    		for(int i=0;i<graph[cur.v].size();i++) {
	    			Edge e=graph[cur.v].get(i);
	//    			int u=e.src;
	    			int wei=e.wei;
	    			int v=e.des;
	    			
	    			if(cur.cost+wei<dis[v]&&cur.stops<=k) {
	    				dis[v]=cur.cost+wei;
	    				q.add(new Info(v,dis[v],cur.stops+1));
	    			}
	    		}
	    	}
	    	if(dis[des]==Integer.MAX_VALUE) {
	    		return -1;
	    	}else {
	    		return dis[des];	
	    	}
	    	
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int flights[][]= {{0,1,100},{1,2,100},{1,3,600},{2,0,100},{2,3,200}};
		int src=0,dst=3,k=1;
		
//		ArrayList<Edge>graph[]=new ArrayList[4];
		System.out.println(cheapestFlight(n, flights, src, dst, k));
	}

}
