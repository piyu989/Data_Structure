package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph.TopologicalSortingBfs.Edge;

public class AllPathFromsrctoDes {

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

		graph[0].add(new Edge(0, 3));
			
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));

		graph[4].add(new Edge(4, 0)); 	
		graph[4].add(new Edge(4, 1));

		graph[5].add(new Edge(5, 0));
		graph[5].add(new Edge(5, 2));

    } 
    
    public static void path(ArrayList<Edge> graph[],int src,int des,String path) {
    	if(src==des) {
    		System.out.println(path+des);
    		return;
    	}
    	
    	for(int i=0;i<graph[src].size();i++) {
    		Edge e=graph[src].get(i);
    		path(graph, e.des, des, path+src);
    	}
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Edge>graph[]=new ArrayList[6];
		 createTree(graph);
		 path(graph, 5, 1, "");
	}	

}
