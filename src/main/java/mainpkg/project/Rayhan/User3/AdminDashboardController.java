package mainpkg.project.Rayhan.User3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController
{
    @javafx.fxml.FXML
    private BorderPane adminDashboardBP;

    Admin user ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void getter() {

    }

    public void setter(Admin user) throws IOException {
        this.user = user ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User3/Dashboard.fxml"));
        Node node = fxmlLoader.load() ;
        Dashboard dc = fxmlLoader.getController() ;
        dc.setter(user);
        adminDashboardBP.setCenter(node);
    }

    @javafx.fxml.FXML
    public void signoutOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createCourseOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addFacultyOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void profileOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void appliedVacationOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User3/Dashboard.fxml"));
        Node node = fxmlLoader.load() ;
        Dashboard dc = fxmlLoader.getController() ;
        dc.setter(user);
        adminDashboardBP.setCenter(node);
    }
}