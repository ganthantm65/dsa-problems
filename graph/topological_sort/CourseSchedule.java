package graph.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int v=queue.poll();
            count++;
            for(int u:graph.get(v)){
                inDegree[u]--;
                if(inDegree[u]==0){
                    queue.offer(u);
                }
            }
        }
        return count==numCourses;
    }

    public static void main(String[] args){
        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule c=new CourseSchedule();
        System.out.println(c.canFinish(numCourses,prerequisites));
    }
}
