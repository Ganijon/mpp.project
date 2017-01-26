
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OverdueController {

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfTitle;

    @FXML
    private TableView tvOverdueCopies;

    private Book model;

    @FXML
    private void handleFindOverdueCopies(ActionEvent e) {
        String ISBN = tfISBN.getText();
        BookDao dao = new BookDao();
        model = dao.find(ISBN);
        
       if (model == null) {
            tfTitle.setText(null);
            Views.showErrorAlert("Book not found");

        } else {
            tfTitle.setText(model.getTitle());
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        // todo: checkout logic
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

    private class OverdueBook {

        private int bookCopyId;
        private boolean isAvailable;
        private LocalDate dueDate;
        private int memberId;

        public OverdueBook(int bookCopyId, boolean isAvailable, LocalDate dueDate, int memberId) {
            this.bookCopyId = bookCopyId;
            this.isAvailable = isAvailable;
            this.dueDate = dueDate;
            this.memberId = memberId;
        }
    }
}
