
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMemberController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfStreet;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfZip;

    @FXML
    public void handleSubmitAction(ActionEvent event) {

        Member m = new Member(tfFirstName.getText(), tfLastName.getText(), tfPhone.getText(), new Address(tfStreet.getText(), tfCity.getText(), tfState.getText(), tfZip.getText()));

        // store m to file.
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            Parent root = (Parent) loader.load();
            HomeController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void handleCancelAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            Parent root = (Parent) loader.load();
            HomeController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private Stage stage;
}
