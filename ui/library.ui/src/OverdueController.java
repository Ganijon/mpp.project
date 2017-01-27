
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class OverdueController {

    private Book model;

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfTitle;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn tcISBN;

    @FXML
    private TableColumn tcBookCopyId;

    @FXML
    private TableColumn tcAvailable;

    @FXML
    private TableColumn tcDueDate;

    @FXML
    private TableColumn tcMemberId;

    @FXML
    private void handleFindOverdueCopies(ActionEvent event) {
        String ISBN = tfISBN.getText();
        model = new BookDao().find(ISBN);
        if (model == null) {
            tfISBN.setText(null);
            tfTitle.setText(null);
            tableView.setItems(null);
            Views.showErrorAlert("Book not found");
        } else {
            tfTitle.setText(model.getTitle());
            tableView.setItems(getOverdueBooks());
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        tfISBN.setText(null);
        tfTitle.setText(null);
        tableView.setItems(null);
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showWelcome(stage, this);
    }

    private BookCopy findBookCopy(String bookCopyId) {
        for (BookCopy copy : model.getBookCopies()) {
            if (copy.getBookCopyId().equals(bookCopyId)) {
                return copy;
            }
        }
        return null;
    }

    private ObservableList<OverdueBook> getOverdueBooks() {
        ObservableList<OverdueBook> list = FXCollections.observableArrayList();
        // loop through checkoutrecords to find entries
        // with entered ISBN and DueDate before Today.
        List<CheckoutRecord> allRecords = new CheckoutRecordDao().read();
        for (CheckoutRecord record : allRecords) {
            for (CheckoutEntry entry : record.getCheckouts()) {
                if (entry.getBookISBN().equals(model.getISBN())) {
                    if (entry.getDueDate().isBefore(LocalDate.now())) {
                        BookCopy copy = findBookCopy(entry.getBookCopyId());
                        list.add(new OverdueBook(
                                model.getISBN(),
                                entry.getBookCopyId(),
                                entry.getMemberId(),
                                copy.isAvailable() ? "Yes" : "No",
                                entry.getDueDate().toString()));
                    }
                }
            }
        }
        return list;
    }

    public void adjustLayout() {
        tcISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        tcBookCopyId.setCellValueFactory(new PropertyValueFactory<>("bookCopyId"));
        tcAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        tcDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        tcMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    public class OverdueBook {

        public final SimpleStringProperty ISBN;
        public final SimpleStringProperty bookCopyId;
        public final SimpleStringProperty memberId;
        public final SimpleStringProperty dueDate;
        public final SimpleStringProperty available;

        public OverdueBook(String ISBN, String copyId, String memberId, String available, String dueDate) {
            this.ISBN = new SimpleStringProperty(ISBN);
            this.bookCopyId = new SimpleStringProperty(copyId);
            this.memberId = new SimpleStringProperty(memberId);
            this.available = new SimpleStringProperty(available);
            this.dueDate = new SimpleStringProperty(dueDate);
        }

        public String getISBN() {
            return ISBN.get();
        }

        public void setISBN(String value) {
            this.ISBN.set(value);
        }

        public String getBookCopyId() {
            return bookCopyId.get();
        }

        public void setBookCopyId(String value) {
            this.bookCopyId.set(value);
        }

        public String getMemberId() {
            return memberId.get();
        }

        public void setMemberId(String value) {
            this.memberId.set(value);
        }

        public String getDueDate() {
            return dueDate.get();
        }

        public void setDueDate(String value) {
            this.dueDate.set(value);
        }

        public String getAvailable() {
            return available.get();
        }

        public void setAvailable(String value) {
            this.available.set(value);
        }
    }
}
