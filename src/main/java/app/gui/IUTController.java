package app.gui;

import app.model.Seminar;
import app.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class IUTController {

    @FXML
    private Label studentID;

    @FXML
    private Label date;

    @FXML
    private TableView<Seminar> seminarTableView;

    @FXML
    private Button submit;

    @FXML
    private Button removeButton;

    @FXML
    private TextField lastnameField;

    @FXML
    private Button addButton;

    @FXML
    public void initialize(){
        GregorianCalendar calendar=new GregorianCalendar();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        date.setText(sdf.format(calendar.getTime()));

        studentID.setText(UUID.randomUUID().toString());

        ((TableColumn)seminarTableView.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<Seminar,String>("name"));
        ((TableColumn)seminarTableView.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<Seminar,String>("time"));
        ((TableColumn)seminarTableView.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory<Seminar,String>("mark"));
    }

    @FXML
    private TextField firstnameField;

    @FXML
    void addAction(ActionEvent event) {
        Seminar seminar=new Seminar("Startup Weekend","21/12/16",Integer.toString(new Random().nextInt(20)));
        seminarTableView.getItems().add(seminar);
    }

    @FXML
    void removeAction(ActionEvent event) {
        seminarTableView.getItems().remove(seminarTableView.getItems().size()-1);
    }

    @FXML
    void submitAction(ActionEvent event) {
        String firstname=firstnameField.getText();
        String lastname=lastnameField.getText();
        List<Seminar> seminars=seminarTableView.getItems();
        String dateString=date.getText();
        String studentIdString=studentID.getText();
        Student student=new Student(dateString,studentIdString,firstname,lastname,seminars);

        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("Result.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage=(Stage) submit.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            ((ResultController)fxmlLoader.getController()).initData(student);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}