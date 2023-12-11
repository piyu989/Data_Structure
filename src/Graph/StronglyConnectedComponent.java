package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {
	
	static void createGraph(ArrayList<Edge>graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<>();
		}
		graph[0].add(new Edge(0,2));
		graph[0].add(new Edge(0,3));

		graph[1].add(new Edge(1,0));

		graph[2].add(new Edge(2,1));

		graph[3].add(new Edge(3,4));
	}

	static class Edge{
		int src;
		int des;
		Edge(int s,int d){
			this.src=s;
			this.des=d;
		}
	}
	
	static void dfs(ArrayList<Edge>graph[],int cur,boolean vis[]) {
		System.out.print(cur+" ");
		vis[cur]=true;
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.des]) {
				dfs(graph, e.des, vis);
			}
		}
	}
	
	static void topo(ArrayList<Edge>graph[],int cur,boolean vis[],Stack<Integer>st) {
		vis[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			if(!vis[e.des]) {
				topo(graph, e.des, vis, st);
			}
		}
		st.push(cur);
	}
	
	static void kosraju(ArrayList<Edge>graph[]) {
		boolean vis[]=new boolean[graph.length];
		Stack<Integer>st=new Stack<>();
		
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
			topo(graph, i, vis, st);
		}}
		
		ArrayList<Edge>transpose[]=new ArrayList[graph.length];
		
		for(int i=0;i<transpose.length;i++) {
			vis[i]=false;
			transpose[i]=new ArrayList<>();
		}
		
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph[i].size();j++) {
				Edge e=graph[i].get(j);
				transpose[e.des].add(new Edge(e.des,e.src));
			}
		}
		
		while(!st.isEmpty()) {
			int cur=st.pop();
			if(!vis[cur]) {
				System.out.print("GCC ->");
				dfs(transpose, cur, vis);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) {
		ArrayList<Edge>graph[]=new ArrayList[5];
		createGraph(graph);
		kosraju(graph);
	}
}
