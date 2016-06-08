package app.gui;

import app.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by cduffau on 24/05/16.
 */
public class ResultController {

    @FXML
    private Label result;

    @FXML
    void initialize() {}


    void initData(Student student){
        result.setText(student.toString());
    }

}
