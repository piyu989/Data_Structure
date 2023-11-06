package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//import Graph.BFSTraversal.Edge;

public class ConnectedGraph {
	
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
	
	static void dfs(ArrayList<Edge> graph[]) {
		boolean[]vis=new boolean[graph.length];	
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				dfsUtil(graph, vis, i);
			}
		}
	}
	
	static void dfsUtil(ArrayList<Edge>graph[],boolean[]vis,int cur) {
		System.out.print(vis[cur]);
		vis[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.dest]) {
				dfsUtil(graph, vis, e.dest);
			}
		}
	}
	
	static void bfs(ArrayList<Edge>graph[]) {
		boolean[]vis=new boolean[graph.length];	
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				bfsUtil(graph, vis);
			}
		}
	}
	
	static void bfsUtil(ArrayList<Edge>graph[],boolean vis[]) {
		Queue<Integer>q=new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int cur=q.remove();
			
			if(!vis[cur]) {
				System.out.print(cur);
				vis[cur]=true;
				for(int i=0;i<graph[cur].size();i++) {
					Edge e=graph[cur].get(i);
					q.add(e.dest);
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Edge> graph[]=new ArrayList[5];
		createGraph(graph);
//		System.out.println(bfs(graph));
	}

}
