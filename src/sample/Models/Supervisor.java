package sample.Models;

import com.mysql.jdbc.Statement;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by regga on 16/04/2017.
 */
public class Supervisor extends Staff {


    public Supervisor(){

    }

    public Supervisor(String idSTaff, String name, String surName) {
        super(idSTaff, name, surName);
    }



    /**
     * Return a List<student> where staff is supervisor
     * */
    public  List<Student>  getSupervisorStudentsList(int idstaff){
            List<Student> fullList = new ArrayList<Student>();
            try {
                Connection connection = DBConnection.getConnection();
                if (connection != null) {
                    System.out.println("Conection succesfull");
                    Statement st = null;
                    String query = "SELECT * FROM db16442932.Students WHERE staff_idStaff="+"'"+idstaff+"'";
                    st = (Statement) connection.createStatement();
                    ResultSet resultSet = st.executeQuery(query);
                    int n=0;

                    while (resultSet.next()) {
                        Student student = new Student();
                        student.setStudentCode(resultSet.getString("studentCode"));
                        student.setName(resultSet.getString("studentName"));
                        student.setSurName(resultSet.getString("studentSurname"));
                        student.setAddress(resultSet.getString("address"));
                        student.setPostCode(resultSet.getString("postCode"));
                        student.setMobileNumber(resultSet.getString("mobileNumber"));
                        student.setCourseName(resultSet.getString("courseName"));
                        student.setEnrollmentYear(resultSet.getString("enrollYear"));
                        student.setCourseFees(resultSet.getString("courseFees"));
                        student.setDissertationTitle(resultSet.getString("dissertationTitle"));
                        student.setSupervisorName(resultSet.getString("supervisorName"));
                        student.setStaff_idstaff(resultSet.getString("staff_idstaff"));

                        fullList.add(n,student);
                        System.out.println("New Student item Added:" + fullList.get(n).getName());
                        n++;
                        student= null;
                    }
                    connection.close();
                    return fullList;
                }
            } catch (Exception e) {
                System.out.println("Connection Exception :"+e.getMessage());
            }
            return fullList;
        }

    public Boolean isSupervisor(Supervisor supervisor){
        Boolean response=false;
        List<Student> stList=supervisor.getSupervisorStudentsList(supervisor.getIdSTaff());
        if ((stList.size() > 0) & (true)){
            response= true;
        }
        return response;
    }

    /**
     * Return a List<Staff> where staff is supervisor
     * */
    public  List<Supervisor>  getAllSupervisors(){
        List<Supervisor> fullList = new ArrayList<Supervisor>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection succesfull");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Staff WHERE supervisorStatus="+"'"+"True"+"'";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Supervisor superV = new Supervisor();
                    superV.setIdSTaff(resultSet.getInt("idStaff"));
                    superV.setStaffCode(resultSet.getString("staffCode"));
                    superV.setName(resultSet.getString("staffName"));
                    superV.setSurName(resultSet.getString("staffSurname"));
                    superV.setEmail(resultSet.getString("email"));
                    superV.setContractType(resultSet.getString("contractType"));
                    superV.setSupervisorStatus(resultSet.getString("supervisorStatus"));

                    fullList.add(n,superV);
                    System.out.println("New Student item Added:" + fullList.get(n).getName());
                    n++;
                    superV= null;
                }
                connection.close();
                return fullList;
            }
        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return fullList;
    }

    /**
     Update student information based on StudentCode //UPDATE `db16442932`.`Students` SET `studentName`='Narisarana', `studentSurname`='Boait', `mobileNumber`='085555555' WHERE `idStudents`='18' and`staff_idstaff`='9999';

     */
    public void updateSaffStatus(int staffID,String status) {
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "UPDATE db16442932.Staff SET supervisorStatus="+"'"+status + "'"+
                        " WHERE idstaff=" + "'" + staffID + "'";
                System.out.println("Final Query:"+ query);
                st = (Statement) connection.createStatement();
                st.executeUpdate(query);
                st.close();
                connection.close();

                System.out.println("Staff :"+staffID+",Code:has been Updated Successfully");
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
    }


}
