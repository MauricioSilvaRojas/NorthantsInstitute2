package sample.Controller;

import com.jfoenix.controls.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.*;
import sample.Models.*;

import java.io.*;
import java.util.List;

/**
 * Created by regga on 23/04/2017.
 */
public class DashController {
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    ObservableList<Student> studentsList = FXCollections.observableArrayList();
    ObservableList<Room> roomList = FXCollections.observableArrayList();
    Student selectedStudent=new Student();
    Staff selectedStaff= new Staff();
    Room room = new Room();

    @FXML
    private Label totalStudentLabel;

    @FXML
    private Label totalStaffLabel;

    @FXML
    private JFXButton generateButton;

    @FXML
    private Label totalDaysLabel;

    @FXML
    private JFXButton refreshButton;

    @FXML
    private Label totalRoomsLabel;

    @FXML
    private Pane leftPannel;

    @FXML
    private Label totalSupervisorLabel;

    @FXML
    private Label totalDMRLabel;

    @FXML
    private JFXTextField selectedCode;

    @FXML
    private JFXTextField selectedName;

    @FXML
    private JFXTextField selectedSurname;

    @FXML
    private JFXTextField selectedAddress;

    @FXML
    private JFXTextField selectedPostcode;

    @FXML
    private JFXTextField selectedMobile;

    @FXML
    private JFXTextField selectedEmail;

    @FXML
    private JFXTextField selectedYear;

    @FXML
    private JFXTextField selectedCourse;

    @FXML
    private JFXTextField selectedFees;

    @FXML
    private JFXTextField selectedTitle;

    @FXML
    private JFXTextField selectedSupervisor;

    @FXML
    private JFXButton deleteSelected;

    @FXML
    private JFXButton updateSelected;

    @FXML
    private JFXButton newStaffDash;

    @FXML
    private JFXButton deleteSelected1;

    @FXML
    private JFXButton updateSelected1;

    @FXML
    private JFXTextField selectedStaffCode;

    @FXML
    private JFXTextField selectedStaffName;

    @FXML
    private JFXTextField selectedStaffSurname;

    @FXML
    private JFXTextField selectedStaffContract;

    @FXML
    private JFXTextField selectedStaffEmail;

    @FXML
    private JFXTextField selectedStaffQuota;

    @FXML
    private JFXComboBox<String> supervisorComboBox;

    @FXML
    private JFXButton newStudentDash;

    @FXML
    private MenuItem fileExit;

    @FXML
    private Menu closeMenu;

    @FXML
    private MenuItem deleteAllStudentMenu;

    @FXML
    private MenuItem importXls;

    /**
    * Student Table instances
    **/
    @FXML
    private TableColumn<Student, String> studentCode = new TableColumn("studentCode");

    @FXML
    private TableColumn<Student, String> studentName = new TableColumn("studentName");

    @FXML
    private TableColumn<Student, String> studentSurname = new TableColumn("studentSurname");

    @FXML
    private TableColumn<Student, String> address = new TableColumn("address");

    @FXML
    private TableColumn<Student, String> postCode = new TableColumn("postCode");

    @FXML
    private TableColumn<Student, String> studentMobile = new TableColumn("studentMobile");

    @FXML
    private TableColumn<Student, String> studentEmail = new TableColumn("courseName");

    @FXML
    private TableColumn<Student, String> courseName = new TableColumn("courseName");

    @FXML
    private TableColumn<Student, String> courseYear = new TableColumn("courseYear");

    @FXML
    private TableColumn<Student, String> fees = new TableColumn("courseFees");

    @FXML
    private TableColumn<Student, String> supervisor = new TableColumn("supervisor");

    @FXML
    private TableColumn<Student, String> title = new TableColumn("dissertationTitle");

    @FXML
    private TableView<Student> studentsTable;

    /**
    * Staff Table Instances
    * */
    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Staff, String> staffName = new TableColumn("studentCode");

    @FXML
    private TableColumn<Staff, String> staffSurname = new TableColumn("studentName");

    @FXML
    private TableColumn<Staff, String> staffCode = new TableColumn("studentSurname");

    @FXML
    private TableColumn<Staff, String> contractType = new TableColumn("address");

    @FXML
    private TableColumn<Staff, String> quota = new TableColumn("postCode");

    @FXML
    private TableColumn<Staff, String> email = new TableColumn("studentMobile");

    @FXML
    private TableColumn<Staff, String> svStatus = new TableColumn("supervisorStatus");


    @FXML
    private Tab roomsTab;

    @FXML
    private Tab dashboardTab;

    @FXML
    private Tab staffTab;

   @FXML
    private Tab studentsTab;

    @FXML
    private Tab vivaTab;


    //rooms Instances


    @FXML
    private JFXTextField roomStack7_name;

    @FXML
    private JFXCheckBox roomStack2_check2;

    @FXML
    private JFXCheckBox roomStack2_check3;

    @FXML
    private JFXCheckBox roomStack3_check3;

    @FXML
    private JFXCheckBox roomStack4_check2;

    @FXML
    private JFXCheckBox roomStack1_check3;

    @FXML
    private JFXCheckBox roomStack4_check3;

    @FXML
    private JFXCheckBox roomStack5_check3;

    @FXML
    private JFXCheckBox roomStack1_check2;

    @FXML
    private JFXCheckBox roomStack3_check2;

    @FXML
    private JFXCheckBox roomStack5_check2;

    @FXML
    private JFXCheckBox roomStack1_check1;

    @FXML
    private JFXCheckBox roomStack2_check1;

    @FXML
    private JFXCheckBox roomStack3_check1;

    @FXML
    private JFXCheckBox roomStack4_check1;

    @FXML
    private JFXCheckBox roomStack5_check1;

    @FXML
    private JFXCheckBox roomStack6_check3;

    @FXML
    private JFXCheckBox roomStack6_check2;

    @FXML
    private JFXTextField roomStack8_name;

    @FXML
    private JFXTextField roomStack4_name;

    @FXML
    private JFXTextField selectedroomStack1_nameSurname111111;

    @FXML
    private JFXCheckBox roomStack7_check1;

    @FXML
    private JFXToggleButton roomStack9_status;

    @FXML
    private JFXToggleButton roomStack1_status;

    @FXML
    private JFXToggleButton roomStack2_status;

    @FXML
    private JFXToggleButton roomStack5_status;

    @FXML
    private JFXCheckBox roomStack7_check2;

    @FXML
    private JFXCheckBox roomStack6_check1;

    @FXML
    private JFXToggleButton roomStack6_status;

    @FXML
    private JFXCheckBox roomStack7_check3;

    @FXML
    private JFXTextField roomStack1_name;

    @FXML
    private JFXTextField roomStack2_name;

    @FXML
    private JFXTextField roomStack3_name;

    @FXML
    private JFXToggleButton roomStack7_status;

    @FXML
    private JFXTextField roomStack9_name;

    @FXML
    private JFXToggleButton roomStack10_status;

    @FXML
    private JFXCheckBox roomStack9_check1;

    @FXML
    private JFXToggleButton roomStack3_status;

    @FXML
    private JFXToggleButton roomStack4_status;

    @FXML
    private JFXCheckBox roomStack9_check2;

    @FXML
    private JFXCheckBox roomStack9_check3;

    @FXML
    private JFXCheckBox roomStack8_check3;

    @FXML
    private JFXCheckBox roomStack8_check2;

    @FXML
    private JFXTextField roomStack5_name;

    @FXML
    private JFXTextField roomStack6_name;

    @FXML
    private JFXTextField roomStack10_name;

    @FXML
    private JFXCheckBox roomStack8_check1;

    @FXML
    private JFXToggleButton roomStack8_status;

    @FXML
    private JFXCheckBox roomStack10_check3;

    @FXML
    private JFXCheckBox roomStack10_check1;

    @FXML
    private JFXCheckBox roomStack10_check2;

    @FXML
    private JFXButton updateRoomSelection;

    public void initialize() {
        Supervisor sv= new Supervisor();
        System.out.println("starting Dashboard");
        this.setupColumnNames();
        this.loadStudentList();
        this.loadStaffList();
       //this.checkSupervisor();
        this.overallFields();
        VivaSession vivaSession=new VivaSession();
        for (Room room :room.getAllRooms()) {
            room.resetSlots(room);
            room.updateRoomInfo(room);
        }

        vivaSession.generateVivaSessions(sv.getAllSupervisors());


        /**
        * Select student from table
        * */
        studentsTable.setOnMouseClicked((event) -> {
            selectedStudent = studentsTable.getSelectionModel().getSelectedItem();
            selectedCode.setText(selectedStudent.getStudentCode());
            selectedName.setText(selectedStudent.getName());
            selectedSurname.setText(selectedStudent.getSurName());
            selectedAddress.setText(selectedStudent.getAddress());
            selectedPostcode.setText(selectedStudent.getPostCode());
            selectedEmail.setText(selectedStudent.getEmail());
            selectedMobile.setText(selectedStudent.getMobileNumber());
            selectedCourse.setText(selectedStudent.getCourseName());
            selectedYear.setText(selectedStudent.getEnrollmentYear());
            selectedFees.setText(selectedStudent.getCourseFees());
            selectedTitle.setText(selectedStudent.getDissertationTitle());
            selectedSupervisor.setText(selectedStudent.getSupervisorName());
            System.out.println("Selected Student on Table ");
        });

        /**
         * Select Staff from table
         * */
        staffTable.setOnMouseClicked((event) -> {
            selectedStaff = staffTable.getSelectionModel().getSelectedItem();
            selectedStaffCode.setText(selectedStaff.getStaffCode());
            selectedStaffName.setText(selectedStaff.getName());
            selectedStaffSurname.setText(selectedStaff.getSurName());
            selectedStaffContract.setText(selectedStaff.getContractType());
            selectedStaffEmail.setText(selectedStaff.getEmail());
            selectedStaffQuota.setText(selectedStaff.getSupervisorStatus());

            System.out.println("Selected Student on Table ");
        });

        /**
         * Delete student from table
         * */
        deleteSelected.setOnAction((event) ->{
            System.out.println("Deleting selected Student: "+selectedStudent.getName());
            selectedStudent.deleteStudent(selectedStudent);
            selectedStudent=null;
            loadStudentList();
        });

        /**
         * Delete Staff from table
         * */
        deleteSelected1.setOnAction((event) ->{
            System.out.println("Deleting selected Staff: "+selectedStaff.getName());
            selectedStaff.deleteStaff(selectedStaff);
            selectedStaff=null;
            loadStaffList();
        });

        /**
         * Update student from table
         * */
        updateSelected.setOnAction((event) ->{
            System.out.println("Updating selected Student");
            getStudentFields();
            selectedStudent.updateStudentRecords(selectedStudent);
            loadStudentList();
        });

        /**
         * Update Staff from table
         * */
        updateSelected1.setOnAction((event) ->{
            System.out.println("Updating selected Staff");
            getStaffFields();
            selectedStaff.updateStaffRecords(selectedStaff);
            loadStaffList();
        });

        /**
         * Fill the combobox with Supervisor Surname
         * */
        List<Staff> svlist=selectedStaff.getAllStaffMember();
        for (Staff sp:svlist) {
              supervisorComboBox.getItems().add(sp.getSurName());
        }


        /**
         * Update Supervisor Field with Name + surname
         * */
        supervisorComboBox.setOnAction((event) ->{
           String s= supervisorComboBox.getValue();
           Staff staff=new Staff();
           staff=staff.reviewStaff(s);
           selectedStudent.setSupervisorName(staff.getName()+" , "+staff.getSurName());
           selectedStudent.setStaff_idstaff(String.valueOf(staff.getIdSTaff()));
           selectedSupervisor.setText(staff.getName()+" , "+staff.getSurName());

           System.out.println("selected Supervisor ComboBox:"+ selectedStudent.getStaff_idstaff());
        });

        /**
         * Create new Field student in the table
         * */
        newStudentDash.setOnAction((event) ->{
            getStudentFields();
            selectedStudent.createNewStudent(selectedStudent);
            loadStudentList();
            System.out.println("new Student Created"+ selectedStudent.getStaff_idstaff());
        });

        /**
         * Create new Field Staff in the table
         * */
        newStaffDash.setOnAction((event) ->{
            getStaffFields();
            selectedStaff.createNewStaff(selectedStaff);
            loadStaffList();
            System.out.println("new Staff Created"+ selectedStaff.getSurName());
        });

        /**
         * Delete All Student Fields
         * */
        deleteAllStudentMenu.setOnAction((event) ->{
            // not implemented
            System.out.println("Deleting all students");
        });

        /**
         * Update Staff Table records
         * */
        staffTab.setOnSelectionChanged((event) ->{
           loadStaffList();
        } );

        /**
         * Update toggle status
         * */
        roomStack1_status.setOnAction((event) ->{
            toggleChanger(roomStack1_status);
        } );

        roomStack2_status.setOnAction((event) ->{
            toggleChanger(roomStack2_status);
        } );

        roomStack3_status.setOnAction((event) ->{
            toggleChanger(roomStack3_status);
        } );

        roomStack4_status.setOnAction((event) ->{
            toggleChanger(roomStack4_status);
        } );

        roomStack5_status.setOnAction((event) ->{
            toggleChanger(roomStack5_status);
        } );

        roomStack6_status.setOnAction((event) ->{
            toggleChanger(roomStack6_status);
        } );

        roomStack7_status.setOnAction((event) ->{
            toggleChanger(roomStack7_status);
        } );

        roomStack8_status.setOnAction((event) ->{
            toggleChanger(roomStack8_status);
        } );

        roomStack9_status.setOnAction((event) ->{
            toggleChanger(roomStack9_status);
        } );

        roomStack10_status.setOnAction((event) ->{
            toggleChanger(roomStack10_status);
        } );

    }

    /**
     * Set the text fields for table selection:Staff
     * */
    private Staff getStaffFields() {
        selectedStaff.setStaffCode(selectedStaffCode.getText());
        selectedStaff.setName(selectedStaffName.getText());
        selectedStaff.setSurName(selectedStaffSurname.getText());
        selectedStaff.setContractType(selectedStaffContract.getText());
        selectedStaff.setEmail(selectedStaffEmail.getText());

        return selectedStaff;
    }

    /**
     * Set the text fields for table selection:Students
     * */
    private Student getStudentFields() {
        selectedStudent.setStudentCode(selectedCode.getText());
        selectedStudent.setName(selectedName.getText());
        selectedStudent.setSurName(selectedSurname.getText());
        selectedStudent.setAddress(selectedAddress.getText());
        selectedStudent.setPostCode(selectedPostcode.getText());
        selectedStudent.setEmail(selectedEmail.getText());
        selectedStudent.setMobileNumber(selectedMobile.getText());
        selectedStudent.setCourseName(selectedCourse.getText());
        selectedStudent.setEnrollmentYear(selectedYear.getText());
        selectedStudent.setCourseFees(selectedFees.getText());
        selectedStudent.setDissertationTitle(selectedTitle.getText());
        selectedStudent.setSupervisorName(selectedSupervisor.getText());
        return selectedStudent;
    }

    private void checkSupervisor() {

        selectedStaff.updateSupervisorStatus((List<Student>) selectedStudent.getAllStudents());
    }

    /**
     * Load List of All Student
     * */
    private void loadStudentList() {

        Student student= new Student();
        try {
            studentsList=null;
            studentsList = FXCollections.observableArrayList(student.getAllStudents());
            studentsTable.setItems(studentsList);

        }catch (Exception e){
            System.out.println("Error:"+ e.getMessage());
        }
        overallFields();
    }

    /**
     * Load List of All Staff
     * */
    private void loadStaffList() {

        Staff staff= new Staff();
        try {
            staffList=null;
            staffList = FXCollections.observableArrayList(staff.getAllStaffMember());
            staffTable.setItems(staffList);

        }catch (Exception e){
            System.out.println("Error:"+ e.getMessage());
        }
        overallFields();

    }

    /**
     * Load List of All Rooms
     * */
    private void loadRoomList() {

        Room room = new Room();
        try {
            roomList=null;
            roomList = FXCollections.observableArrayList(room.getAllRooms());


        }catch (Exception e){
            System.out.println("Error:"+ e.getMessage());
        }
        overallFields();
        roomTabUpdater();

    }




    /**
    * Update the overall amount of students , staff , rooms
    * */
    public void overallFields() {
        totalStudentLabel.setText(String.valueOf(studentsList.size()));

        Supervisor sv= new Supervisor();
        totalSupervisorLabel.setText(String.valueOf(sv.getAllSupervisors().size()));
        totalStaffLabel.setText(String.valueOf(staffList.size()));

        totalRoomsLabel.setText(String.valueOf(room.getAllAvailableRooms().size()));

        totalDaysLabel.setText((String.valueOf((room.getAllAvailableRooms().size())*8)));
        /*int numberofDays = 3;
        int sessions=studentsList.size()/numberofDays;
        int noRooms = (sessions/8)+1;
        totalRoomsLabel.setText(String.valueOf(noRooms));*/
    }


    @FXML
    void refresButtonEvent(ActionEvent event) {

    }

    @FXML
    void generateButtonEvent(ActionEvent event) {

    }


    public void resetButtonEvent(ActionEvent actionEvent) {
    }

    /**
     * Link between table and class
     * */
    public void setupColumnNames() {
        //studentColumns
        this.studentCode.setCellValueFactory(new PropertyValueFactory("studentCode"));
        this.studentName.setCellValueFactory(new PropertyValueFactory("name"));
        this.studentSurname.setCellValueFactory(new PropertyValueFactory("surName"));
        this.address.setCellValueFactory(new PropertyValueFactory("address"));
        this.postCode.setCellValueFactory(new PropertyValueFactory("postCode"));
        this.studentMobile.setCellValueFactory(new PropertyValueFactory("mobileNumber"));
        this.studentEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.courseName.setCellValueFactory(new PropertyValueFactory("courseName"));
        this.courseYear.setCellValueFactory(new PropertyValueFactory("enrollmentYear"));
        this.fees.setCellValueFactory(new PropertyValueFactory("courseFees"));
        this.supervisor.setCellValueFactory(new PropertyValueFactory("supervisorName"));
        this.title.setCellValueFactory(new PropertyValueFactory("dissertationTitle"));

        //staffColumns
        this.staffName.setCellValueFactory(new PropertyValueFactory("name"));
        this.staffSurname.setCellValueFactory(new PropertyValueFactory("surName"));
        this.staffCode.setCellValueFactory(new PropertyValueFactory("staffCode"));
        this.contractType.setCellValueFactory(new PropertyValueFactory("contractType"));
        this.quota.setCellValueFactory(new PropertyValueFactory("quota"));
        this.email.setCellValueFactory(new PropertyValueFactory("email"));
        this.svStatus.setCellValueFactory(new PropertyValueFactory("supervisorStatus"));


    }



    public void fileExitEvent(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) studentsTable.getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Closing Exception:"+e.getMessage());
        }
    }

    public void addStudentMenuEvent(ActionEvent actionEvent) {
    }

    public void deleteStudentMenuEvent(ActionEvent actionEvent) {
    }

    public void deleteAllStudentMenuEvent(ActionEvent actionEvent) {


    }

    public void addRoomEvent(ActionEvent actionEvent) {
    }

    public void deleteRoomEvent(ActionEvent actionEvent) {
    }

    public void deleteAllEvent(ActionEvent actionEvent) {
    }

    public void updateSelectedEvent(ActionEvent actionEvent) {
    }

    public void deleteSelectedEvent(ActionEvent actionEvent) {

    }

    public void supervuisorComboEvent(ActionEvent actionEvent) {
    }

    public void newStudentEvent(ActionEvent actionEvent) {
    }

    public void newStaffDashEvent(ActionEvent actionEvent) {
    }

    @FXML
    void staffTabEvent(ActionEvent event) {
    }

    @FXML
    void updateRoomSelectionEvent(ActionEvent event) {
        Room room = new Room();

        //room.updateRoomInfo();

    }

    public void importXlsEvent(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import New Student List");
        Stage stage = (Stage) this.newStudentDash.getScene().getWindow();
        //fileChooser.showOpenDialog(stage);
        File file = fileChooser.showOpenDialog(stage);
        String path=file.getPath();
        System.out.println("Loading new File from :"+path);
        XlsReader rf= new XlsReader(path);
        rf.getStudentList();
        loadStudentList();
    }


    public void roomsTabSelectionEvent(Event event) {
        loadRoomList();
        /*roomStack1_name.setText(roomList.get(0).getRoomID());
        roomStack2_name.setText(roomList.get(2).getRoomID());
        roomStack3_name.setText(roomList.get(3).getRoomID());
        roomStack4_name.setText(roomList.get(4).getRoomID());
        roomStack5_name.setText(roomList.get(5).getRoomID());*/

    }


    public void toggleActive(ActionEvent actionEvent) {
    }

    private void toggleChanger(JFXToggleButton toggle){
        if(toggle.isSelected() ){
            toggle.setText("ACTIVE");
        }else {
            toggle.setText("INACTIVE");
        }
    }

    /**
     *  Update the widgets on Room tab based on DB data
     * */
    private void roomTabUpdater() {

        for (int n=0;n<roomList.size();n++) {
            switch (roomList.get(n).getIdRef()) {
                //Room 1
                case "1":
                    roomStack1_name.setText(roomList.get(n).getRoomID());
                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack1_check1.setSelected(true);
                        if (roomStack1_check1.isSelected() || roomStack1_check2.isSelected() || roomStack1_check3.isSelected()) {
                            roomStack1_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack1_status);
                        }
                    } else {
                        roomStack1_check1.setSelected(false);
                    }
                    break;

                case "2":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack1_check2.setSelected(true);
                        if (roomStack1_check1.isSelected() || roomStack1_check2.isSelected() || roomStack1_check3.isSelected()) {
                            roomStack1_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack1_status);
                        }
                    } else {
                        roomStack1_check2.setSelected(false);
                    }
                    break;

                case "3":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack1_check3.setSelected(true);
                        if (roomStack1_check1.isSelected() || roomStack1_check2.isSelected() || roomStack1_check3.isSelected()) {
                            roomStack1_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack1_status);
                        }
                    } else {
                        roomStack1_check3.setSelected(false);
                    }

                    break;

                //Room 2
                case "4":
                    roomStack2_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack2_check1.setSelected(true);
                        if (roomStack2_check1.isSelected() || roomStack2_check2.isSelected() || roomStack2_check3.isSelected()) {
                            roomStack2_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack2_status);
                        }
                    } else {
                        roomStack2_check1.setSelected(false);
                    }
                    break;

                case "5":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack2_check2.setSelected(true);
                        if (roomStack2_check1.isSelected() || roomStack2_check2.isSelected() || roomStack2_check3.isSelected()) {
                            roomStack2_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack2_status);
                        }
                    } else {
                        roomStack2_check2.setSelected(false);
                    }
                    break;

                case "6":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack2_check3.setSelected(true);
                        if (roomStack2_check1.isSelected() || roomStack2_check2.isSelected() || roomStack2_check3.isSelected()) {
                            roomStack2_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack2_status);
                        }
                    } else {
                        roomStack2_check3.setSelected(false);
                    }

                    break;

                //Room 3
                case "7":
                    roomStack3_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack3_check1.setSelected(true);
                        if (roomStack3_check1.isSelected() || roomStack3_check2.isSelected() || roomStack3_check3.isSelected()) {
                            roomStack3_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack3_status);
                        }
                    } else {
                        roomStack3_check1.setSelected(false);
                    }
                    break;

                case "8":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack3_check2.setSelected(true);
                        if (roomStack3_check1.isSelected() || roomStack3_check2.isSelected() || roomStack3_check3.isSelected()) {
                            roomStack3_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack3_status);
                        }
                    } else {
                        roomStack3_check2.setSelected(false);
                    }
                    break;

                case "9":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack3_check3.setSelected(true);
                        if (roomStack3_check1.isSelected() || roomStack3_check2.isSelected() || roomStack3_check3.isSelected()) {
                            roomStack3_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack3_status);
                        }
                    } else {
                        roomStack3_check3.setSelected(false);
                    }
                    break;

                //Room 4
                case "10":
                    roomStack4_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack4_check1.setSelected(true);
                        if (roomStack4_check1.isSelected() || roomStack4_check2.isSelected() || roomStack4_check3.isSelected()) {
                            roomStack4_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack4_status);
                        }
                    } else {
                        roomStack4_check1.setSelected(false);
                    }
                    break;

                case "11":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack4_check2.setSelected(true);
                        if (roomStack4_check1.isSelected() || roomStack4_check2.isSelected() || roomStack4_check3.isSelected()) {
                            roomStack4_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack4_status);
                        }
                    } else {
                        roomStack4_check2.setSelected(false);
                    }
                    break;

                case "12":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack4_check3.setSelected(true);
                        if (roomStack4_check1.isSelected() || roomStack4_check2.isSelected() || roomStack4_check3.isSelected()) {
                            roomStack4_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack4_status);
                        }
                    } else {
                        roomStack4_check3.setSelected(false);
                    }

                    break;

                //Room 5
                case "13":
                    roomStack5_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack5_check1.setSelected(true);
                        if (roomStack5_check1.isSelected() || roomStack5_check2.isSelected() || roomStack5_check3.isSelected()) {
                            roomStack5_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack5_status);
                        }
                    } else {
                        roomStack5_check1.setSelected(false);
                    }
                    break;

                case "14":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack5_check2.setSelected(true);
                        if (roomStack5_check1.isSelected() || roomStack5_check2.isSelected() || roomStack5_check3.isSelected()) {
                            roomStack5_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack5_status);
                        }
                    } else {
                        roomStack5_check2.setSelected(false);
                    }
                    break;

                case "15":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack5_check3.setSelected(true);
                        if (roomStack5_check1.isSelected() || roomStack5_check2.isSelected() || roomStack5_check3.isSelected()) {
                            roomStack5_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack5_status);
                        }
                    } else {
                        roomStack5_check3.setSelected(false);
                    }

                    break;

                //Room 6
                case "16":
                    roomStack6_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack6_check1.setSelected(true);
                        if (roomStack6_check1.isSelected() || roomStack6_check2.isSelected() || roomStack6_check3.isSelected()) {
                            roomStack6_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack6_status);
                        }
                    } else {
                        roomStack6_check1.setSelected(false);
                    }
                    break;

                case "17":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack6_check2.setSelected(true);
                        if (roomStack6_check1.isSelected() || roomStack6_check2.isSelected() || roomStack6_check3.isSelected()) {
                            roomStack6_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack6_status);
                        }
                    } else {
                        roomStack6_check2.setSelected(false);
                    }
                    break;

                case "18":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack6_check3.setSelected(true);
                        if (roomStack6_check1.isSelected() || roomStack6_check2.isSelected() || roomStack6_check3.isSelected()) {
                            roomStack6_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack6_status);
                        }
                    } else {
                        roomStack6_check3.setSelected(false);
                    }

                    break;

                //Room 7
                case "19":
                    roomStack7_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack7_check1.setSelected(true);
                        if (roomStack7_check1.isSelected() || roomStack7_check2.isSelected() || roomStack7_check3.isSelected()) {
                            roomStack7_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack7_status);
                        }
                    } else {
                        roomStack7_check1.setSelected(false);
                    }
                    break;

                case "20":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack7_check2.setSelected(true);
                        if (roomStack7_check1.isSelected() || roomStack7_check2.isSelected() || roomStack7_check3.isSelected()) {
                            roomStack7_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack7_status);
                        }
                    } else {
                        roomStack7_check2.setSelected(false);
                    }
                    break;

                case "21":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack7_check3.setSelected(true);
                        if (roomStack7_check1.isSelected() || roomStack7_check2.isSelected() || roomStack7_check3.isSelected()) {
                            roomStack7_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack7_status);
                        }
                    } else {
                        roomStack7_check3.setSelected(false);
                    }

                    break;

                //Room 8
                case "22":
                    roomStack8_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack8_check1.setSelected(true);
                        if (roomStack8_check1.isSelected() || roomStack8_check2.isSelected() || roomStack8_check3.isSelected()) {
                            roomStack8_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack8_status);
                        }
                    } else {
                        roomStack8_check1.setSelected(false);
                    }
                    break;

                case "23":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack8_check2.setSelected(true);
                        if (roomStack8_check1.isSelected() || roomStack8_check2.isSelected() || roomStack8_check3.isSelected()) {
                            roomStack8_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack8_status);
                        }
                    } else {
                        roomStack8_check2.setSelected(false);
                    }
                    break;

                case "24":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack8_check3.setSelected(true);
                        if (roomStack8_check1.isSelected() || roomStack8_check2.isSelected() || roomStack8_check3.isSelected()) {
                            roomStack8_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack8_status);
                        }
                    } else {
                        roomStack8_check3.setSelected(false);
                    }

                    break;

                //Room 9
                case "25":
                    roomStack9_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack9_check1.setSelected(true);
                        if (roomStack9_check1.isSelected() || roomStack9_check2.isSelected() || roomStack9_check3.isSelected()) {
                            roomStack9_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack9_status);
                        }
                    } else {
                        roomStack9_check1.setSelected(false);
                    }
                    break;

                case "26":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack9_check2.setSelected(true);
                        if (roomStack9_check1.isSelected() || roomStack9_check2.isSelected() || roomStack9_check3.isSelected()) {
                            roomStack9_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack9_status);
                        }
                    } else {
                        roomStack9_check2.setSelected(false);
                    }
                    break;

                case "27":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack9_check3.setSelected(true);
                        if (roomStack9_check1.isSelected() || roomStack9_check2.isSelected() || roomStack9_check3.isSelected()) {
                            roomStack9_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack9_status);
                        }
                    } else {
                        roomStack9_check3.setSelected(false);
                    }

                    break;

                //Room 10
                case "28":
                    roomStack10_name.setText(roomList.get(n).getRoomID());

                    if ((roomList.get(n).getSessionDate().equals("Day1")) && ((roomList.get(n).getAvailability()))) {
                        roomStack10_check1.setSelected(true);
                        if (roomStack10_check1.isSelected() || roomStack10_check2.isSelected() || roomStack10_check3.isSelected()) {
                            roomStack10_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack10_status);
                        }
                    } else {
                        roomStack10_check1.setSelected(false);
                    }
                    break;

                case "29":

                    if ((roomList.get(n).getSessionDate().equals("Day2")) && ((roomList.get(n).getAvailability()))) {
                        roomStack10_check2.setSelected(true);
                        if (roomStack10_check1.isSelected() || roomStack10_check2.isSelected() || roomStack10_check3.isSelected()) {
                            roomStack10_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack10_status);
                        }
                    } else {
                        roomStack10_check2.setSelected(false);
                    }
                    break;

                case "30":
                    if ((roomList.get(n).getSessionDate().equals("Day3")) && ((roomList.get(n).getAvailability()))) {
                        roomStack10_check3.setSelected(true);
                        if (roomStack10_check1.isSelected() || roomStack10_check2.isSelected() || roomStack10_check3.isSelected()) {
                            roomStack10_status.setSelected(roomList.get(n).getAvailability());
                            toggleChanger(roomStack10_status);
                        }
                    } else {
                        roomStack10_check3.setSelected(false);
                    }

                    break;
            }
        }
    }





}
