
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
            tfNoOfCopies.setText(Integer.toString(getAvailableCopies().size()));
        }
    }

    public boolean checkoutFirstAvailableCopy() {
        for (BookCopy copy : model.getBookCopies()) {
            if (copy.isAvailable()) {
                copy.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    private List<BookCopy> getAvailableCopies() {
        List<BookCopy> list = new ArrayList<>();
        for (BookCopy copy : model.getBookCopies()) {
            if (copy.isAvailable()) {
                list.add(copy);
            }
        }
        return list;
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {

        List<BookCopy> availableCopies = getAvailableCopies();
        if (availableCopies.size() < 1) {
            Views.showErrorAlert("No copies available");
            return;
        }

        int memberId = Integer.parseInt(tfMemberId.getText());
        Member foundMember = new MemberDao().find(memberId);
        if (foundMember == null) {
            Views.showErrorAlert("Member not found");
            return;
        }

        CheckoutRecordDao checkoutDao = new CheckoutRecordDao();
        CheckoutRecord record = checkoutDao.find(memberId);

        LocalDate dueDate = LocalDate.now().plusDays(-1);//model.getIssueLength());
        BookCopy availableCopy = availableCopies.get(0);
        CheckoutEntry entry = new CheckoutEntry(LocalDate.now(), dueDate,
                model.getISBN(), availableCopy.getBookCopyId(), memberId);

        boolean ok;
        if (record == null) {
            record = new CheckoutRecord(memberId);
            record.getCheckouts().add(entry);
            ok = checkoutDao.add(record);

        } else {
            record.getCheckouts().add(entry);
            ok = checkoutDao.update(record);
        }

        ok = ok && checkoutFirstAvailableCopy()
                && new BookDao().update(model);

        if (!ok) {
            Views.showErrorAlert("Error while checkout book");
        } else {
            Views.showSuccessAlert("Checkout complete");
            Views.showWelcome(stage, this);
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
