package sample.Models;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by regga on 16/04/2017.
 */
public class Staff {
    private int idSTaff;
    private String staffCode;
    private String name;
    private String surName;
    private String email;
    private List<Skill> skillList = new ArrayList<Skill>();
    private String contractType;
    private Map<String, String> availabilityDays;


    public Staff() {

    }


    public Staff(int idSTaff, String staffCode, String name, String surName, List<Skill> skillList, String contractType, Map<String, String> availabilityDays) {
        this.idSTaff = idSTaff;
        this.staffCode = staffCode;
        this.name = name;
        this.surName = surName;
        this.skillList = skillList;
        this.contractType = contractType;
        this.availabilityDays = availabilityDays;
    }

    public Staff(String staffCode, String name, String surName) {
        this.staffCode = staffCode;
        this.name = name;
        this.surName = surName;
    }

    public int getIdSTaff() {
        return idSTaff;
    }

    public void setIdSTaff(int idSTaff) {
        this.idSTaff = idSTaff;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
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

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Map<String, String> getAvailabilityDays() {
        return availabilityDays;
    }

    public void setAvailabilityDays(Map<String, String> availabilityDays) {
        this.availabilityDays = availabilityDays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Create New Staff in DB //INSERT INTO `db16442932`.`staff` (`idstaff`, `staffName`, `staffSurname`, `staffCode`, `contractType`) VALUES ('3', 'Eric', 'Clapton', '654654654', 'part Time');

     * */
    public void createNewStaff(String staffCode, String name, String surName){

        Staff staff = new Staff(staffCode, name,  surName);

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                PreparedStatement ps;
                ps = (PreparedStatement) connection.prepareStatement(   "INSERT INTO db16442932.Staff (staffCode, staffName,  staffSurname)" +
                        "VALUES (?,?,?)   ");
                ps.setString(1, staff.getStaffCode());
                ps.setString(2, staff.getName());
                ps.setString(3, staff.getSurName());

                ps.executeUpdate();
                ps.close();
                connection.close();
                System.out.println("Query executed, new Staff Created ");

            } else {
                System.out.println("Null connection ");
            }
        }catch (Exception e)
        {
            System.out.println("Connection Exception :" +e.getMessage());
        }
    }

    /**
     * Return a List<Staff> object with all Staff
     * */
    public List<Staff> getAllStaffMember(){
        List<Staff> fullList = new ArrayList<Staff>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection successful");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Staff";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setIdSTaff(resultSet.getInt("idStaff"));
                    staff.setStaffCode(resultSet.getString("staffCode"));
                    staff.setName(resultSet.getString("staffName"));
                    staff.setSurName(resultSet.getString("staffSurname"));
                    staff.setEmail(resultSet.getString("email"));
                    staff.setContractType(resultSet.getString("contractType"));
                    //staff.setAvailabilityDays(resultSet.getString("courseName"));

                    fullList.add(n,staff);
                    System.out.println("New Student Added:" + fullList.get(n).getName());
                    n++;
                    staff= null;

                }
                connection.close();
                return fullList;
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return fullList;
    }



}
