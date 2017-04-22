package sample.Models;

import java.util.List;

/**
 * Created by regga on 16/04/2017.
 */
class Session {
    private String Date;
    private List<String> sessionsDay;
    private int roomsQuantity;
    private int quantityDMR;
    private int quantityStudents;


    public List<Supervisor> findAllSupervisor(){
        Supervisor  supervisor = new Supervisor();
        List<Supervisor> supervisorList= supervisor.getAllSupervisors();
        return supervisorList;
    }

   // public List<Room> findAllRoomsByDay(String sessionDate){
//        Room room= new Room();
//        room.
//        List<Room> listRoom=room.getAllRooms();
//        return listRoom;
    //}

    public void booking(int roomsCounter, int daysCounter){
        List<Supervisor> superList=findAllSupervisor();
        Room roomA=new Room();
        for (Supervisor supervisor:superList) {
            List<Student> studentList= supervisor.getSupervisorStudentsList(supervisor.getIdSTaff());//studentList
            for (Student student:studentList) {
                Room room= new Room();
                List<Room> listRoom=room.getAllRooms();// list room
                for (int n=1; n<8; n++){//n slots
                    for(int s=0;s<studentList.size();s++)//s students
                        if (((studentList.get(s)) == null)){
                            room.bookRoomSlots(listRoom.get(n),n,studentList.get(s).getStudentCode());
                            room.bookRoomSlots(listRoom.get(n+1),n,studentList.get(s+1).getStudentCode());
                    }
                }
            }

        }
    }

}
