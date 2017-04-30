package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sample.Models.DMR;
import sample.Models.Student;
import sample.Models.Supervisor;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

import java.util.List;

import static org.junit.Assert.*;


public class Main extends Application {

    /**
     * Start method introduce the new view, starting page
     * */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/startingPage.fxml"));
        primaryStage.setTitle("Starting Viva Session");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);



    }


}
