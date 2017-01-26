
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Label lTitle;

    @FXML
    private Pane pLibPane;

    @FXML
    private Pane pAdminPane;

    @FXML
    private void handleAddMember(ActionEvent event) {
        Views.showAddMember(stage, this);
    }

    @FXML
    private void handleAddBook(ActionEvent event) {
       Views.showAddBook(stage, this);
    }

    @FXML
    private void handleAddBookCopy(ActionEvent event) {
       Views.showAddBookCopy(stage, this);
    }

    @FXML
    private void handleCheckoutBook(ActionEvent event) {
       Views.showCheckoutBook(stage, this);
    }

    @FXML
    private void handlePrintCheckout(ActionEvent event) {
        Views.showPrintCheckout(stage, this);
    }

    @FXML
    private void handleOverdue(ActionEvent event) {
        Views.showOverdue(stage, this);
    }

    public void adjustLayout() {
        switch (UserContext.getAccess()) {
            case Admin:
                pLibPane.setVisible(false);
                pAdminPane.setLayoutX(110);
                lTitle.setText("Welcome, Administrator");
                break;
            case Librarian:
                pAdminPane.setVisible(false);
                pLibPane.setLayoutX(110);
                lTitle.setText("Welcome, Librarian");
                break;
            case Both:
                lTitle.setText("Welcome, Almighty");
                break;
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

}
