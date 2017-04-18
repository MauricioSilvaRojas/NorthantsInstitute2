package sample.Models;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by regga on 16/04/2017.
 */
public class Student {

    private int idStudent;
    private String studentCode;
    private String name;
    private String surName;
    private String address;
    private String postCode;
    private String email;
    private String mobileNumber;
    private String courseName;
    private String enrollmentYear;
    private String courseFees;
    private List<Assesment> assesments = new ArrayList<Assesment>();
    private String dissertationTitle;
    private String supervisorName;
    private String staff_idstaff;


    public Student(int idStudent, String studentCode, String name, String surName, String address, String postCode, String email, String mobileNumber, String courseName, String enrollmentYear, String courseFees, String dissertationTitle, List<Assesment> assesments) {
        this.idStudent = idStudent;
        this.studentCode = studentCode;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.courseName = courseName;
        this.enrollmentYear = enrollmentYear;
        this.courseFees = courseFees;
        this.assesments = assesments;
    }

    public Student(String studentCode, String name, String surName, String address, String postCode, String email, String mobileNumber, String courseName, String enrollmentYear, String courseFees, String dissertationTitle,String supervisorName) {
        this.studentCode = studentCode;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.courseName = courseName;
        this.enrollmentYear = enrollmentYear;
        this.courseFees = courseFees;
        this.dissertationTitle = dissertationTitle;
        this.supervisorName=supervisorName;
    }

    public Student() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(String courseFees) {
        this.courseFees = courseFees;
    }

    public List<Assesment> getAssesments() {
        return assesments;
    }

    public void setAssesments(List<Assesment> assesments) {
        this.assesments = assesments;
    }

    public String getDissertationTitle() {
        return dissertationTitle;
    }

    public void setDissertationTitle(String dissertationTitle) {
        this.dissertationTitle = dissertationTitle;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getStaff_idstaff() {
        return staff_idstaff;
    }

    public void setStaff_idstaff(String staff_idstaff) {
        this.staff_idstaff = staff_idstaff;
    }

    /**
    Retrieve student information based on StudentCode
     */
    public Student reviewStudent(String studentCode) {
        Student student = new Student();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Students WHERE studentCode=" + "'" + studentCode + "'";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);

                if (resultSet.next()) {
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

                    //student=new Student(studentCode,name,surName,address,postCode,mobileNumber,courseFees,enrollmentYear,courseFees,dissertationTitle,supervisorName,staff_idstaff);
                    return student;
                 }else{
                    System.out.println("Empty response");
                }
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return student;
    }


    /**
    * Return a List<student> object with all enrrolled students
    * */
    public List<Student> getAllStudents(){
        List<Student> fullList = new ArrayList<Student>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Students";
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
                    System.out.println("New Student Added:" + fullList.get(n).getName());
                    n++;
                    student= null;

                }
                return fullList;
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }



        return fullList;
    }

    /**
    * Create New Student in DB
    * */
    public void createNewStudent(String studentCode, String name, String surName, String address, String postCode, String email, String mobileNumber, String courseName, String enrollmentYear, String courseFees, String disertationTittle,String supervisorName){

        Student student = new Student(studentCode, name,  surName,  address,  postCode,  email,  mobileNumber,  courseName,  enrollmentYear,  courseFees, disertationTittle, supervisorName);

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {

                //sampple sql : INSERT INTO `db16442932`.`Students` (`studentCode`, `studentName`, `studentSurname`, `staff_idstaff`) VALUES ('554466557', 'Ella', 'Fitzgerald', '2');
                System.out.println("Conection succesfull");
                PreparedStatement ps;
                ps = (PreparedStatement) connection.prepareStatement(   "INSERT INTO db16442932.Students (studentCode, studentName,  studentSurname,  address" +
                                                                            ",  postCode,  studentEmail,  mobileNumber,  courseName,  enrollYear,  courseFees, dissertationTitle, supervisorName)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)   ");
                ps.setString(1, student.getStudentCode());
                ps.setString(2, student.getName());
                ps.setString(3, student.getSurName());
                ps.setString(4, student.getAddress());
                ps.setString(5, student.getPostCode());
                ps.setString(6, student.getEmail());
                ps.setString(7, student.getMobileNumber());
                ps.setString(8, student.getCourseName());
                ps.setString(9, student.getEnrollmentYear());
                ps.setString(10, student.getCourseFees());
                ps.setString(11, student.getDissertationTitle());
                ps.setString(12, student.getSupervisorName());

                ps.executeUpdate();
                ps.close();
                connection.close();
                System.out.println("Query executed, new Student Created ");

            } else {
                System.out.println("Null connection ");
            }
        }catch (Exception e)
                {
                    System.out.println("Connection Exception :" +e.getMessage());
                }
        }

    /**
     Delete student information based on StudentCode
     */
    public Student deleteStudent(String studentCode) {
        Student student = new Student();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Students WHERE studentCode=" + "'" + studentCode + "'";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);

                if (resultSet.next()) {
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

                    //student=new Student(studentCode,name,surName,address,postCode,mobileNumber,courseFees,enrollmentYear,courseFees,dissertationTitle,supervisorName,staff_idstaff);
                    return student;
                }else{
                    System.out.println("Empty response");
                }
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return student;
    }

}
