
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrintCheckoutController {

    @FXML
    private TextField tfMemberId;

    @FXML
    private TextArea taRecords;

    private CheckoutRecord model;

    @FXML
    private void handleFindRecords(ActionEvent e) {

        int memberId = Integer.parseInt(tfMemberId.getText());
        model = new CheckoutRecordDao().find(memberId);
        if (model == null) {
            taRecords.setText("No records were found. Try another Member ID.");
        } else {
            taRecords.setText("Checkout History:\n" + model.toString());
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        if (model == null) {
            Views.showErrorAlert("No records were found");
        } else {
            System.out.print("CHECKOUT HISTORY: " + model);
            Views.showSuccessAlert("Following was sent to Console: \nCHECKOUT HISTORY:" + model);
            Views.showWelcome(stage, this);
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showWelcome(stage, this);
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
}
