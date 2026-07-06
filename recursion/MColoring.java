package recursion;

import java.util.HashMap;
import java.util.List;

public class MColoring {
    public boolean colorGrpah(int n,int m,HashMap<Integer,List<Integer>> graph){
        int[] color=new int[n];

        return backtrack(0, n, m, graph, color);
        
    }
    public boolean backtrack(int node,int n,int m,HashMap<Integer,List<Integer>> graph,int[] color){
        if(node==n){
            return true;
        }

        for(int i=1;i<=m;i++){
            if(isSafe(node,color,graph,i)){
                color[node]=i;
                if(backtrack(node+1, n, m, graph, color)){
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }
    public boolean isSafe(int node,int color[],HashMap<Integer,List<Integer>> graph,int c){
        List<Integer> adj=graph.get(node);
        for(int i=0;i<adj.size();i++){
            if(color[adj.get(i)]==c){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        MColoring mColoring=new MColoring();
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        graph.put(0, List.of(1,2));
        graph.put(1, List.of(0,2));
        graph.put(2, List.of(0,1));
        System.out.println(mColoring.colorGrpah(3, 3, graph));
    }
}
