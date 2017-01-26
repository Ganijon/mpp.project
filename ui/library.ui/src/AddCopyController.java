
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddCopyController {

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        // todo:  logic
        Views.showHome(stage, this);
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showHome(stage, this);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
}
