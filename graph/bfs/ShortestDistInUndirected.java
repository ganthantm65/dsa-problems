import java.util.*;

public class ShortestDistInUndirected{
    static class Pair{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    static int[] shortestPath(HashMap<Integer, List<Integer>> graph,int m,int src){
        int[] dist=new int[m];

        for(int i=0;i<m;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        dist[src]=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int d=p.dist;
            for(int neighbour:graph.get(node)){
                if(d+1<dist[neighbour]){
                    dist[neighbour]=d+1;
                    q.add(new Pair(neighbour,d+1));
                }
            }
        }
        return dist;
    }

    public static void main(String args[]){
        HashMap<Integer, List<Integer>> graph=new HashMap<>();
        graph.put(0,Arrays.asList(1,3));
        graph.put(1, Arrays.asList(0,2,3));
        graph.put(2, Arrays.asList(1,6));
        graph.put(3, Arrays.asList(0,1,4));
        graph.put(4, Arrays.asList(3,5));
        graph.put(5, Arrays.asList(4,6));
        graph.put(6, Arrays.asList(2,5,7,8));
        graph.put(7, Arrays.asList(6,8));
        graph.put(8, Arrays.asList(6,7));

        int[] dist=shortestPath(graph,9,0);
        System.out.println(Arrays.toString(dist));
    }
}