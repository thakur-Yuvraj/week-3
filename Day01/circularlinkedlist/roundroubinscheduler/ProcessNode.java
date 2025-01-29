package circularlinkedlist.roundroubinscheduler;

class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor to initialize a process with its details
    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
