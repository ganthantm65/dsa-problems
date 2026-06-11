import java.util.*;

class Pair{
   int row;
   int col;
   int tm;
   public Pair(int row,int col,int tm){
   	this.row=row;
   	this.col=col;
   	this.tm=tm;
   }
}

public class RottenOranges{
   public static void main(String[] args){
   	Queue<Pair> q=new LinkedList<>();
   	int[][] grid={
   	{2,1,1},
   	{1,1,0},
   	{0,1,1}
   	};
   	int[][] visited=new int[grid.length][grid[0].length];
   	int cntfresh=0;
   	for(int i=0;i<grid.length;i++){
   	   for(int j=0;j<grid.length;j++){
   	   	if(grid[i][j]==2){
   	   	   q.offer(new Pair(i,j,0));
   	   	}else if(grid[i][j]==1){
   	           cntfresh++;
   	        }else{
   	           continue;
   	        }
   	   }
   	}
   	System.out.println("Time Taken: "+bfs(q,grid,cntfresh,visited));
   }
   static int bfs(Queue<Pair> q,int[][] grid,int cntfresh,int[][] visited){
      int time=0;
      int dr[]={-1,0,1,0};
      int dc[]={0,-1,0,1};
      int count=0;
      while(!q.isEmpty()){
      	int row=q.peek().row;
        int col=q.peek().col;
        int t=q.peek().tm;
        time=Math.max(t,time);
        q.poll();
        for(int i=0;i<4;i++){
           int cr=row+dr[i];
           int cc=col+dc[i];
           if(cr<grid.length && cr>=0 && cc<grid[0].length && cc>=0 && visited[cr][cc]==0 && grid[cr][cc]==1){
           	q.offer(new Pair(cr,cc,t+1));
           	visited[cr][cc]=2;
           	count++;
           }
        }
     }
     if(count==cntfresh){
     	return time;
     }
     return -1;
   }
}
