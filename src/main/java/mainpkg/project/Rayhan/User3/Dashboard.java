package mainpkg.project.Rayhan.User3;

import javafx.scene.control.Label;

import java.time.LocalDate;

public class Dashboard
{
    @javafx.fxml.FXML
    private Label dateL;
    @javafx.fxml.FXML
    private Label userNameL;
    @javafx.fxml.FXML
    private Label userTypeL;

    Admin user ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setter(Admin user) {
        this.user = user ;
        userNameL.setText(this.user.getName());
        dateL.setText(LocalDate.now().toString());
    }
}