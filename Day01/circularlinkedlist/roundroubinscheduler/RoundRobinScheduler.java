package circularlinkedlist.roundroubinscheduler;

class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int totalProcesses;

    // Constructor to initialize the scheduler
    public RoundRobinScheduler() {
        head = tail = null;
        totalProcesses = 0;
    }

    // Add a new process at the end of the circular linked list
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);

        if (head == null) {
            // If no process is present, set both head and tail to the new process
            head = tail = newProcess;
            newProcess.next = head; // Circular linking
        } else {
            // Add the new process to the end of the list
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain the circular nature
        }
        totalProcesses++;
    }

    // Remove a process by Process ID after it completes execution
    public void removeProcess(int processID) {
        if (head == null) return;

        ProcessNode temp = head;
        ProcessNode prev = null;

        // Check if the head needs to be removed
        if (head.processID == processID) {
            if (head == tail) {
                head = tail = null; // If there was only one process
            } else {
                head = head.next;
                tail.next = head; // Maintain the circular link
            }
        } else {
            // Search for the process to remove
            do {
                prev = temp;
                temp = temp.next;
            } while (temp != head && temp.processID != processID);

            // Process not found
            if (temp == head) return;

            prev.next = temp.next;

            // If it was the tail node
            if (temp == tail) {
                tail = prev;
            }
        }
        totalProcesses--;
    }

    // Simulate Round Robin Scheduling with a fixed time quantum
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode current = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        // Simulate the round-robin process scheduling
        while (totalProcesses > 0) {
            if (current.burstTime > 0) {
                int timeUsed = Math.min(current.burstTime, timeQuantum);

                // Update the burst time after executing for the time quantum
                current.burstTime -= timeUsed;

                // Add to waiting time and turnaround time
                totalTurnaroundTime += timeUsed;
                totalWaitingTime += (totalTurnaroundTime - current.burstTime);

                System.out.println("Process " + current.processID + " executed for " + timeUsed + " units.");

                if (current.burstTime == 0) {
                    System.out.println("Process " + current.processID + " has completed.");
                    removeProcess(current.processID); // Remove the process after completion
                }
            }

            // Move to the next process in the circular list
            current = current.next;
        }

        // Calculate and display the average waiting time and turnaround time
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (float) totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (float) totalProcesses));
    }

    // Display the current list of processes in the circular queue
    public void displayProcessList() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }

        ProcessNode current = head;
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}
