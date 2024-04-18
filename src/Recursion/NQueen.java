package Recursion;import java.util.Queue;

public class NQueen {
	public static void main(String args[]) {
//		System.out.println("sita ram");
		boolean maze[][]=new boolean[2][2];
		System.out.println(queen(maze, 0));
	}
	public static int queen(boolean[][] maze,int row) {
		if(row==maze.length) {
			print(maze);
			System.out.println();
			return 1;
		}
		
		int count=0;
		
		for(int i=0;i<maze.length;i++) {
			if(isSafe(maze,row,i)) {
				maze[row][i]=true;
				count+=queen(maze, row+1);
				maze[row][i]=false;
			}
		}
		return count;
	}
	static boolean isSafe(boolean maze[][],int row,int col) {
		
		for(int i=row-1;i>=0;i--) {
			if(maze[i][col])return false;
		}
		
		for(int i=row-1,j=col-1;j>=0&&i>=0;j--,i--) {
			if(maze[i][j])return false;
		}
		
		for(int i=row-1,j=col+1;i>=0&&j<maze.length;i--,j++) {
			if(maze[i][j])return false;
		}
		return true;
	}
	
	static void print(boolean maze[][]) {
		for(boolean ar[]:maze) {
			for(boolean a:ar) {
				if(a) {
					System.out.print("Q");
				}else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
}
