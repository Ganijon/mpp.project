
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCopyController {

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfAuthors;

    @FXML
    private TextField tfNoOfCopies;

    private Book model;

    @FXML
    private void handleFindBookAction(ActionEvent e) {

        String ISBN = tfISBN.getText();
        model = new BookDao().find(ISBN);

        if (model == null) {
            tfTitle.setText(null);
            tfAuthors.setText(null);
            tfNoOfCopies.setText(null);
            Views.showErrorAlert("Book not found");

        } else {
            tfTitle.setText(model.getTitle());
            tfAuthors.setText(model.getAuthors());
            tfNoOfCopies.setText(Integer.toString(model.getBookCopies().size()));
        }
    }

    @FXML
    private void handleAddOneAction(ActionEvent e) {
        if (model != null) {
            model.addBookCopy();
            tfNoOfCopies.setText(Integer.toString(model.getBookCopies().size()));
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        if (model != null) {
            boolean ok = new BookDao().update(model);
            if (!ok) {
                Views.showErrorAlert("Error while saving data");
            } else {
                Views.showSuccessAlert("Data updated successfully");
                Views.showWelcome(stage, this);
            }
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showWelcome(stage, this);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
}
