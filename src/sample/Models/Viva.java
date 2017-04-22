package sample.Models;

/**
 * Created by regga on 18/04/2017.
 */
public class Viva {
    private int vivaID;
    private Student student;
    private Supervisor supervisor;
    private DMR dmr;
    private String gradeSupervisor;
    private String gradeDMR;


    public void enrollStudent(String studentCode, String name, String surName, String address, String postCode, String email, String mobileNumber, String courseName, String enrollmentYear, String courseFees, String disertationTittle,String supervisorID,String doubleMarkerID) {
        Student student=new Student();
        //student.createNewStudent(studentCode, name, surName, address, postCode, email, mobileNumber, courseName, enrollmentYear, courseFees, disertationTittle);
        student.createNewStudent(student);
        asignSupervisor(student.getStudentCode(),supervisorID);
        asignDoubleMarker(student.getStudentCode(),doubleMarkerID);
    }


    public void asignSupervisor(String studentCode,String staffID) {
        Student student=new Student();
        student=student.reviewStudent(studentCode);
        student.setStaff_idstaff(staffID);
        student.updateStudentRecords(student);
    }

    public void asignDoubleMarker(String studentCode,String staffID) {
        Student student=new Student();
        student=student.reviewStudent(studentCode);
        student.setDoubleMarkerID(staffID);
        student.updateStudentRecords(student);
    }




    public void getGrades() {

    }


    public void setGrades() {

    }
}

