package controller;

import dao.MemberDao;
import dao.CheckoutRecordDao;
import dao.BookDao;
import entity.Book;
import entity.CheckoutRecord;
import entity.BookCopy;
import entity.CheckoutEntry;
import app.Views;
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

    public BookCopy checkoutAvailableCopy() {
        for (BookCopy copy : model.getBookCopies()) {
            if (copy.isAvailable()) {
                copy.setAvailable(false);
                return copy;
            }
        }
        return null;
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

        String memberId = tfMemberId.getText();
        if (null == new MemberDao().find(memberId)) {
            Views.showErrorAlert("Member not found");
            return;
        }

        CheckoutRecordDao checkoutDao = new CheckoutRecordDao();

        CheckoutRecord record = checkoutDao.find(memberId);

        BookCopy checkoutCopy = checkoutAvailableCopy();

        LocalDate dueDate = LocalDate.now().plusDays(-1);//model.getIssueLength());

        CheckoutEntry entry = new CheckoutEntry(LocalDate.now(), dueDate,
                model.getISBN(), checkoutCopy.getBookCopyId(), memberId);

        boolean ok;
        if (record == null) {
            record = new CheckoutRecord(memberId);
            record.getCheckouts().add(entry);
            ok = checkoutDao.add(record);

        } else {
            record.getCheckouts().add(entry);
            ok = checkoutDao.update(record);
        }

        if (ok) {
            ok = new BookDao().update(model);
        }

        if (!ok) {
            Views.showErrorAlert("Error while checkout book");
        } else {
            Views.showSuccessAlert("Checkout complete");
            Views.showWelcome(stage);
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showWelcome(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
}
