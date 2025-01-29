package circularlinkedlist.roundroubinscheduler;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 35, 2);
        scheduler.addProcess(3, 20, 3);
        scheduler.addProcess(4, 40, 4);

        // Display the processes before scheduling
        System.out.println("Initial process list:");
        scheduler.displayProcessList();

        // Set the time quantum and start round-robin scheduling
        int timeQuantum = 5;
        System.out.println("\nStarting Round Robin Scheduling with Time Quantum: " + timeQuantum);
        scheduler.roundRobinScheduling(timeQuantum);

        // Display the process list after scheduling (should be empty as all are completed)
        System.out.println("\nFinal process list:");
        scheduler.displayProcessList();
    }
}
