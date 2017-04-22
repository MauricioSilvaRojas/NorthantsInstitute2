package sample.Models;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by regga on 16/04/2017.
 */
public class DMR  extends Staff {
    private int quota;



    public DMR(String idSTaff, String name, String surName, int quota) {
        super(idSTaff, name, surName);
        this.quota = quota;
    }

    public DMR() {

    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }


    public void createNewStaff(String staffCode, String name, String surName,int quota){

        DMR dmr = new DMR(staffCode, name,  surName,quota);

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                PreparedStatement ps;
                ps = (PreparedStatement) connection.prepareStatement(   "INSERT INTO db16442932.Staff (staffCode, staffName,  staffSurname,quota)" +
                        "VALUES (?,?,?,?)   ");
                ps.setString(1, dmr.getStaffCode());
                ps.setString(2, dmr.getName());
                ps.setString(3, dmr.getSurName());
                ps.setInt(3, dmr.getQuota());

                ps.executeUpdate();
                ps.close();
                connection.close();
                System.out.println("Query executed, new DMR Created ");

            } else {
                System.out.println("Null connection ");
            }
        }catch (Exception e)
        {
            System.out.println("Connection Exception :" +e.getMessage());
        }
    }

    /**
    * Retrieve name,surname,code,Quota from DB by staffCode
    */
    public DMR getDMR(String staffCode) {
        DMR dmr=new DMR();

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Staff WHERE staffCode=" + "'" + staffCode + "'";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);

                if (resultSet.next()) {
                    dmr.setSurName(resultSet.getString("staffSurname"));
                    dmr.setName(resultSet.getString("staffName"));
                    dmr.setStaffCode(resultSet.getString("stffCode"));
                    dmr.setQuota(resultSet.getInt("quota"));
                    return dmr;
                }else{
                    System.out.println("Empty response");
                }
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return dmr;

    }

    public void updateDMR() {

    }

    public void getSession() {

    }

    public void getAllSession() {

    }
}