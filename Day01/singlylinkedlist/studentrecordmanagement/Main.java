package singlylinkedlist.studentrecordmanagement;

public class Main {
    public static void main(String[] args) {
        // Create instance of student record
        StudentRecord stud1 = new StudentRecord(123, "sahil", 21, 'A');
        StudentRecord stud2 = new StudentRecord(124, "rahil", 24, 'C');
        StudentRecord stud3 = new StudentRecord(125, "sahds", 23, 'B');
        StudentRecord stud4 = new StudentRecord(126, "sadsd", 22, 'B');
        StudentRecord stud5 = new StudentRecord(127, "sasds", 22, 'D');

        // Creating list of StudentRecord
        StudentRecordList list1 = new StudentRecordList();
        list1.addStudentRecord(stud1);
        list1.addStudentRecord(stud2);
        list1.addStudentRecord(stud3);

        // Adding element at given position(Based on 0th index)
        list1.addStudentRecord(0,stud4);
        list1.addStudentRecord(5,stud5);  // This will not be added to the list because this position is invalid

        //Delete any record
        list1.deleteStudentRecord(124);
        list1.displayStudentRecords();

        //Find Student Record
        System.out.println(list1.findStudentRecord(125));

        // Method to update the values(Based on rollNumber)
        list1.updateStudentRecord(123,21,'A',"Tensen");
        list1.displayStudentRecords();  // Output after upadation
    }
}
