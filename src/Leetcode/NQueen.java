package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(8);
		System.out.println(ans);
	}
	static List<List<String>>ans=new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        boolean maze[][]=new boolean[n][n];

        help(maze,0);
        return ans;
    }
    static void help(boolean maze[][],int row){
        if(row==maze.length){
            addInMaze(maze);
            return;
        }
        for(int i=0;i<maze.length;i++){
            if(isSafe(maze,row,i)){
                maze[row][i]=true;
                help(maze,row+1);
                maze[row][i]=false;
            }
        }
    }
    static boolean isSafe(boolean maze[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(maze[i][col])return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(maze[i][j])return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<maze.length;i--,j++){
            if(maze[i][j])return false;
        }
        return true;
    }
    static void addInMaze(boolean maze[][]){
        List<String>li=new ArrayList<>();
        String t="";
        for(boolean ar[]:maze){
            for(boolean ele:ar){
                if(ele){
                    t+="Q";
                }else{
                    t+=".";
                }
            }
            li.add(t);
            t="";
        }
        ans.add(li);
    }

}
