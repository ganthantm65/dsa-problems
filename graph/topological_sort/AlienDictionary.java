package graph.topological_sort;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();

        String[] words = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad"
        };

        Map<Character, List<Character>> graph = ad.convertGraph(words);

        // Build indegree map
        Map<Character, Integer> indegree = new HashMap<>();

        // Add all characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Calculate indegrees
        for (char node : graph.keySet()) {
            for (char neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        List<Character> order = ad.topoSort(graph, indegree);

        System.out.println("\nAlien Dictionary Order:");
        for (char ch : order) {
            System.out.print(ch + " ");
        }
    }

    public Map<Character,List<Character>> convertGraph(String[] dictionary){
        Map<Character,List<Character>> graph=new HashMap<>();
        for(int i=0;i<dictionary.length-1;i++){
            int j=0;
            while (j<dictionary[i].length() && 
            j<dictionary[i+1].length() &&
            dictionary[i].charAt(j) == dictionary[i + 1].charAt(j)
            ) {
                j++;
            }
            if(j!=dictionary[i].length() && 
            j!= dictionary[i+1].length() && 
            dictionary[i].charAt(j) != dictionary[i + 1].charAt(j)){
                char from = dictionary[i].charAt(j);
                char to = dictionary[i + 1].charAt(j);

                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from).add(to);
            }
        }
        return graph;
    }

    public List<Character> topoSort(Map<Character,List<Character>> graph,Map<Character,Integer> indegree){
        List<Character> lst=new ArrayList<>();
        Queue<Character> q=new LinkedList<>();
        for (Map.Entry<Character,Integer> entry:indegree.entrySet()) {
            if(entry.getValue()==0){
                q.add(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            Character c=q.poll();
            lst.add(c);

            for (Character character : graph.getOrDefault(c, new ArrayList<>())) {
                indegree.put(character, indegree.get(character)-1);
                if (indegree.get(character)==0) {
                    q.offer(character);
                }
            }
        }
        return lst;
    }
}
