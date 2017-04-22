package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import sample.Models.XlsReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by regga on 22/04/2017.
 */
public class LoadStudentController {
    @FXML
    private JFXButton exitButton;

    @FXML
    private JFXButton loadFile;

    @FXML
    void loadFileEvent(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = (Stage) this.exitButton.getScene().getWindow();
        //fileChooser.showOpenDialog(stage);
        File file = fileChooser.showOpenDialog(stage);
        String path=file.getPath();
        System.out.println("Loading new File from :"+path);
        XlsReader rf= new XlsReader(path);
        rf.getStudentList();


    }

    private void readFile(String path) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        String result=row.getCell(0).toString();
        System.out.println("Read from file row :"+result);

    }

    @FXML
    void exitEvent(ActionEvent event) {
        Stage stage = (Stage) this.exitButton.getScene().getWindow();
        stage.close();
    }
}
