package mainpkg.project.Rayhan.User3;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainpkg.project.Rayhan.User2.Course;

import java.util.Objects;

public class AddCourseController
{
    @javafx.fxml.FXML
    private TextArea showTA;
    @javafx.fxml.FXML
    private Label titleL;
    @javafx.fxml.FXML
    private TextField roomTF;
    @javafx.fxml.FXML
    private ComboBox<String> codeCB;
    @javafx.fxml.FXML
    private Label timeL;
    @javafx.fxml.FXML
    private Label creditL;
    @javafx.fxml.FXML
    private Label dayL;

    Admin user ;
    ObservableList<Course> courses ;
    public void setter(Admin admin) {
        this.user = admin ;
        show() ;
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void acceptOA(ActionEvent actionEvent) {
        String code ;
        int room ;

        code = codeCB.getValue() ;
        room = Integer.parseInt(roomTF.getText()) ;

        for (Course course: courses) {
            if (Objects.equals(course.getCode(), code)) {
                user.addCourseAccept(course, room);
                break;
            }
        }
        show();
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
        String code ;
        code = codeCB.getValue() ;
        for (Course course: courses) {
            if (Objects.equals(course.getCode(), code)) {
                user.addCourseReject(course);
                break;
            }
        }
        show();
    }

    public void show() {
        courses = user.courseFileRead() ;
        String s = "" ;

        for(Course course: courses) {
            codeCB.getItems().add(course.getCode()) ;

            s += "Course Code: " + course.getCode() +
                    " Couse Title: " + course.getTitle() +
                    " Credit :" + course.getCredit() +
                    " Day :" + course.getDay() +
                    " Time: " + course.getTime() +
                    " Room: " + course.getRoom() +
                    " Status: " + course.getStatus() + "\n";
        }
        showTA.setText(s);
    }

    @javafx.fxml.FXML
    public void codeCBOA(ActionEvent actionEvent) {
        for (Course course: courses) {
            if (Objects.equals(course.getCode(), codeCB.getValue())) {
                titleL.setText(course.getTitle());
                creditL.setText(Integer.toString(course.getCredit()));
                dayL.setText(course.getDay());
                timeL.setText(course.getTime());
                break;
            }
        }
    }
}