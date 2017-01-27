package controller;

import dao.BookDao;
import model.Address;
import model.Book;
import model.Author;
import app.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfAuthors;

    @FXML
    private Label lNoOfCopies;

    @FXML
    private RadioButton rb7days;

    @FXML
    private RadioButton rb21days;

    @FXML
    public void handleCancelAction(ActionEvent event) {
        Views.showWelcome(stage);
    }

    @FXML
    public void handleSubmitAction(ActionEvent event) {
        Book b = new Book(tfTitle.getText(), tfISBN.getText(), rb7days.isSelected() ? 7 : 21);
        b.addAuthor(new Author(tfAuthors.getText(), "", "", new Address("", "", "", ""), true, ""));

        BookDao dao = new BookDao();
        boolean added = dao.add(b);
        if (added) {
            Views.showSuccessAlert("Data saved successfully");
        } else {
            Views.showErrorAlert("Error while saving data");
        }
        Views.showWelcome(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
}
