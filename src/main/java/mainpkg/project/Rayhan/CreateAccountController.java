package mainpkg.project.Rayhan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainpkg.project.Rayhan.User1.Student;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private PasswordField passPF;
    @javafx.fxml.FXML
    private ComboBox<String> deptCB;

    @javafx.fxml.FXML
    public void initialize() {
        deptCB.getItems().addAll("CSE", "EEE", "MB", "BI") ;
    }

    @javafx.fxml.FXML
    public void creaateAccountOA(ActionEvent actionEvent) {
        String name, email, pN, password, dept ;
        name = nameTF.getText() ;
        email = emailTF.getText() ;
        pN = pNTF.getText() ;
        password = passPF.getText() ;
        dept = deptCB.getValue() ;

        Student student = new Student(name, password, email, pN, "Student", dept) ;

        outputL.setText(student.toString());

    }
}