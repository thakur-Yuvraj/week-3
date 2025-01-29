package circularlinkedlist.taskscheduler;

class TaskScheduler {
    private TaskNode head = null;

    // Add a task at the beginning of the list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular reference
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;  // Move the head to the new task
        }
    }

    // Add a task at the end of the list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular reference
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
            TaskNode temp = head;
            int count = 0;
            while (count < position - 1 && temp.next != head) {
                temp = temp.next;
                count++;
            }
            if (count == position - 1) {
                newTask.next = temp.next;
                temp.next = newTask;
            }
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        TaskNode current = head;
        TaskNode previous = null;
        while (true) {
            if (current.taskId == taskId) {
                if (previous == null) {
                    // Removing the head node
                    if (current.next == head) {
                        head = null;  // The list is empty now
                    } else {
                        head = current.next;
                        // Update the last node's next pointer
                        TaskNode last = head;
                        while (last.next != current) {
                            last = last.next;
                        }
                        last.next = head;
                    }
                } else {
                    previous.next = current.next;
                }
                System.out.println("Task " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
            if (current == head) {
                break;
            }
        }
        System.out.println("Task " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public TaskNode viewCurrentAndMoveToNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return null;
        }
        System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ", Priority: " + head.priority + ", Due Date: " + head.dueDate + ")");
        return head.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        System.out.println("All tasks:");
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

