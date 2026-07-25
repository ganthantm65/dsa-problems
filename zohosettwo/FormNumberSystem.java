package zohosettwo;

import java.util.LinkedList;
import java.util.Queue;

public class FormNumberSystem {
    static int findNthNumber(int n){
        Queue<String> queue=new LinkedList<>();

        queue.add("3");
        queue.add("4");

        String ans="";

        while (n>0) {
            ans=queue.poll();
             
            queue.offer(ans+"3");
            queue.offer(ans+"4");

            n--;
        }
        return Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        System.out.print(findNthNumber(10));
    }
}
