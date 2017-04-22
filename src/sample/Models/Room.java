package sample.Models;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by regga on 18/04/2017.
 */
public class Room {
    private String roomID;
    private Map<String,String> slot;

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    private String sessionDate;


    public Room(String roomID, Map<String, String> slot) {
        this.roomID = roomID;
        this.slot = slot;
    }

    public Room(){}

    public Room(String roomID){
        this.roomID = roomID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Map<String, String> getSlot() {


        return slot;
    }

    public void setSlot(Map<String, String> slot) {

        this.slot = slot;
    }

    public void bookRoomSlots(Room room,int slot , String studentId){

        Map<String, String> items = room.getSlot();

        switch (slot) {
            case 1:

                items.put("Slot_1",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 2:
                items.put("Slot_2",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 3:
                items.put("Slot_3",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 4:
                items.put("Slot_4",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 5:
                items.put("Slot_5",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 6:
                items.put("Slot_6",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 7:
                items.put("Slot_7",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            case 8:
                items.put("Slot_8",studentId);
                System.out.println("Slot:"+slot+", has been Booked");
                break;
            default:
                throw new IllegalArgumentException("Invalid Slot  " + slot);
        }
    }

    public void resetSlots(Room room){
        Map<String, String> items = new HashMap<String,String>();
        items.put("Slot_1",null);
        items.put("Slot_2",null);
        items.put("Slot_3",null);
        items.put("Slot_4",null);
        items.put("Slot_5",null);
        items.put("Slot_6",null);
        items.put("Slot_7",null);
        items.put("Slot_8",null);
        room.setSlot(items);
    }

    public String isBooked(Room room,int slot ){
        String response;
        Map<String, String> items = room.getSlot();


        switch (slot) {
            case 1:
                response =items.get("slot_1");
                System.out.println("Slot_"+slot+", ,status : "+response);

                return  response;

            case 2:
                response =items.get("slot_2");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 3:
                response =items.get("slot_3");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 4:
                response =items.get("slot_4");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 5:
                response =items.get("slot_5");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 6:
                response =items.get("slot_6");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 7:
                response =items.get("slot_7");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            case 8:
                response =items.get("slot_8");
                System.out.println("Slot_"+slot+", ,status : "+response);
                return  response;

            default:
                throw new IllegalArgumentException("Invalid Slot  " + slot);
        }
    }



    /**
     * Create New Room in DB : //INSERT INTO `db16442932`.`Room` (`idRoom`) VALUES ('NW-1');
     * */
    public void createNewRoom(String roomID,String sessionDate){
        Room room=new Room(roomID);
        room.getRoomID();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                PreparedStatement ps;
                ps = (PreparedStatement) connection.prepareStatement(   "INSERT INTO db16442932.Room (idRoom,sessionDate)" +
                        "VALUES (?,?)   ");
                ps.setString(1, room.getRoomID());
                ps.setString(2, sessionDate);
                ps.executeUpdate();
                ps.close();
                connection.close();
                System.out.println("Query executed, new Room Created ");

            } else {
                System.out.println("Null connection ");
            }
        }catch (Exception e)
        {
            System.out.println("Connection Exception :" +e.getMessage());
        }
    }

    /**
    * Get All Rooms
    * */
    public List<Room> getAllRooms(){
        List<Room> fullRoomList = new ArrayList<Room>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection successful");
                Statement st = null;
                //String query = "SELECT * FROM db16442932.Room WHERE sessionDate="+"'"+sessionDate+"'";
                String query = "SELECT * FROM db16442932.Room WHERE sessionDate";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Room room = new Room();
                    room.setRoomID(resultSet.getString("idRoom"));

                    Map<String, String> items = new HashMap<String,String>();
                    items.put("Slot_1",resultSet.getString("slot_1"));
                    items.put("Slot_2",resultSet.getString("slot_2"));
                    items.put("Slot_3",resultSet.getString("slot_3"));
                    items.put("Slot_4",resultSet.getString("slot_4"));
                    items.put("Slot_5",resultSet.getString("slot_5"));
                    items.put("Slot_6",resultSet.getString("slot_6"));
                    items.put("Slot_7",resultSet.getString("slot_7"));
                    items.put("Slot_8",resultSet.getString("slot_8"));
                    room.setSlot(items);

                    fullRoomList.add(n,room);
                    System.out.println("New Room Added:" + fullRoomList.get(n).getRoomID());
                    n++;
                    room= null;

                }
                connection.close();
                return fullRoomList;
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return fullRoomList;
    }

    /**
     Retrieve Single Room information based on date and RoomID
     */
    public Room reviewRoom(String sessionDate,String idRoom) {
        Room room = new Room();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection successful");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Room WHERE sessionDate=" + "'" + sessionDate + "'" +"AND idRoom+"+ "'"+idRoom+"'";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);

                if (resultSet.next()) {
                    room.setRoomID(resultSet.getString("idRoom"));
                    room.setSessionDate(resultSet.getString("sessionDate"));
                    Map<String, String> items = new HashMap<String,String>();
                    items.put("Slot_1",resultSet.getString("slot_1"));
                    items.put("Slot_2",resultSet.getString("slot_2"));
                    items.put("Slot_3",resultSet.getString("slot_3"));
                    items.put("Slot_4",resultSet.getString("slot_4"));
                    items.put("Slot_5",resultSet.getString("slot_5"));
                    items.put("Slot_6",resultSet.getString("slot_6"));
                    items.put("Slot_7",resultSet.getString("slot_7"));
                    items.put("Slot_8",resultSet.getString("slot_8"));
                    room.setSlot(items);


                    //student=new Student(studentCode,name,surName,address,postCode,mobileNumber,courseFees,enrollmentYear,courseFees,dissertationTitle,supervisorName,staff_idstaff);
                    return room;
                }else{
                    System.out.println("Empty response");
                }
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
        return room;
    }

}
