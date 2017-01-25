
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Pane pLibPane;

    @FXML
    private Pane pAdminPane;

    public void setUserAccount(UserAccount ua) {
        this.userAccount = ua;

        if (userAccount.getAccess() == Access.Admin) {
            pLibPane.setVisible(false);
        } else if (userAccount.getAccess() == Access.Librarian) {
            pAdminPane.setVisible(false);
        } else if (userAccount.getAccess() == Access.Both) {
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
    private UserAccount userAccount;
}
