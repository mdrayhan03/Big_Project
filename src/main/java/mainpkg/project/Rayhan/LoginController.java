package mainpkg.project.Rayhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.project.Rayhan.User1.Student;
import mainpkg.project.Rayhan.User2.Faculty;
import mainpkg.project.Rayhan.User3.Admin;
import mainpkg.project.Rayhan.User3.AdminDashboardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField idTF;

    ArrayList<Admin> adminArrayList = new ArrayList<>() ;
    ArrayList<Student> studentArrayList ;
    ArrayList<Faculty> facultyArrayList ;

    @javafx.fxml.FXML
    public void initialize() {
        Admin a = new Admin("Admin", "1234", "admin@gmail.com", "01234567890", "admin") ;
        adminArrayList.add(a) ;
        System.out.println(a);
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/CreateAccount.fxml"));
        root = fxmlLoader.load() ;
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) throws IOException {
        String id, password ;
        id = idTF.getText() ;
        password = passwordPF.getText() ;

        if (Objects.equals(id, "admin")) {
            for (Admin admin : adminArrayList) {
                if (admin.loginVR(id, password)) {
                    Parent root = null ;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User3/AdminDashboard.fxml"));
                    root = fxmlLoader.load() ;

                    AdminDashboardController adc = fxmlLoader.getController() ;
                    adc.setter(admin);

                    Scene scene = new Scene(root) ;
                    Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setScene(scene);
                    stage.show();
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