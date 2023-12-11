package Leetcode;

//https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionInNetwork {
	
	static List<List<Integer>>result=new ArrayList<>();
	static int dt[];
	static int lt[];
	static boolean vis[];
	static int time=0;
	static List<Integer>graph[];
	
	public static List<List<Integer>>ans(List<List<Integer>>connections,int n){
		graph=new ArrayList[n];
		dt=new int[n];
		vis=new boolean[n];
		lt=new int[n];
		
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(List<Integer>l:connections) {
			int i=l.get(0),j=l.get(1);
			graph[i].add(j);
			graph[j].add(i);
		}
		dfs(connections,0,-1);
		return result;
	}
	
	static void dfs(List<List<Integer>>connections,int cur,int par) {
		vis[cur]=true;
		dt[cur]=lt[cur]=++time;
		
		for(int i:graph[cur]) {
			if(i==par) {
				continue;
			}else if(!vis[i]) {
				dfs(connections, i, cur);
				lt[cur]=Math.min(lt[cur], lt[i]);
				if(dt[cur]<lt[i]) {
					result.add(Arrays.asList(cur,i));
				}
			}else {
				lt[cur]=Math.min(lt[cur], dt[cur]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
