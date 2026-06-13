package stackandqueue;

import java.util.Stack;

class Pair{
    int value;
    int minValue;

    public Pair(int value, int minValue){
        this.value = value;
        this.minValue = minValue;
    }
}

class MinStackImplementation { //Time Complexity: O(1) for push, pop, top, and getMin operations Space Complexity: O(2*n) in the worst case when all elements are pushed onto the stack }
    private Stack<Pair> stack;

    public MinStackImplementation(){
        stack = new Stack<>();
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(new Pair(x,x));
        }else{
            int currentMin=stack.peek().minValue;
            int newMin=Math.min(x, currentMin);
            stack.push(new Pair(x, newMin));
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top(){
        if(!stack.isEmpty()){
            return stack.peek().value;
        }
        throw new RuntimeException("Stack is empty");
    }
    
    public int getMin(){
        if(!stack.isEmpty()){
            return stack.peek().minValue;
        }
        return Integer.MAX_VALUE;
    }
}

class AnotherImplementation{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public AnotherImplementation(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            int topValue=stack.pop();
            if(topValue==minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1; // or throw an exception
    }

    public int getMin(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return Integer.MAX_VALUE; // or throw an exception
    }
}

public class MinStack {
    public static void main(String[] args){
        MinStackImplementation minStack = new MinStackImplementation();
        minStack.push(12);
        minStack.push(15);
        minStack.push(10);
        System.out.println(minStack.getMin()); // Returns 10
        minStack.pop();
        System.out.println(minStack.top());    // Returns 15
        System.out.println(minStack.getMin()); // Returns 12

        AnotherImplementation anotherMinStack = new AnotherImplementation();
        anotherMinStack.push(12);
        anotherMinStack.push(15);
        anotherMinStack.push(10);
        System.out.println(anotherMinStack.getMin()); // Returns 10
        anotherMinStack.pop();
        System.out.println(anotherMinStack.top());    // Returns 15
        System.out.println(anotherMinStack.getMin()); // Returns 12
    }
}
