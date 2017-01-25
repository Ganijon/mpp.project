
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lblError;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        UserAccount user = UserAccounts.GetUserAccount(tfUserName.getText(), tfPassword.getText());

        if (user == null) {
            lblError.setText("Incorrect User Name or Password");
            return;
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
                Parent root = (Parent) loader.load();

                System.out.println("loader.load() is done!");
                HomeController controller = loader.getController();

                System.out.println("loader.getController() is done!");
                controller.setStage(stage);
                                System.out.println("loader.setStage() is done!");
                controller.setUserAccount(user);
                System.out.println("loader.setUserAccount() is done!");


                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblError.setText("");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private Stage stage;
}
