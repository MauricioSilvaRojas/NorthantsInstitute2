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
    private String idRef;
    private String roomID;
    private Map<String,String> slot;
    private String sessionDate;
    private Boolean availability;

    public Room() {

    }

    public Room(String roomID) {
        this.roomID = roomID;
    }

    public Room(String roomID, String sessionDate) {
        this.roomID = roomID;
        this.sessionDate = sessionDate;
    }


    public String getIdRef() {
        return idRef;
    }

    public void setIdRef(String idRef) {
        this.idRef = idRef;
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

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }







    /**
     * Update the value of slot withing the room object
     * */
    public Room bookRoomSlots(Room room,int slot , String supervisorSurename){

        Map<String, String> items = room.getSlot();
        switch (slot) {
            case 1:
                items.put("Slot_1",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 2:
                items.put("Slot_2",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 3:
                items.put("Slot_3",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 4:
                items.put("Slot_4",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 5:
                items.put("Slot_5",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 6:
                items.put("Slot_6",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 7:
                items.put("Slot_7",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            case 8:
                items.put("Slot_8",supervisorSurename);
                System.out.println("Slot:"+slot+", has been Booked");
                return room;
            default:
                throw new IllegalArgumentException("Invalid Slot  " + slot);
        }
    }

    /**
     * Clean all the slot values of the Room Object
     * */
    public Room resetSlots(Room room){
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
        return room;
    }



    /**
    * Verify if a slot has a booked value
    * */
    public String isBooked(Room room,int slot ){
        String response;
        Map<String, String> items = room.getSlot();
        switch (slot) {
            case 1:
                response =items.get("Slot_1");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 2:
                response =items.get("Slot_2");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 3:
                response =items.get("Slot_3");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 4:
                response =items.get("Slot_4");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 5:
                response =items.get("Slot_5");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 6:
                response =items.get("Slot_6");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;



            case 7:
                response =items.get("Slot_7");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            case 8:
                response =items.get("Slot_8");
                System.out.println("Slot_"+slot+", ,status : "+response);
                break;


            default:
                throw new IllegalArgumentException("Invalid Slot  " + slot);
        }
        return response;
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
                String query = "SELECT * FROM db16442932.Room ";
                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Room room = new Room();
                    room.setRoomID(resultSet.getString("idRoom"));
                    room.setSessionDate(resultSet.getString("sessionDate"));
                    room.setIdRef(resultSet.getString("idRef"));
                    room.setAvailability(resultSet.getBoolean("availability"));

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
     * Get All Rooms By Date
     * */
    public List<Room> getAllRoomsByDate(){
        List<Room> fullRoomList = new ArrayList<Room>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection successful");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Room WHERE sessionDate="+"'"+sessionDate+"'";

                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Room room = new Room();
                    room.setRoomID(resultSet.getString("idRoom"));
                    room.setSessionDate(resultSet.getString("sessionDate"));
                    room.setIdRef(resultSet.getString("idRef"));
                    room.setAvailability(resultSet.getBoolean("availability"));

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
     * Get All Rooms By Date
     * */
    public List<Room> getAllAvailableRooms(){
        List<Room> fullRoomList = new ArrayList<Room>();
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection successful");
                Statement st = null;
                String query = "SELECT * FROM db16442932.Room WHERE availability="+"'"+"true"+"'";

                st = (Statement) connection.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                int n=0;

                while (resultSet.next()) {
                    Room room = new Room();
                    room.setRoomID(resultSet.getString("idRoom"));
                    room.setSessionDate(resultSet.getString("sessionDate"));
                    room.setIdRef(resultSet.getString("idRef"));
                    room.setAvailability(resultSet.getBoolean("availability"));

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
                    room.setAvailability(resultSet.getBoolean("availability"));
                    room.setIdRef(resultSet.getString("idRef"));


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

    /**
     Update Room information in Room DB table
     */
    public void updateRoomInfo(Room room) {

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Conection succesfull");
                Statement st = null;
                String query = "UPDATE db16442932.Room SET idRef="+"'"+room.getIdRef() + "',"+
                        "slot_1="+"'"+room.getSlot().get("Slot_1") + "',"+
                        "slot_2="+"'"+room.getSlot().get("Slot_2") + "'," +
                        "slot_3="+"'"+room.getSlot().get("Slot_3") + "',"+
                        "slot_4="+"'"+room.getSlot().get("Slot_4") + "',"+
                        "slot_5="+"'"+room.getSlot().get("Slot_5") + "',"+
                        "slot_6="+"'"+room.getSlot().get("Slot_6") + "',"+
                        "slot_7="+"'"+room.getSlot().get("Slot_7") + "'," +
                        "slot_8="+"'"+room.getSlot().get("Slot_8") + "'," +
                        "availability="+"'"+room.getAvailability() + "'," +
                        "sessionDate="+"'"+room.getSessionDate() + "'," +
                        "idRoom="+"'"+room.getRoomID()+ "'" +
                        " WHERE idRef=" + "'" + room.getIdRef() + "'";

                System.out.println("Final Query:"+ query);
                st = (Statement) connection.createStatement();
                st.executeUpdate(query);
                st.close();
                connection.close();
                System.out.println("Room :"+room.getRoomID()+"has been Updated Successfully");
            }

        } catch (Exception e) {
            System.out.println("Connection Exception :"+e.getMessage());
        }
    }

    /**
     Count the available slots for a Room Object
     */
    public int slotsLeft(Room room) {
        int counter =0;
        for (int i=1;i<=8;i++){
            if ((isBooked(room,i))== null ||(isBooked(room,i)).equals("null")){
                counter++;
            }
        }
        return  counter;
    }

    /**
     Find Empty Room with a # of requiredSlots
     */
    public Room findRoom(List<Room> roomList,int requiredSlots) {
        for (Room room:roomList) {
            int slotsLeft=room.slotsLeft(room);
            if (slotsLeft>=requiredSlots){
                return room;
            }
        }
        return null;
    }

    /**
     Find Empty Room with a >6 slots
     */
    public Room findRoom6plus(List<Room> roomList) {
        for (Room room:roomList) {
            int slotsLeft=room.slotsLeft(room);
            if (slotsLeft>=6){
                return room;
            }
        }
        return null;
    }


}
