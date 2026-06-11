import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        int n=4;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, res, n);
        for(List<String> solved:res){
           System.out.println("Board");
           for(String row:solved){
           	System.out.print(row.toString());
           	System.out.println();
           }
           System.out.println();
        }
    }

    static void solve(int col, char[][] board, List<List<String>> res, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, res, n);
                board[row][col] = '.'; 
            }
        }
    }

    static boolean isValid(int row, int col, char[][] board, int n) {

        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }
        return temp;
    }
}
