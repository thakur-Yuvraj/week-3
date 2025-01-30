//Implement a Queue Using Stacks
//Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
//        Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.



public class ImplementAQueueUsingStacks {
    public static void main(String[] args) {
        // creating que object
        MyQueue que2 = new MyQueue();

        // trying to remove from empty que
        que2.remove();

        // adding element
        que2.add(9);
        que2.add(5);
        que2.add(3);

        // printing the front most val
        System.out.println(que2.peek());
        que2.remove();
        System.out.println(que2.peek());

        // checking if it is empty or not
        if (que2.isEmpty()) {
            System.out.println("Que is empty");

        }else {
            System.out.println("Que is not empty");
        }
    }
}