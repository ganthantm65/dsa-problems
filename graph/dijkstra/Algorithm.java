package graph.dijkstra;

import java.util.*;

public class Algorithm {
    static class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }

    static int[] dijsktra(int n,int src,Map<Integer,List<Pair>> graph,Queue<Pair> pg){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pg.add(new Pair( src,0));
        while(!pg.isEmpty()){
            int node=pg.peek().node;
            int weight=pg.peek().weight;
            pg.remove();
            for(Pair p:graph.get(node)){
                if(dist[node]+p.weight<dist[p.node]){
                    dist[p.node]=dist[node]+p.weight;
                    pg.add(new Pair(p.node,dist[p.node]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args){
        Map<Integer,List<Pair>> graph=new HashMap<>();
        graph.put(0, List.of(new Pair(1,4),new Pair(2,1)));
        graph.put(1, List.of(new Pair(3,1)));
        graph.put(2, List.of(new Pair(1,2),new Pair(3,5)));
        graph.put(3, new ArrayList<>());
        Queue<Pair> pg=new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] dist=dijsktra(4, 0, graph, pg);
        System.out.println(Arrays.toString(dist));
    }
}
