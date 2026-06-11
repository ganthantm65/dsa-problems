import java.util.*;

public class NumberOfIslands{
   static int[] dRow={-1,-1,-1,0,0,1,1,1};
   static int[] dCol={-1,0,1,-1,1,-1,0,1};
   public static void main(String args[]){
   	int[][] grid={
   	{0,1,1,0},
   	{0,1,1,0},
   	{0,0,1,0},
   	{0,0,0,0},
   	{1,1,0,1}
   	};
   	int count=0;
   	boolean[][] visited=new boolean[grid.length][grid[0].length];
   	for(int i=0;i<grid.length;i++){
   	    for(int j=0;j<grid[0].length;j++){
   	        if(grid[i][j]==1 && !visited[i][j]){
   	       	    Queue<List<Integer>> q=new LinkedList<>();
   	       	    List<Integer> list=new ArrayList<>();
   	       	    list.add(i);
   	       	    list.add(j);
   	       	    q.add(list);
   	       	    bfs(grid,q,visited);
   	       	    count++;
   	       	}
   	    }
   	}
   	
   	System.out.println("Number of count:"+count);
   }
   static void bfs(int[][] grid,Queue<List<Integer>> queue,boolean[][] visited){
   	while(!queue.isEmpty()){
	   	List<Integer> cell=queue.poll();
	   	int row=cell.get(0);
	   	int col=cell.get(1);
	   	if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || visited[row][col] || grid[row][col]==0){
	   	    continue;
	   	}
	   	visited[row][col] = true;
	   	for(int i=0;i<8;i++){
	   	   int dr=row+dRow[i];
	   	   int dc=col+dCol[i];
	   	   List<Integer> dcell=new ArrayList<>();
	   	   dcell.add(dr);
	   	   dcell.add(dc);
	   	   queue.add(dcell);
	   	}
   	}
   }
}
   	
   	 
