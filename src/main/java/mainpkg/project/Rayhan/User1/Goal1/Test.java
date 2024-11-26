package mainpkg.project.Rayhan.User1.Goal1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Test
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void onaction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/project/Rayhan/User1/Goal2/test2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}