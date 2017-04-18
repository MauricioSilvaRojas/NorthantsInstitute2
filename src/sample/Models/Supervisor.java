package sample.Models;

/**
 * Created by regga on 16/04/2017.
 */
public class Supervisor extends Staff implements Module{
    public void getStudents(){

    }

    @Override
    public void enrollStudent() {
        Student student = new Student() ;
        student.getName();
    }

    @Override
    public void asignSupervisor() {

    }

    @Override
    public void getGrades() {

    }

    @Override
    public void setGrades() {

    }
}
