package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph.BFSTraversal.Edge;

public class TopologicalSortingBfs {
	
	static class Edge{
        int src;
        int des;
        Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }

    static void createTree(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

			
		graph[1].add(new Edge(2, 3));

		graph[2].add(new Edge(3, 1));

		graph[3].add(new Edge(4, 0)); 	
		graph[4].add(new Edge(4, 1));

		graph[4].add(new Edge(5, 0));
		graph[4].add(new Edge(5, 2));

    } 
    
    static void topSortHelp(ArrayList<Edge>graph[],int indeg[]) {
    	for(int i=0;i<graph.length;i++) {
    		int v=i;
    		for(int j=0;j<graph[v].size();j++) {
    			Edge e=graph[v].get(j);
    			indeg[e.des]++;
    		}
    	}
    }

    static void bfs(ArrayList<Edge> graph[]) {
		Queue<Integer>q=new LinkedList<>();
		q.add(0);
		boolean arr[]=new boolean[graph.length];
		
		while(!q.isEmpty()) {
			int cur=q.remove();
			
			if(!arr[cur]){
				System.out.print(cur+" ");
				arr[cur]=true;
				for(int i=0;i<graph[cur].size();i++) {
					Edge e=graph[cur].get(i);
					q.add(e.des);
				}
			}
		}
	}
    
    static void topSort(ArrayList<Edge>graph[]) {
    	int indeg[]=new int[graph.length];
    	Queue<Integer>q=new LinkedList<>();
    	topSortHelp(graph, indeg);
    	
    	for(int i=0;i<graph.length;i++) {
    		if(indeg[i]==0) {
    			q.add(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int cur=q.remove();
    		System.out.print(cur+" ");
    		for(int i=0;i<graph[cur].size();i++) {
    			Edge e=graph[cur].get(i);
    			indeg[e.des]--;
    			if(indeg[e.des]==0) {
    				q.add(e.des);
    			}
    		}	
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Edge>graph[]=new ArrayList[5];
//		 topSort(graph);
		 bfs(graph);
	}	

}
