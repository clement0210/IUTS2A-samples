package app;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

/**
 * Created by cduffau on 24/05/16.
 */
public class Student {

    private SimpleStringProperty studentId, date, firstname, lastName;
    private List<Seminar> seminars;

    public Student(String date, String studentId, String firstname, String lastName, List<Seminar> seminars) {
        this.date = new SimpleStringProperty(date);
        this.studentId = new SimpleStringProperty(studentId);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastName);
        this.seminars = seminars;
    }

    public String getStudentId() {
        return studentId.get();
    }


    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastName() {
        return lastName.get();
    }


    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    @Override
    public String toString() {
        return "app.Student{" + "\n"+
                "studentId=" + studentId.get() + "\n"+
                ", date=" + date.get() + "\n"+
                ", firstname=" + firstname.get() + "\n"+
                ", lastName=" + lastName.get() + "\n"+
                ", seminars=" + seminars + "\n"+
                '}';
    }
}
