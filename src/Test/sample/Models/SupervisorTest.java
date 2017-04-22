package sample.Models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by regga on 19/04/2017.
 */
public class SupervisorTest {
    @Test
    public void getSupervisorStudentsList() throws Exception {
        Supervisor supervisor=new Supervisor();
        List<Student> studentList=supervisor.getSupervisorStudentsList(1);
        assertNotNull(studentList);
    }

}