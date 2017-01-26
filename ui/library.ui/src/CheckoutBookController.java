
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckoutBookController {

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfAuthors;

    @FXML
    private TextField tfNoOfCopies;

    @FXML
    private TextField tfMemberId;

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
            tfNoOfCopies.setText(Integer.toString(model.getNoOfAvailableCopies()));
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {

        if (model.getNoOfAvailableCopies() == 0) {
            Views.showErrorAlert("No copies available");
        } else {

            int memberId = Integer.parseInt(tfMemberId.getText());
            Member foundMember = new MemberDao().find(memberId);

            if (foundMember == null) {
                Views.showErrorAlert("Member not found");
            } else {
                boolean updated = false;

                CheckoutRecordDao checkoutDao = new CheckoutRecordDao();

                //1. find checkout record by memberId
                CheckoutRecord record = checkoutDao.find(memberId);

                //2. add one checkout entry with checkout date, due date(today+issueLength),
                LocalDate dueDate = LocalDate.now().plusDays(model.getIssueLength());
                CheckoutEntry newEntry = new CheckoutEntry(LocalDate.now(), dueDate, memberId);

                if (record == null) {
                    record = new CheckoutRecord(memberId);
                    record.getCheckouts().add(newEntry);
                    updated = checkoutDao.add(record);

                } else {
                    record.getCheckouts().add(newEntry);
                    updated = checkoutDao.update(record);
                }

                //3. decrementNoOfAvailableCopies
                model.decrementNoOfAvailableCopies();
                updated = updated && (new BookDao().update(model));

                if (!updated) {
                    Views.showErrorAlert("Error while checkout book");
                } else {
                    Views.showSuccessAlert("Checkout complete");
                    Views.showHome(stage, this);
                }
            }
        }

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
