package Graph;

import java.util.ArrayList;

import Graph.BFSTraversal.Edge;

public class DFSTraversal {
	
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
	
	static void dfs(ArrayList<Edge>graph[],int cur,boolean vis[]) {
		System.out.println(cur);
		vis[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.dest]) {
				dfs(graph, e.dest, vis);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=5;
		ArrayList<Edge>li[]=new ArrayList[v];
		createGraph(li);
		dfs(li, 0, new boolean[v]);
	}

}
