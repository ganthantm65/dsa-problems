import java.util.*;

public class TopologicalSort {
    public static void main(String[] args){
        int graph[][]={
                {1,2},
                {3},
                {3},
                {}
        };

        int[] visited=new int[graph.length];
        TopologicalSort t=new TopologicalSort();
        System.out.println(t.topologicalSort(graph,visited));
    }
    public List<Integer> topologicalSort(int[][] graph,int[] visited){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(i,graph,visited,stack);
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    public void dfs(int src,int[][] graph,int[] visited,Stack<Integer> stack){
        visited[src]=1;
        for(int neighbour:graph[src]){
            if(visited[neighbour]==0){
                dfs(neighbour,graph,visited,stack);
            }
        }
        stack.push(src);
    }
}
