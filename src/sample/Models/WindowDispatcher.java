package sample.Models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by regga on 22/04/2017.
 */
public class WindowDispatcher {
    private String location;


    public WindowDispatcher() {

    }

    public WindowDispatcher(String location) {
        this.location = location;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Windows selector method of Windows Dispacther Clases, provides the fucntionaly for start a new view
     * */

    public void windowSelector(String location) throws IOException {
        try {
            Parent parent = (Parent)FXMLLoader.load(this.getClass().getResource(location));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}
