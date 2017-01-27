
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMemberController {

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

        Member newMember = new Member(tfFirstName.getText(), tfLastName.getText(),
                tfPhone.getText(), new Address(tfStreet.getText(),
                tfCity.getText(), tfState.getText(), tfZip.getText()));

        MemberDao dao = new MemberDao();
        boolean added = dao.add(newMember);

        if (added) {
            Views.showSuccessAlert("Data saved successfully");
        } else {
            Views.showErrorAlert("Error while saving data");
        }

        Views.showWelcome(stage, this);
    }

    @FXML
    public void handleCancelAction(ActionEvent event) {
        Views.showWelcome(stage, this);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private Stage stage;
}
