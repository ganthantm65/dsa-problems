package graph.topological_sort;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class KahnsAlgorithm {

    public static void main(String[] args){
        int V=6;
        int[][] edges={{},{},{3},{1},{0,1},{0,2}};
        List<Integer> result=topologicalSort(V,edges);
        System.out.println(result);
    }
    
    static List<Integer> topologicalSort(int V,int[][] edges){
        int[] inDegree=new int[V];
        List<Integer> result=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int v=0;v<V;v++){
            for(int u:edges[v]){
                inDegree[u]++;
            }
        }

        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int v=queue.poll();
            result.add(v);
            for(int u:edges[v]){
                inDegree[u]--;
                if(inDegree[u]==0){
                    queue.offer(u);
                }
            }
        }
        return result;
    }
}
