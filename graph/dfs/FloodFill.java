
public class FloodFill{
   static int[] dR={-1,1,0,0};
   static int[] dC={0,0,-1,1};
   public static void main(String[] args){
   	int start[]={1,1};
   	int grid[][]={
          {1,1,1},
          {1,1,0},
          {1,0,1}
   	};
	dfs(start,grid,2);
	for(int i=0;i<grid.length;i++){
	   for(int j=0;j<grid[0].length;j++){
	   	System.out.print(grid[i][j]+" ");
	   }
	   System.out.println();
	}
   }
   static void dfs(int[] start,int[][] grid,int color){
   	int row=start[0];
   	int col=start[1];
   	if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]==2 || grid[row][col]==0){
   	    return;
   	}
   	grid[row][col]=color;
   	for(int i=0;i<4;i++){
   	   int[] cell={row+dR[i],col+dC[i]};
   	   dfs(cell,grid,color);
   	}
   }
}
