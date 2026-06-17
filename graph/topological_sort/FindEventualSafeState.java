package graph.topological_sort;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeState{

    public static void main(String[] args){
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        List<List<Integer>> revGraph=new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            revGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < revGraph.size(); u++) {
            for (int v : graph[u]) {
                revGraph.get(v).add(u);
            }
        }

        int[] inDegree=new int[revGraph.size()];

        for (int u = 0; u < revGraph.size(); u++) {
            for (int v : revGraph.get(u)) {
                inDegree[v]++;
            }
        }

        List<Integer> result=topologicalSort(revGraph,inDegree);
        System.out.println(result);
    }

    static List<Integer> topologicalSort(List<List<Integer>> graph,int[] indegree) {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int i:graph.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}