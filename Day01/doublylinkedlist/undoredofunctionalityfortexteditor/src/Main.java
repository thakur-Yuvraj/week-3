//8. Doubly Linked List: Undo/Redo Functionality for Text Editor
//Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
//Add a new text state at the end of the list every time the user types or performs an action.
//Implement the undo functionality (revert to the previous state).
//Implement the redo functionality (revert back to the next state after undo).
//Display the current state of the text.
//Limit the undo/redo history to a fixed size (e.g., last 10 states).
//Hint:
//Use a doubly linked list where each node represents a state of the text.
//The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
//Keep track of the current state and adjust the next and prev pointers for undo/redo operations.


//Using a doubly linked list where each node represents a state of the text.

import java.util.*;

class TextList{
    // attributes
    private String text;
    private TextList next = null;
    private TextList prev = null;
    static String fixedText = "";
    // counting the undo redo limit
    static int limit = 0;
    boolean undo;

    // constructor
    public TextList() {
        limit++;
    }

    public TextList(String text) {
        this.prev = null;
        this.next = null;
        this.text = text;
        limit++;
    }
    public TextList addAtEnd(TextList newNode) {
        TextList head = this;
        TextList temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        newNode.prev = temp;
        return isLimited(head);

    }
    private static TextList isLimited(TextList head) {
        if (limit < 10) {
            return head;
        }
        limit--;
        fixedText += head.text;
        return head.next;
    }
    public static void doUndo(TextList head) {
        TextList tail = head;
        if (head == null) return;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (tail != null && tail.undo) {
            tail = tail.prev;
        }
        if (tail == null) return;
        tail.undo = true;

    }

    public static void doRedo(TextList head) {
        while (head != null && !(head.undo)) {
            head = head.next;
        }
        if (head == null) return;
        head.undo = false;
    }
    public static void displayAll(TextList head) {
        System.out.print(fixedText);

        while(head != null) {
            System.out.print(head.text + " ");
            head = head.next;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // getting input from the user

        System.out.println("Enter Text");
        String input = sc.next();
        TextList headText = new TextList(input);

        while(!input.equals("exit")) {
            System.out.println("Enter more text or type exit to exit , type undo to undo , type redo to redo");
            if (input.equals("undo")) {
                TextList.doUndo(headText);
            }
            if (input.equals("redo")) {
                TextList.doRedo(headText);
            }
            if (input.equals("print")) {
                TextList.displayAll(headText);
                break;
            }
            else {
                input = sc.next();
                TextList newNode = new TextList(input);
                headText = headText.addAtEnd(newNode);
            }

        }
        sc.close();
    }
}