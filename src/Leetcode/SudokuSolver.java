package Leetcode;

//https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
	public static void main(String args[]) {
		char[][] arr={{'5','3','.','.','7','.','.','.','.'},
		              {'6','.','.','1','9','5','.','.','.'},
		              {'.','9','8','.','.','.','.','6','.'},
		              {'8','.','.','.','6','.','.','.','3'},
		              {'4','.','.','8','.','3','.','.','1'},
		              {'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(arr);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void solveSudoku(char[][] su) {
        int board[][]=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(su[i][j]=='.'){
                    board[i][j]=0;
                }else{
                    board[i][j]=Character.getNumericValue(su[i][j]);
                }
            }
        }
        solve(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                su[i][j] = (char) (board[i][j] + '0');
            }
        }
    }
    static boolean solve(int [][]board){
        int n=board.length;
        int row=-1;
        int col=-1;

        boolean isEmpty=true;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    isEmpty=false;
                    row=i;
                    col=j;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if(isEmpty){
            return true;
        }

        for(int i=1;i<10;i++){
            if(isSafe(board, row, col, i)){
                board[row][col]=i;
                if(solve(board)){
                    // print(board);
                    return true;
                }else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    static boolean isSafe(int sudoku[][],int row,int col,int num){
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[row][i]==num)return false;
        }
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==num)return false;
        }
        int grow=(row/3)*3;
        int gcol=(col/3)*3;

        for(int i=grow;i<grow+3;i++){
            for(int j=gcol;j<gcol+3;j++){
                if(sudoku[i][j]==num)return false;
            }
        }

        return true;

    }
}
