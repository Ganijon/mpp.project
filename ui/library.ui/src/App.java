
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UTILITY);
        Views.showLogin(stage, this);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
