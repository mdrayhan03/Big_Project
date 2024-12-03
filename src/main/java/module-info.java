module mainpkg.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.project to javafx.fxml;
    opens mainpkg.project.Rayhan to javafx.fxml ;
    opens mainpkg.project.Rayhan.User1 to javafx.fxml ;
    opens mainpkg.project.Rayhan.User2 to javafx.fxml ;
    opens mainpkg.project.Rayhan.User3 to javafx.fxml ;
    opens mainpkg.project.Rayhan.User1.Goal1 to javafx.fxml;
    opens mainpkg.project.Rayhan.User1.Goal2 to javafx.fxml;
    exports mainpkg.project;
}