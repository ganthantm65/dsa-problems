public class NumberofProvinces{
    static int[] dRow = {-1, 1, 0, 0}; 
    static int[] dCol = {0, 0, -1, 1}; 
    public static void main(String[] args){
    	int[][] provinces={
    	   {1,1,0},
    	   {1,1,0},
    	   {0,0,1}
    	};
    	int count=0;
    	int[][] visited=new int[provinces.length][provinces[0].length];
    	for(int i=0;i<provinces.length;i++){
    	   for(int j=0;j<provinces[0].length;j++){
    	   	if(provinces[i][j] == 1 && visited[i][j] != 1) {
		    dfs(provinces, i, j, visited);
		    count++;
		}
    	   }
    	}
    	System.out.println("Number of provinces:"+count);
    }
    static void dfs(int[][] grid,int srow,int scol,int[][] visited){
    	if (srow < 0 || srow >= grid.length || 
        scol < 0 || scol >= grid[0].length || 
        visited[srow][scol] == 1 || 
        grid[srow][scol] == 0) {
	    return;
	}
    	visited[srow][scol]=1;
    	for(int i=0;i<4;i++){
    	    dfs(grid,srow+dRow[i],scol+dCol[i],visited);
    	}
    }
}
