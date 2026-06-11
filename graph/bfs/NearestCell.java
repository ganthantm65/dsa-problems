import java.util.*;

class CellPair{
    int row;
    int col;
    int dist;
    public CellPair(int row,int col,int dist){
    	this.row=row;
    	this.col=col;
    	this.dist=dist;
    }
}

public class NearestCell{
    public static void main(String[] args){
    	int[][] grid={
    	  {1,0,1},
    	  {1,1,0},
    	  {1,0,0}
    	};
    	int[][] distance=new int[grid.length][grid[0].length];
    	boolean[][] visited=new boolean[grid.length][grid[0].length];
    	Queue<CellPair> q=new LinkedList<>();
    	for(int i=0;i<grid.length;i++){
    	   for(int j=0;j<grid[0].length;j++){
    	      if(grid[i][j]==1){
    	      	  q.offer(new CellPair(i,j,0));
    	      	  visited[i][j]=true;
    	      }
    	   }
    	}
    	bfs(grid,visited,distance,q);
    	for(int i=0;i<grid.length;i++){
    	   for(int j=0;j<grid[0].length;j++){
    	      System.out.print(distance[i][j]+" ");
    	    }
    	    System.out.println();
    	}    	
    }
    static void bfs(int[][] grid,boolean[][] visited,int[][] distance,Queue<CellPair> q){
    	int dist;
    	int[] drow={-1,0,1,0};
    	int[] dcol={0,-1,0,1};
    	while(!q.isEmpty()){
    	   int row=q.peek().row;
    	   int col=q.peek().col;
    	   dist=q.peek().dist;
    	   distance[row][col]=dist;
    	   q.poll();
    	   for(int i=0;i<4;i++){
    	      int cr=row+drow[i];
              int cc=col+dcol[i];
              if(cr<grid.length && cr>=0 && cc<grid[0].length && cc>=0 && !visited[cr][cc]){
           	 q.offer(new CellPair(cr,cc,dist+1));
           	 visited[cr][cc]=true;
              }
    	   }
        }
    }
}
