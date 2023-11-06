package Graph;

import java.util.ArrayList;
import java.util.Stack;

//import Graph.CycleDetectionDirectedGraph.Edge;

public class TopoligicalSorting {
	
	static class Edge{
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
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));

		graph[4].add(new Edge(4, 0)); 	
		graph[4].add(new Edge(4, 1));

		graph[5].add(new Edge(5, 0));
		graph[5].add(new Edge(5, 2));
	}
	
	static void topolical(ArrayList<Edge>graph[]) {
		boolean vis[]=new boolean[graph.length];
		Stack<Integer>stack=new Stack<>();
		
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				topolicalUtil(graph,i,vis,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	private static void topolicalUtil(ArrayList<Edge>[] graph, int cur, boolean[] vis, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		vis[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.des]) {
				topolicalUtil(graph, e.des, vis, stack);
			}
		}
		stack.push(cur);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge>graph[]=new ArrayList[6];
		createGraph(graph);
		topolical(graph);
//		for(ArrayList<Edge> e:graph) {
			
//		}
	}

}
