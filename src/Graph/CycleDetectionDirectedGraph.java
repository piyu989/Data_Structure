package Graph;

import java.util.ArrayList;

import Graph.BipartiteGraph.Edge;

public class CycleDetectionDirectedGraph {

	public static class Edge{
		int src;
		int des;
		Edge(int src,int des){
			this.src=src;
			this.des=des;
		}
	}
	static void createGraph(ArrayList<Edge>graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<>();
		}
//		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
//		graph[1].add(new Edge(1, 3));

//		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 0));
//		graph[3].add(new Edge(3, 4));
		
//		graph[4].add(new Edge(4, 2)); 	
//		graph[4].add(new Edge(4, 3));
	}
	
	static boolean isCycle(ArrayList<Edge>graph[]) {
		boolean vis[]=new boolean[graph.length];
		boolean stack[]=new boolean[graph.length];
			
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				if(isCycleUtil(graph,i,vis,stack)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	static boolean isCycleUtil(ArrayList<Edge>[] graph, int cur, boolean[] vis, boolean[] stack) {
		// TODO Auto-generated method stub
		vis[cur]=true;
		stack[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(stack[e.des]) {
				return true;
			}
			if(!vis[e.des]&&isCycleUtil(graph, e.des, vis, stack)) {
				return true;
			}
		}
		stack[cur]=false;
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Edge>graph[]=new ArrayList[4];
		createGraph(graph);
		System.out.println(isCycle(graph));
	}

}
