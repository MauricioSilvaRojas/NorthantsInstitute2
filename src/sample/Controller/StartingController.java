package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Models.WindowDispatcher;

import java.io.IOException;

/**
 * Created by regga on 21/04/2017.
 */
public class StartingController {

    @FXML
    private JFXButton newVIVAButton;

    @FXML
    private JFXButton loadVivaButton;

    @FXML
    private JFXButton exitButton;

    /**
     * Load the import file View
     * */
    @FXML
    void newVIVAEvent(ActionEvent event) throws IOException {
        WindowDispatcher wd=new WindowDispatcher("../Views/load_students.fxml");
        try {
            wd.windowSelector(wd.getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lead the new View : Dashboard
     * */
    @FXML
    void loadVivaEvent(ActionEvent event) throws IOException {
        WindowDispatcher wd=new WindowDispatcher("../Views/dash.fxml");
        try {
            wd.windowSelector(wd.getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Closing the current Window
     * */
    @FXML
    void exitEvent(ActionEvent event) {
        try {
            Stage stage = (Stage) this.exitButton.getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Closing Exception:"+e.getMessage());
        }
    }


}
