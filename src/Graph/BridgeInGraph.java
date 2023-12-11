package Graph;

import java.util.ArrayList;

public class BridgeInGraph {
	
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
			graph[i]=new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[0].add(new Edge(0,3));

		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));

		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,1));

		graph[3].add(new Edge(3,0));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));

		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));

		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
	}
	
	static void dfs(ArrayList<Edge>graph[],int cur,int par,int dt[],int low[],boolean vis[],int time) {
		vis[cur]=true;
		dt[cur]=low[cur]=++time;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			int nei=e.des;
			if(nei==par) {
				continue;
			}
			else if(!vis[nei]) {
				dfs(graph, nei, cur, dt, low, vis, time);
				low[cur]=Math.min(low[cur], low[nei]);
				if(dt[cur]<low[nei]) {
					System.out.println("bridge is "+cur+"----"+nei);
				}
			}else {
				low[cur]=Math.min(dt[nei], low[cur]);
			}
		}
	}
	
	static void tarjanAlgo(ArrayList<Edge>[]graph) {
		//it is discovery time
		int dt[]=new int[graph.length];
		//lowest discvoery time of neoghbouring node including current node
		int low[]=new int[graph.length];
		int time=0;
		boolean vis[]=new boolean[graph.length];
		
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				dfs(graph, i, -1, dt, low, vis, time);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Edge>graph[]=new ArrayList[6];
		createGraph(graph);
		tarjanAlgo(graph);
	}

}
