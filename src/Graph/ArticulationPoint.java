package Graph;

import java.util.ArrayList;
import Graph.BridgeInGraph.Edge;

public class ArticulationPoint {

	static class Edge{
		int src;
		int des;
		Edge(int s,int d){
			this.src=s;
			this.des=d;
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

		graph[4].add(new Edge(4,3));
	}
	
	static void dfs(ArrayList<Edge>graph[],int cur,int par,int dt[],int lt[],boolean vis[],boolean ap[],int time) {
		vis[cur]=true;
		dt[cur]=lt[cur]=++time;
		int child=0;
		
		for(int i=0;i<graph[cur].size();i++) {
			Edge e=graph[cur].get(i);
			int nei=e.des;
			if(par==nei) {
				continue;
			}else if(!vis[nei]) {
				dfs(graph, nei, cur, dt, lt, vis, ap, time);
				lt[cur]=Math.min(lt[cur], lt[nei]);
				if(par!=-1&&dt[cur]<=lt[nei]) {
					ap[cur]=true;
				}
				child++;
			}else {
				lt[cur]=Math.min(lt[cur], dt[nei]);
			}
		}
		if(par==-1&&child>1) {
			ap[cur]=true;
		}
		
	}
	
	static void ans(ArrayList<Edge>graph[]) {
		int dt[]=new int[graph.length];
		int lt[]=new int[graph.length];
		boolean vis[]=new boolean[graph.length];
		boolean ap[]=new boolean[graph.length];
//		boolean ap[]=new boolean[graph.length];
//		int child=0;
		int time=0;
		
		for(int i=0;i<graph.length;i++) {
			if(!vis[i]) {
				dfs(graph, i, -1, dt, lt, vis, ap, i);
			}
		}
		for(int i=0;i<graph.length;i++) {
			if(ap[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge>graph[]=new ArrayList[5];
		createGraph(graph);
		ans(graph);

	}

}
