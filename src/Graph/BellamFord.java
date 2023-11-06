package Graph;

import java.util.ArrayList;

//import Graph.DijkstraAlgorithm.Edge;

public class BellamFord {
	
	static class Edge{
        int src;
        int des;
        int wei;
        Edge(int src,int des,int wei){
            this.src=src;
            this.des=des;
            this.wei=wei;
        }
    }
	
	static void createTree(ArrayList<Edge>graph){
		graph.add(new Edge(0, 1,2));
		graph.add(new Edge(0, 2,4));
			
		graph.add(new Edge(1, 2,-4));

		graph.add(new Edge(2, 3,2));

		graph.add(new Edge(3, 4,4)); 	
		
		graph.add(new Edge(4, 1,-1));
    } 
	
	static void ans(ArrayList<Edge>graph,int src,int V) {
		int dis[]=new int[V];
		
		for(int i=0;i<dis.length;i++) {
			if(i!=src) {
				dis[i]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=0;i<V-1;i++) {
			for(int j=0;j<graph.size();j++) {
				Edge e=graph.get(j);
				int u=e.src;
				int v=e.des;
				int wt=e.wei;
				if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]) {
					dis[v]=dis[u]+wt;
				}
			}
		}
		for(int i:dis) {
			System.out.print(i+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge>li=new ArrayList<>();
		createTree(li);
		ans(li, 0,5);
	}

}
