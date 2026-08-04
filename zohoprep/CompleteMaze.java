package zohoprep;

public class CompleteMaze {
    static int[] row={0,1};
    static int[] col={1,0};
    static boolean isReachable(int[][] maze,int sx,int sy,boolean[][] visited,int n,int m){
        if (maze[sx][sy] == 0 || visited[sx][sy]) {
            return false;
        }

        if (sx == n - 1 && sy == m - 1) {
            return true;
        }
        visited[sx][sy] = true;
        for (int i = 0; i < 2; i++) {
            int nx=sx+row[i];
            int ny=sy+col[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (isReachable(maze, nx, ny, visited, n, m)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
    {1,1,0},
    {0,0,1},
    {1,1,1}
};

        System.out.print(isReachable(maze, 0, 0, new boolean[3][3], 3, 3));
    }
}
