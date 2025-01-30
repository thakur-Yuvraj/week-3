//Sort a Stack Using Recursion
//Problem: Given a stack, sort its elements in ascending order using recursion.
//Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.
//

import java.util.ListIterator;
import java.util.Stack;

public class Main {
    // print functon to print the updated stack
    public static void print(Stack<Integer> stk) {
        Stack<Integer> tempStk = (Stack<Integer>) stk.clone();

        while(!tempStk.isEmpty()) {
            System.out.print(tempStk.pop() + " ");
        }
        System.out.println();

        // for each loop
        for (Integer item : stk) {
            System.out.print(item + " ");
        }
        System.out.println();

        // list iterator in reverse
        ListIterator <Integer> itr = stk.listIterator(stk.size());
        while(itr.hasPrevious()) {
            System.out.print(itr.previous() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // creating a stack object
        Stack<Integer> stk = new Stack<>();
        // adding some elements to the stack
        stk.add(1);
        stk.add(7);
        stk.add(5);
        stk.add(9);
        stk.add(10);
        stk.add(6);
        stk.add(3);
        stk.add(0);
        // calling the recursion functon
        StackSortByRecursion.stackSort(stk);

        // finally printing the stack
        print(stk);
    }
}