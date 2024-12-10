package mainpkg.project.Rayhan.User2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import mainpkg.project.Rayhan.User2.Dashboard;

import java.io.IOException;

public class FacultyDashboardController
{
    @javafx.fxml.FXML
    private BorderPane facultyBP;

    Faculty user ;

    public void setter(Faculty faculty) throws IOException {
        this.user = faculty ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User2/Dashboard.fxml"));
        Node node = fxmlLoader.load() ;
        Dashboard dc = fxmlLoader.getController() ;
        dc.setter(user);
        facultyBP.setCenter(node);
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User2/Dashboard.fxml"));
        Node node = fxmlLoader.load() ;
        Dashboard dc = fxmlLoader.getController() ;
        dc.setter(user);
        facultyBP.setCenter(node);
    }

    @javafx.fxml.FXML
    public void newCourseOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User2/NewCourse.fxml"));
        Node node = fxmlLoader.load() ;
        NewCourseController ncc = fxmlLoader.getController() ;
        ncc.setter(user);
        facultyBP.setCenter(node);
    }
}