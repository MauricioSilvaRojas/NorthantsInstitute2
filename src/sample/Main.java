package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sample.Models.Student;
import sample.Models.Supervisor;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

import java.util.List;

import static org.junit.Assert.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loading_students.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        Student student=new Student();
        student=student.reviewStudent("16442932");
        System.out.println("Review Studenmt = "+ student.getName());
        List<Student> fullList= student.getAllStudents();
        int x= fullList.size();
        System.out.println("Full size = "+ x);

        System.out.println("Full size = "+fullList.get(5).getName() );

        student.createNewStudent("00500500","Eva","Thompson","6 Square","nn5 nn5","evaEmail@.com","078888848","HDN Games","2015","6500","War Game","Anastacious");

    }


    public static void main(String[] args) {
        launch(args);



    }


}
