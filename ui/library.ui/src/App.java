
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("library/ui/login/LoginScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/home/HomeScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/addbook/AddBookScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/addcopy/AddCopyScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/addmember/AddMemberScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/overdue/OverdueScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("library/ui/printcheckout/PrintCheckoutScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
