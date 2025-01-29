package singlylinkedlist.studentrecordmanagement;

public class StudentRecordList {
    StudentRecord head;

    // Constructor
    StudentRecordList() {
        this.head = null;
    }

    // Method to add nodes in a list
    public void addStudentRecord(StudentRecord sr) {

        // Create StudentRecord
        StudentRecord newStudentRecord = new StudentRecord(sr.rollNumber, sr.name, sr.age, sr.grade);
        if(head == null) {
            head = newStudentRecord;
            head.next = null;
        }
        else {
            StudentRecord curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newStudentRecord;

        }
    }

    // Method to add nodes at given position
    public void addStudentRecord(int pos, StudentRecord sr) {

        // Create new Student Record
        StudentRecord newStudentRecord = new StudentRecord(sr.rollNumber, sr.name, sr.age, sr.grade);

        // add the node at first position
        if(pos == 0) {
            newStudentRecord.next = head;
            head = newStudentRecord;
            return;
        }

        StudentRecord dummy = new StudentRecord();
        dummy.next = head;

        while(dummy != null && pos > 0) {  // iterate until we did not get the correct position

            dummy = dummy.next;
            pos--;
        }
        if(dummy == null){  // If position entered in invalid
            System.out.println("Enter valid position to add the node: \n");
            return;
        }

        // insert the node at the given position
        StudentRecord temp = dummy.next;
        dummy.next = newStudentRecord;
        newStudentRecord.next = temp;
    }

    // Delete Student Record with given rollNumber
    public void deleteStudentRecord(int rollNumber) {
        StudentRecord temp = head; // Temporary variable to iterate list
        StudentRecord prev = head;
        while(temp != null) {
            if(temp.rollNumber == rollNumber) {
                if(temp == head) {
                    head = head.next;
                    return;
                }
                else {
                    if(temp.next != null) {
                        prev.next = temp.next;
                        return;
                    }
                    else { // If element to be deleted is the last element of the list
                        prev.next = null;
                        return;
                    }

                }
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("No records found with given rollnumber: \n");
    }

    // Search StudentRecord with given rollnumber
    public String findStudentRecord(int rollNumber) {
        StudentRecord temp = head;
        while(temp != null) {
            if(temp.rollNumber == rollNumber) {
                return "Details of student with given rollnumber is: \nStudent rollNumber is: "+rollNumber+"\n name of student is: "+temp.name+"\n Grade of student is: "+temp.grade+"\nAge of student is: "+temp.age+"\n";
            }
            temp = temp.next;
        }
        return "No student with this roll number exist \n";
    }

    // Method to update studentRecord
    public String updateStudentRecord(int rollNumber, int age, char grade, String name) {
        StudentRecord temp = head;
        while(temp != null) {
            if(temp.rollNumber == rollNumber) {
                temp.name = name;
                temp.age = age;
                temp.grade = grade;
                return "Updated the student record\n";
            }
            temp = temp.next;
        }
        return "No record found\n";
    }


    // Method to display all nodes
    public void displayStudentRecords() {
        StudentRecord temp = head;
        while(temp != null) {
            System.out.println("Roll number of student is: "+temp.rollNumber);
            System.out.println("Name of student is: "+temp.name);
            System.out.println("Age of the student is: "+temp.age);
            System.out.println("Grade of student is: "+temp.grade+"\n");
            temp = temp.next;
        }
    }

}
