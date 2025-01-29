package circularlinkedlist.taskscheduler;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtBeginning(1, "Task 1", 1, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task 2", 2, "2025-02-02");
        scheduler.addTaskAtPosition(1, 3, "Task 3", 1, "2025-02-03");

        // Display all tasks
        scheduler.displayAllTasks();

        // Remove task by ID
        scheduler.removeTaskById(2);

        // Display all tasks again
        scheduler.displayAllTasks();

        // View current task and move to next
        TaskNode nextTask = scheduler.viewCurrentAndMoveToNext();
        if (nextTask != null) {
            scheduler.viewCurrentAndMoveToNext();
        }

        // Search for task by priority
        scheduler.searchTaskByPriority(1);
    }
}
