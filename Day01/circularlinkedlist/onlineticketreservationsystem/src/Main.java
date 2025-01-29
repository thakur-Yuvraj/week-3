// 9. Circular Linked List: Online Ticket Reservation System
// Problem Statement: Design an online ticket reservation system using a circular linked list, where each node represents a booked ticket. Each node will store the following information: Ticket ID, Customer Name, Movie Name, Seat Number, and Booking Time. Implement the following functionalities:
// Add a new ticket reservation at the end of the circular list.
// Remove a ticket by Ticket ID.
// Display the current tickets in the list.
// Search for a ticket by Customer Name or Movie Name.
// Calculate the total number of booked tickets.

// Hint:
// Use a circular linked list to represent the ticket reservations, with the last node’s next pointer pointing to the first node.
// When removing a ticket, update the circular pointers accordingly.
// For displaying all tickets, traverse the list starting from the first node, looping back after reaching the last node.

class Ticket {

    // attributes
    private int ticketID;
    private String customerName;
    private String movieName;
    private int seatNumber;
    private String bookingTime;
    private Ticket next;
    public static int ticketCount = 0;

    // constructor
    public Ticket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = this;
        ticketCount++;
    }

    // constructor default
    public Ticket() {
        ticketCount++;
    };

    // printing the tickets
    public static void displayAllTicket(Ticket head) {
        // maintaining the head and using temp to treverse the circular list
        Ticket temp = head;
        do{
            System.out.println("The ticket id is : "+ temp.ticketID + " name of the customer is : "+ temp.customerName+ " booking time is : "+ temp.bookingTime + " seat number is : "+ temp.seatNumber);
            temp = temp.next;
        }while (temp != head);
    }

    // adding new ticket
    public void addTicketAtEnd(Ticket t1) {
        // this reefers to the head
        Ticket temp = this;
        while(temp.next != this) {
            temp = temp.next;
        }
        // adding new node at the end
        temp.next = t1;
        t1.next = this;
    }
    public static void displayOne(Ticket temp) {
        System.out.println("The ticket id is : "+ temp.ticketID + " name of the customer is : "+ temp.customerName+ " booking time is : "+ temp.bookingTime);
    }

    // removing a ticket by ticket id return head
    public static Ticket removeById(Ticket head, int id) {
        // temp for treversal
        Ticket temp = head;
        if (head.next == head) {
            if (head.ticketID == id) {
                head = null;
            }else {
                System.out.println("Ticket Not found");
            }
            ticketCount--;
            return head;
        }
        if (head.ticketID == id) {
            // to delete the head we need to change the tail
            return deleteHead(head);
        }
        do{
            if (temp.next.ticketID == id) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }while(temp != head);
        ticketCount--;
        return head;
    }

    // deleting the first node
    private static Ticket deleteHead(Ticket head){
        Ticket temp = head;

        while(temp.next != head) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        head = temp.next;
        ticketCount--;
        return head;
    }

    // Search for a ticket by Customer Name or Movie Name.
    public void searchByCustomerName(String name) {
        // maintaining the head and using temp to treverse the circular list
        Ticket temp = this;
        Ticket head = this;
        do{
            // using string method
            if (temp.customerName.equals(name)){
                System.out.println("The ticket id is : "+ temp.ticketID + " name of the customer is : "+ temp.customerName+ " booking time is : "+ temp.bookingTime);
                return;
            }
            temp = temp.next;
        }while (temp != head);
        System.out.println("customer not found");
        return;
    }
    // Search for a ticket by Customer Name or Movie Name.
    public void searchByCustomerMovie(String name) {
        // maintaining the head and using temp to treverse the circular list
        Ticket temp = this;
        Ticket head = this;
        do{
            // using string method
            if (temp.movieName.equals(name)){
                System.out.println("The ticket id is : "+ temp.ticketID + " name of the customer is : "+ temp.customerName+ " booking time is : "+ temp.bookingTime);
                return;
            }
            temp = temp.next;
        }while (temp != head);
        System.out.println("customer not found");
        return;
    }

}

public class Main {
    public static void main(String[] args) {
        // generating the head of the circular linked list
        Ticket ticketHead = new Ticket(1, "customerName1", "movieName1", 1, "01/01/2025");

        // adding more ticket to the head ticket
        ticketHead.addTicketAtEnd(new Ticket(2, "customerName2", "movieName2", 2, "01/01/2025"));
        ticketHead.addTicketAtEnd(new Ticket(3, "customerName3", "movieName3", 3, "01/01/2025"));
        ticketHead.addTicketAtEnd(new Ticket(4, "customerName4", "movieName4", 4, "01/01/2025"));

        // printing the total ticket
        Ticket.displayAllTicket(ticketHead);

        System.out.println("Deleting node by id = 1");
        // deleting a ticket by id returns new head
        ticketHead = Ticket.removeById(ticketHead, 1);

        // again printing the total ticket
        System.out.println("printing updated list");
        Ticket.displayAllTicket(ticketHead);

        // counting the number of ticket
        System.out.println("The number of tickets are : "+ Ticket.ticketCount);

        // finding the ticket by customer name
        ticketHead.searchByCustomerName("customerName4");

        // finding the ticket by customer Movie name
        ticketHead.searchByCustomerMovie("MovieName1");

    }
}