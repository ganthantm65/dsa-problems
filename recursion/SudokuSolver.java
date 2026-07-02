package recursion;

import java.util.*;

public class SudokuSolver{
   public static void main(String[] args){
    char[][] board = {
	    {'5','3','.','.','7','.','.','.','.'},
	    {'6','.','.','1','9','5','.','.','.'},
	    {'.','9','8','.','.','.','.','6','.'},
	    {'8','.','.','.','6','.','.','.','3'},
	    {'4','.','.','8','.','3','.','.','1'},
	    {'7','.','.','.','2','.','.','.','6'},
	    {'.','6','.','.','.','.','2','8','.'},
	    {'.','.','.','4','1','9','.','.','5'},
	    {'.','.','.','.','8','.','.','7','9'}
	};
    solve(board);
    for(int i=0;i<9;i++){
    	for(int j=0;j<9;j++){
    	   System.out.print(board[i][j]+" ");
    	}
    	System.out.println();
    }
   }
   static boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int r=1;r<=9;r++){
                        if(isValid(board,i,j,(char)(r+'0'))){
                            board[i][j]=(char)(r+'0');
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(char[][] board,int row,int col,char c){
        
        for(int i=0;i<9;i++){
            if(board[i][col]==c){
                return false;
            }
            if(board[row][i]==c){
                return false;
            }
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==c){
                return false;
            }
        }
        return true;
    }
}
