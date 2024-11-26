package mainpkg.project.Rayhan;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainpkg.project.Rayhan.User1.Student;
import mainpkg.project.Rayhan.User2.Faculty;
import mainpkg.project.Rayhan.User3.Admin;

import java.util.ArrayList;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField idTF;

    ArrayList<Admin> adminArrayList ;
    ArrayList<Student> studentArrayList ;
    ArrayList<Faculty> facultyArrayList ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) {
        String id, password ;
        id = idTF.getText() ;
        password = passwordPF.getText() ;

        if (id == "admin") {
            for (Admin admin : adminArrayList) {
                if (admin.loginVR(id, password)) {
                    System.out.println("Admin login successfull");
                    break;
                }
            }
        }
        else if (id.length() == 7) {
            for (Student student: studentArrayList) {
                if (student.loginVR(id, password)) {
                    System.out.println("Student login uccessfull");
                    break;
                }
            }
        }
        else if (id.length() == 4) {
            for (Faculty faculty: facultyArrayList) {
                if (faculty.loginVR(id, password)) {
                    System.out.println("Faculty login uccessfull");
                    break;
                }
            }
        }
    }
}