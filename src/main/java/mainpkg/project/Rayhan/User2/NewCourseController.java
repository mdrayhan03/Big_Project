package mainpkg.project.Rayhan.User2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewCourseController
{
    @javafx.fxml.FXML
    private ComboBox<String> timeCB;
    @javafx.fxml.FXML
    private ComboBox<String> dayCB;
    @javafx.fxml.FXML
    private TextField codeTF;
    @javafx.fxml.FXML
    private TextArea showcourseTA;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> creditCB;

    Faculty user ;
    ObservableList<Course> courses ;
    public void setter(Faculty faculty) {
        this.user = faculty ;
        show();
    }

    @javafx.fxml.FXML
    public void initialize() {
        dayCB.getItems().addAll("ST", "MW", "AR") ;
        timeCB.getItems().addAll("8000-9300", "9400-1110", "1120-1250", "1300-1430", "1440-1610", "1620-1750") ;
        creditCB.getItems().addAll(3,1) ;
    }

    @javafx.fxml.FXML
    public void createCourseOA(ActionEvent actionEvent) {
        String code, title, day, time ;
        int credit ;

        code = codeTF.getText() ;
        title = titleTF.getText() ;
        day = dayCB.getValue() ;
        time = timeCB.getValue() ;
        credit = creditCB.getValue() ;

        user.newCourse(code, title, credit, day, time);
        show();
    }

    public void show() {
        courses = user.courseFileRead() ;
        String s = "" ;

        for (Course course: courses) {
            s += "Course Code: " + course.getCode() +
                 " Couse Title: " + course.getTitle() +
                 " Credit :" + course.getCredit() +
                    " Day :" + course.getDay() +
                    " Time: " + course.getTime() +
                    " Room: " + course.getRoom() +
                    " Status: " + course.getStatus() + "\n" ;
        }
        showcourseTA.setText(s);
    }
}