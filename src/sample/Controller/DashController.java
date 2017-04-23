package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import sample.Models.Staff;
import sample.Models.Student;

/**
 * Created by regga on 23/04/2017.
 */
public class DashController {
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    ObservableList<Student> studentsList = FXCollections.observableArrayList();

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
    private TableColumn<Student, String> title = new TableColumn("dissertationTitle");

    @FXML
    private TableView<Student> studentsTable;


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




    public void initialize() {

        System.out.println("starting Dashboard");
        this.setupColumnNames();
        this.loadStudentList();

        studentsTable.setOnMouseClicked((event) -> {
            Student student = studentsTable.getSelectionModel().getSelectedItem();
            selectedCode.setText(student.getStudentCode());
            selectedName.setText(student.getName());
            selectedSurname.setText(student.getSurName());
            selectedAddress.setText(student.getAddress());
            selectedPostcode.setText(student.getPostCode());
            selectedEmail.setText(student.getEmail());
            selectedMobile.setText(student.getMobileNumber());
            selectedCourse.setText(student.getCourseName());
            selectedYear.setText(student.getEnrollmentYear());
            selectedFees.setText(student.getCourseFees());
            selectedTitle.setText(student.getDissertationTitle());
            selectedSupervisor.setText(student.getSupervisorName());
            System.out.println("Selected Student on Table ");
        });
    }

    private void loadStudentList() {
        Student student= new Student();
        try {
            studentsList = FXCollections.observableArrayList(student.getAllStudents());
            studentsTable.setItems(studentsList);
        }catch (Exception e){
            System.out.println("Error:"+ e.getMessage());
        }

    }


    @FXML
    void refresButtonEvent(ActionEvent event) {

    }

    @FXML
    void generateButtonEvent(ActionEvent event) {

    }


    public void resetButtonEvent(ActionEvent actionEvent) {
    }

    public void setupColumnNames() {
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
        this.title.setCellValueFactory(new PropertyValueFactory("dissertationTitle"));

    }

    public void fileExitEvent(ActionEvent actionEvent) {
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
}
