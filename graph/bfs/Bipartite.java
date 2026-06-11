import java.util.*;

public class Bipartite {
    public static void main(String[] args) {
        int graph[][] = {
                {1, 3, 2},
                {0, 2},
                {0,1, 3},
                {0, 2}
        };
        Bipartite b = new Bipartite();
        System.out.println(b.isBipartite(graph));
    }
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        for(int i=0;i<visited.length;i++){visited[i]=-1;}
        for(int i=0;i<visited.length;i++){
            if(visited[i]!=-1){
                continue;
            }
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            visited[i]=0;
            while(!q.isEmpty()){
                int src=q.poll();
                for(int neighbour:graph[src]){
                    if(visited[neighbour]==-1){
                        visited[neighbour]=1-visited[src];
                        q.offer(neighbour);
                    }else if(visited[src]==visited[neighbour]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
