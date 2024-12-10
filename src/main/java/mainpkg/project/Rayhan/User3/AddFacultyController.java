package mainpkg.project.Rayhan.User3;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.project.Rayhan.User2.Faculty;

import java.time.LocalDate;

public class AddFacultyController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> genderTC;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> nameTC;
    @javafx.fxml.FXML
    private TableView<Faculty> facultyTV;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private ComboBox<String> deptCB;
    @javafx.fxml.FXML
    private TableColumn<Faculty, LocalDate> dobTC;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> emailTC;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> pNTC;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> idTC;
    @javafx.fxml.FXML
    private TableColumn<Faculty, LocalDate> dojTC;
    @javafx.fxml.FXML
    private TableColumn<Faculty, String> deptTC;
    @javafx.fxml.FXML
    private DatePicker dojDP;
    @javafx.fxml.FXML
    private ToggleGroup tg;
    @javafx.fxml.FXML
    private PasswordField passwordPW;

    Admin user ;
    ObservableList<Faculty> faculties ;

    public void  setter (Admin user) {
        this.user = user ;
        showTable();
    }

    @javafx.fxml.FXML
    public void initialize() {
        deptCB.getItems().addAll("CSE", "EEE", "MIS", "BT", "BBA", "PHY") ;
        dojDP.setValue(LocalDate.now());

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        pNTC.setCellValueFactory(new PropertyValueFactory<>("phone"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        deptTC.setCellValueFactory(new PropertyValueFactory<>("department"));
        dobTC.setCellValueFactory(new PropertyValueFactory<>("dob"));
        dojTC.setCellValueFactory(new PropertyValueFactory<>("doj"));
    }

    @javafx.fxml.FXML
    public void addFacultyOA(ActionEvent actionEvent) {
        String name, email, pN, gender = "", dept, password ;
        LocalDate dob, doj ;

        name = nameTF.getText() ;
        email = emailTF.getText() ;
        pN = pNTF.getText() ;
        password = passwordPW.getText() ;

        if (maleRB.isSelected()) {
            gender = "Male" ;
        }
        else if (femaleRB.isSelected()) {
            gender = "Female" ;
        }

        dept = deptCB.getValue() ;

        dob = dobDP.getValue() ;
        doj = dojDP.getValue() ;

        user.addFaculty(name, password, email, pN, "Faculty", dept, gender, dob, doj);
        showTable();
    }

    public void showTable() {
        faculties = this.user.facultyFileRead() ;
        facultyTV.setItems(faculties);
    }
}