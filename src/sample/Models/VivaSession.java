package sample.Models;

import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by regga on 16/04/2017.
 */
public class VivaSession {
    private String Date;
    private List<String> sessionsDay;
    private int roomsQuantity;
    private int quantityDMR;
    private int quantityStudents;


    public VivaSession() {
    }

    public void generateVivaSessions(List<Supervisor> supervisorList){
        Room roomA= new Room();
        Room roomB= new Room();
        int checkSessionNo=0;

        for (Supervisor svisor:supervisorList) {
            int sessionQt=0;
            List<Student> studentsViva=svisor.getSupervisorStudentsList(svisor.getIdSTaff());
            int maxSt= studentsViva.size();
            if (maxSt<=2){
                roomA=roomA.findRoom(roomA.getAllAvailableRooms(),maxSt);
                for (int i=1;i<=8;i++){
                    if ((roomA.isBooked(roomA,i).equals(null))||(roomA.isBooked(roomA,i).equals("null"))){
                        roomA.bookRoomSlots(roomA,i,studentsViva.get(i).getStaff_idstaff());
                        roomA.updateRoomInfo(roomA);
                        checkSessionNo++;
                    }
                }

            }else if(maxSt<=6 && maxSt>2){
                int n=6;
                roomA=roomA.findRoom(roomA.getAllAvailableRooms(),maxSt/2);
                for (int i=0;i<((maxSt/2));i++){ // first Segment of list
                    if (sessionQt==maxSt) {
                        break;
                    }
                    roomA.bookRoomSlots(roomA,n,studentsViva.get(i).getStaff_idstaff());
                    roomA.updateRoomInfo(roomA);
                    sessionQt++;
                    n++;
                    checkSessionNo++;
                }

                roomB=roomB.findRoom(roomB.getAllAvailableRooms(),maxSt/2);
                int m=6;
                for (int i=0;i<((maxSt/2));i++){ // Second Segment of list
                    if (sessionQt==(maxSt)) {
                        break;
                    }
                    roomB.bookRoomSlots(roomB,m,studentsViva.get(sessionQt).getStaff_idstaff());
                    roomB.updateRoomInfo(roomB);
                    sessionQt++;
                    checkSessionNo++;
                }
            }
            else {
                roomA=roomA.findRoom6plus(roomA.getAllAvailableRooms());
                for (int i=0;i<((maxSt/2));i++){ // first Segment of list
                    if (sessionQt==maxSt) {
                        break;
                    }
                    roomA.bookRoomSlots(roomA,i+1,studentsViva.get(i).getStaff_idstaff());
                    roomA.updateRoomInfo(roomA);
                    sessionQt++;
                    checkSessionNo++;
                }

                roomB=roomB.findRoom6plus(roomB.getAllAvailableRooms());
                for (int i=0;i<((maxSt/2));i++){ // Second Segment of list
                    if (sessionQt==(maxSt)) {
                        break;
                    }
                    roomB.bookRoomSlots(roomB,i+1,studentsViva.get(sessionQt).getStaff_idstaff());
                    roomB.updateRoomInfo(roomB);
                    sessionQt++;
                    checkSessionNo++;
                }

            }
            }
        System.out.println("Sessions booked: "+ checkSessionNo);

        }
    }


    /*public void generateSessions(List<Supervisor> supervisorList, List<Room> roomList){
        Room room = new Room();
        Supervisor supervisor= supervisorList.get(0);
        int sessionQt=0;
        List<Student> studentsPerTutor= supervisor.getSupervisorStudentsList(supervisor.getIdSTaff());
        int max=studentsPerTutor.size();
        for (Supervisor sp:supervisorList) {
            List<Student> ls=sp.getSupervisorStudentsList(sp.getIdSTaff());
            for(int n=0;n<=roomList.size();n++){
                Room vivaRoomA=roomList.get(n);
                Room vivaRoomB=roomList.get(n+1);

                for(int i=1;i<=4;i++){
                    if (sessionQt==max) {
                        break;
                    }
                    room.bookRoomSlots(vivaRoomA,i,studentsPerTutor.get(sessionQt).getSurName());
                    sessionQt++;
                }
                for(int i=1;i<=4;i++){
                    if (sessionQt==max) {
                        break;
                    }
                    room.bookRoomSlots(vivaRoomB,i,studentsPerTutor.get(sessionQt).getSurName());
                    sessionQt++;
                }
                for(int i=5;i<=8;i++){
                    if (sessionQt==max) {
                        break;
                    }
                    room.bookRoomSlots(vivaRoomA,i,studentsPerTutor.get(sessionQt).getSurName());
                    sessionQt++;
                }
                for(int i=5;i<=8;i++){
                    if (sessionQt==max) {
                        break;
                    }
                    room.bookRoomSlots(vivaRoomB,i,studentsPerTutor.get(sessionQt).getSurName());
                    sessionQt++;
                }
            }
        }



    }*/



