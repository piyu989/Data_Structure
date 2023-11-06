package Graph;

import java.util.PriorityQueue;

public class ConnectingCityWithMinimumCost {

	static class Edge implements Comparable<Edge> {
        int des;
        int cost;
        public Edge(int des,int cost) {
        	this.cost=cost;
        	this.des=des;
        }
        @Override
        public int compareTo(Edge e) {
        	return this.cost-e.cost;
        }
	}
	
	static int connectingCities(int cities[][]) {
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		boolean vis[]=new boolean[cities.length];
		
		pq.add(new Edge(0,0));
		int ans=0;
		while(!pq.isEmpty()) {
			Edge e=pq.remove();
			if(!vis[e.des]) {
				vis[e.des]=true;
				ans+=e.des;
				for(int i=0;i<cities[e.des].length;i++) {
					if(cities[e.des][i]!=0) {
						pq.add(new Edge(i,cities[e.des][i]));
					}
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int cities[][]= {{0,1,2,3,4},
						  {1,0,5,0,7},
						  {2,5,0,6,0},
						  {3,0,6,0,0},
						  {4,7,0,0,0}};
		System.out.println(connectingCities(cities));
	}

}
