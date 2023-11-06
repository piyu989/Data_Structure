package Graph;

import java.util.ArrayList;

import Graph.DFSTraversal.Edge;

public class ReturnCycleInUnDirectedGraph {

	static class Edge{
		int src;
		int dest;
		int wght;
		public Edge(int src, int dest, int wght) {
			super();
			this.src = src;
			this.dest = dest;
			this.wght = wght;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<>();
		}
		
		graph[0].add(new Edge(0,1,5));
		graph[0].add(new Edge(0,3,5));
		
//		graph[1].add(new Edge(1,9,5));
		graph[1].add(new Edge(1,0,1));
		graph[1].add(new Edge(1,2,1));
//		graph[1].add(new Edge(1,9,3));

//		graph[2].add(new Edge(2,9,1));
		graph[2].add(new Edge(2,1,1));
//		graph[2].add(new Edge(2,0,1));
//		graph[2].add(new Edge(2,9,4));

//		graph[3].add(new Edge(3,5,3));
		graph[3].add(new Edge(3,4,1));
		graph[3].add(new Edge(3,0,1));

		graph[4].add(new Edge(4,3,2));
	}
	
	static boolean detectCycle(ArrayList<Edge>graph[]) {
		boolean vis[]=new boolean[graph.length];
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				if(detectCucleUtil(graph, vis, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean detectCucleUtil(ArrayList<Edge>graph[],boolean vis[],int cur,int par) {
		vis[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.dest]) {
				if(detectCucleUtil(graph, vis, e.dest, cur)) {
					return true;
				}
//				return true;
			}else if(vis[e.dest]&&e.dest!=par) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Edge>li[]=new ArrayList[5];
		createGraph(li);
		System.out.println(detectCycle(li));
	}

}
