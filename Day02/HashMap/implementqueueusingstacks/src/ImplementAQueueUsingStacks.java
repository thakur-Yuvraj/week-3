//Implement a Queue Using Stacks
//Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
//        Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.


import java.util.*;

public class ImplementAQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue stk = new MyQueue();
        var i = stk.hashCode();
        Queue<Integer> que1 = new LinkedList<>() ;
        que1.add(9);
        que1.add(6);
        que1.peek();
        que1.remove();
    }
}