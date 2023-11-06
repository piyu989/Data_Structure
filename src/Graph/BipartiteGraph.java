package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
	
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
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
//		graph[3].add(new Edge(3, 4));
		
		graph[4].add(new Edge(4, 2));	
//		graph[4].add(new Edge(4, 3));
	}
	
	static boolean isBipartite(ArrayList<Edge>graph[]) {
		int col[]=new int[graph.length];
		for(int i=0;i<graph.length;i++) {
			col[i]=-1;
		}
		
		Queue<Integer>q=new LinkedList<>();
		
		for(int i=0;i<graph.length;i++) {
			if(col[i]==-1) {
				q.add(i);
				col[i]=0;
				
				while(!q.isEmpty()) {
					int cur=q.remove();
					for(int j=0;j<graph[cur].size();j++) {
						Edge e=graph[cur].get(j);
						if(col[e.des]==-1) {
							col[e.des]=col[cur]==0?1:0;
							q.add(col[e.des]);
						}else if(col[e.des]==col[cur]) {
							return false;
						}
					}
				}
			}
		}
		return true;
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
	
	static void bfs(ArrayList<Edge>graph[]) {
		Queue<Integer>q=new LinkedList<>();
		q.add(0);
		boolean vis[]=new boolean[graph.length];
		
		while(!q.isEmpty()) {
			int cur=q.remove();
			
			if(!vis[cur]) {
				System.out.print(cur+" ");
				vis[cur]=true;
				for(int i=0;i<graph[cur].size();i++) {
					Edge e=graph[cur].get(i);
					q.add(e.des);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Edge>graph[]=new ArrayList[5];
		createGraph(graph);
//		bfs(graph);
		System.out.println(isBipartite(graph));
//		dfs(graph, 0, new boolean[5]);
	}

}
