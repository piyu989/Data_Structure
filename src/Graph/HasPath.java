package Graph;

import java.util.ArrayList;

import Graph.DFSTraversal.Edge;

public class HasPath {
	
	
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
		
		graph[1].add(new Edge(1,0,5));
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,3));

		graph[2].add(new Edge(2,1,1));
		graph[2].add(new Edge(2,3,1));
		graph[2].add(new Edge(2,4,4));

		graph[3].add(new Edge(3,1,3));
		graph[3].add(new Edge(3,2,1));

		graph[4].add(new Edge(4,2,2));
	}
	
	static boolean hasPath(ArrayList<Edge>graph[],boolean[]vis,int cur,int trgt) {
		if(cur==trgt) {
			return true;
		}
		vis[cur]=true;
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.dest]&&hasPath(graph, vis, e.dest, trgt)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> graph[]=new ArrayList[5];
		createGraph(graph);
		System.out.println(hasPath(graph, new boolean[graph.length], 0, 4  ));
	}

}
