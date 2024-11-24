module mainpkg.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.project to javafx.fxml;
    exports mainpkg.project;
}