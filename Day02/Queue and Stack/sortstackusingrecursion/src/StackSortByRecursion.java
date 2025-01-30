import java.util.Stack;
public class StackSortByRecursion {

    // helper function to get the element to its correct position
    private static void stackInsert(Integer curVal, Stack <Integer> stk) {
        // base case
        if (stk.isEmpty() || stk.peek() > curVal) {
            stk.push(curVal);
            return;
        }
        // if stk top is smaller
        Integer temp = stk.pop();
        stackInsert(curVal, stk);
        // pushing the popped temp var back to the stack
        stk.push(temp);

    }
    // main sorting functon to sort a stack
    public static void stackSort(Stack<Integer> stk) {
        // base case
        if (stk.isEmpty()) {
            return;
        }
        // removing the topmost element
        int curVal = stk.pop();
        stackSort(stk);
        // inserting the same element back to the stack in sorted order by a helper functon
        stackInsert(curVal, stk);
    }

}
