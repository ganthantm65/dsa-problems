package stackandqueue;
import java.util.Stack;

class Queue {
    private Stack<Integer> stack;

    public Queue(){
        stack = new Stack<>();
    }

    public void enqueue(int x){
        stack.push(x);
    }

    public int dequeue(){
        if(stack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        int front = tempStack.pop();
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return front;
    }

    public int peek(){
        if(stack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        int front = tempStack.peek();
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return front;
    }
}

public class QueueUsingStack {
    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.peek()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek()); // Output: 2
    }
}
