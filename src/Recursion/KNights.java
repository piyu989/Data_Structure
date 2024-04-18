package Recursion;

public class KNights {

	public static void main(String args[]){
        boolean maze[][]=new boolean[4][4];
        // kNight(maze, 0, 0, 3);
        System.out.println(kNight(maze, 0, 0, 1));
    }    

    static int kNight(boolean maze[][],int row,int col,int knight){
        int count=0;
        if(knight==0){
            display(maze);
            System.out.println();
            return 1;
        }
        if(row==maze.length-1&&col==maze.length-1){
            return 0;
        }
        if(col==maze.length){
            count+=kNight(maze, row+1, 0, knight);
            return count;
        }

        if(isSafe(maze,row,col)){
            maze[row][col]=true;
            count+=kNight(maze,row,col+1,knight-1);
            maze[row][col]=false;
        }
        count+=kNight(maze,row,col+1,knight);
        return count;
    }

    static boolean isValid(boolean maze[][],int row,int col){
        if(row>=0&&row<maze.length&&col>=0&&col<maze.length)return true;
        return false;
    }

    static boolean isSafe(boolean maze[][],int row,int col){
        if(isValid(maze,row+2,col+1)&&maze[row+2][col+1])return false;
        if(isValid(maze,row+2,col-1)&&maze[row+2][col-1])return false;
        if(isValid(maze,row-2,col+1)&&maze[row-2][col+1])return false;
        if(isValid(maze,row-2,col-1)&&maze[row-2][col-1])return false;
        if(isValid(maze,row+1,col-2)&&maze[row+1][col-2])return false;
        if(isValid(maze,row+1,col+2)&&maze[row+1][col+2])return false;
        if(isValid(maze,row-1,col+2)&&maze[row-1][col+2])return false;
        if(isValid(maze,row-1,col-2)&&maze[row-1][col-2])return false;

        return true;
    }

    static void display(boolean maze[][]) {
        for(boolean ar[]:maze) {
            for(boolean a:ar) {
                if(a) {
                    System.out.print("K");
                }else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
	
}
