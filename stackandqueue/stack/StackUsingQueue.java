package stack;

import java.util.Queue;
import java.util.LinkedList;

class Stack{
    private Queue<Integer> queue;
    
    public Stack(){
        queue=new LinkedList<>();
    }

    public void push(int x){
        queue.offer(x);
        for(int i=0;i<queue.size()-1;i++){
            queue.offer(queue.poll());
        }
    }

    public int pop(){
        return queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}

public class StackUsingQueue{
    public static void main(String[] args){
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}