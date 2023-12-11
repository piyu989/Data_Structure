package Leetcode;

//https://leetcode.com/problems/find-center-of-star-graph/description/

public class FindCenterOfGraph {
	public int findCenter(int[][] edges) {
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                if(edges[0][i]==edges[1][j]){
                    return edges[0][i];
                }
            }
        }
        return -1;
    }
	public static void main(String args[]) {

	}
}
