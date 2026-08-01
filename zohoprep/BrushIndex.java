package zohoprep;

public class BrushIndex {
    static int x_dir[]={-1,1,0,0};
    static int y_dir[]={0,0,-1,1};
    static void brushPixels(int[][] grid,int x,int y,int newColor,int oldColor){
        if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]==newColor || grid[x][y]!=oldColor){
            return;
        }
        grid[x][y]=newColor;
        for(int i=0;i<4;i++){
            brushPixels(grid,x+x_dir[i],y+y_dir[i],newColor,oldColor);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
		        {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x=4,y=4;
        int newColor=3;
        int oldColor=grid[x][y];
        brushPixels(grid,x,y,newColor,oldColor);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
