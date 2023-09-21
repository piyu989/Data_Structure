package Graph;

import java.util.ArrayList;

public class CreaatingGraph {
	
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
		public int getSrc() {
			return src;
		}
		public void setSrc(int src) {
			this.src = src;
		}
		public int getDest() {
			return dest;
		}
		public void setDest(int dest) {
			this.dest = dest;
		}
		public int getWght() {
			return wght;
		}
		public void setWght(int wght) {
			this.wght = wght;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=5;
		ArrayList<Edge>graph[]=new ArrayList[v];
		
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
		
		for(int i=0;i<graph[2].size();i++) {
			Edge e=graph[2].get(i);
			System.out.println(e.dest);
		}
		
	}

}
