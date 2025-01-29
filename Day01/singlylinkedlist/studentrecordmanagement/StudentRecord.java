package singlylinkedlist.studentrecordmanagement;

class StudentRecord {

    //Properties of StudentRecord
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentRecord next;

    // Default Constructor
    StudentRecord() {

    }

    // Constructor to initialize values
    StudentRecord(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
        this.grade = grade;
        this.next = null;
    }
}
