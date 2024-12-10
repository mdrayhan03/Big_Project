package mainpkg.project.Rayhan.User2;

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

    Faculty user ;

    public void setter(Faculty faculty) {
        this.user = faculty ;
        userNameL.setText(this.user.getName());
        dateL.setText(LocalDate.now().toString());
    }

    @javafx.fxml.FXML
    public void initialize() {
    }}