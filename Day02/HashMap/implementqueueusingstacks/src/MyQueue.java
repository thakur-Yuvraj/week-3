import java.util.Stack;

// using stack to implement que
class MyQueue {
    // making two stk object
    Stack<Object> stk1 = new Stack<>();
    Stack<Object> stk2 = new Stack<>();


    // method to add variables
    public void add(Object val) {
        stk1.add(val);
    }

    // to get front most element
    public Object peek() {
        while(stk1.size() != 1) {
            Object cur = stk1.peek();
            stk2.add(cur);
            stk1.pop();
        }
        Object top = stk1.peek();
        while(!stk2.isEmpty()) {
            Object cur = stk2.peek();
            stk1.add(cur);
            stk2.pop();
        }
        return top;
    }

    // removing the front element
    public void remove() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return;
        }
        while(stk1.size() != 1) {
            Object cur = stk1.peek();
            stk2.add(cur);
            stk1.pop();
        }
        stk1.pop();
        while(!stk2.isEmpty()) {
            Object cur = stk2.peek();
            stk1.add(cur);
            stk2.pop();
        }
    }

    // function to return size of que
    public int size() {
        return stk1.size();
    }

    // function to check if que is empty or not
    public boolean isEmpty() {
        return stk1.isEmpty();
    }

}
