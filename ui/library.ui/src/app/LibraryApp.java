package app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LibraryApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UTILITY);
        Views.showLogin(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
