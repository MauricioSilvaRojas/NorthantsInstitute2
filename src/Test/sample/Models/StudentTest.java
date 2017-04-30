package sample.Models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by regga on 30/04/2017.
 */
public class StudentTest {
    Student testStudent=new Student();
    /**
     * Review a single student with the code 89 as argument, the folowing line represent a full details of the student
     * '1710', '115.0', 'Eziechiele', 'Spurdon', '29 Center Junction', NULL, '221-36-8358', 'BMC Remedy Ticketing System', '9/3/2015', '£10186.33', 'synthesize back-end e-services', NULL, '10019', 'ecapey36@fda.gov', NULL
     * */
    @Test
    public void reviewStudent() throws Exception {

                String name =testStudent.reviewStudent("1710").getName();
                assertEquals("Eziechiele",name);
    }

    /**
     * Calculate the number of student within the system
     * */
    @Test
    public void getAllStudents() throws Exception {
        int listSize=testStudent.getAllStudents().size();
        assertEquals(115,listSize);
        System.out.println("listSize: "+ listSize);
    }

    /**
     * Generate a new row in Students table based on student code, name and surname
     * Verify the size of the list
     * */
    @Test
    public void createNewStudent() throws Exception {
        int total=testStudent.getAllStudents().size();
        Student addingStudent = new Student("16442932","Mauricio ","Silva");
        testStudent.createNewStudent(addingStudent);
        int totalFinal = testStudent.getAllStudents().size();
        assertEquals(total+1,totalFinal);

    }

    /**
     * Delete a new row in Students
     * Verify the size of the list
     * */
    @Test
    public void deleteStudent() throws Exception {
        int total=testStudent.getAllStudents().size();
        System.out.println("Precodnition:"+total);
        Student deletingStudent = testStudent.reviewStudent("1710");
        System.out.println("Student for deletion::"+deletingStudent.getIdStudent());
        testStudent.deleteStudent(deletingStudent);
        int totalFinal = testStudent.getAllStudents().size();
        System.out.println("Precodnition:"+total);
        System.out.println("post Condition:"+totalFinal);
        total=total-1;
        assertEquals(total,totalFinal);

    }

    /**
     * Based on the id review and update a single record
     * Verify the changed name
     * */
    @Test
    public void updateStudentRecords() throws Exception {
        Student student = new Student();
        student= student.reviewStudent("1707");
        System.out.println("review Student name: "+ student.getStaff_idstaff());
        String preName=student.getName();
        /** '1707', '112.0', 'Brittani', 'Pratton', '7940 4th Park', NULL, '794-69-1226', 'LPN', '1/10/2017', '£9154.49', 'disintermediate visionary communities', NULL, '10019', 'bgreenstock33@friendfeed.com', NULL        */
        student.setName("Laura");
        student.updateStudentRecords(student);
        System.out.println("After Update: "+ student.getName());
        String postName=student.getName();



        testStudent=testStudent.reviewStudent("1707");

        assertEquals(postName,testStudent.getName());
        System.out.println("review: "+ testStudent.getName());

    }

}