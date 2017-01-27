package controller;


import app.Views;
import app.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WelcomeController {

    @FXML
    private Label lTitle;

    @FXML
    private Pane pLibPane;

    @FXML
    private Pane pAdminPane;

    @FXML
    private void handleLogout(ActionEvent event) {
        UserContext.Logout();
        Views.showLogin(stage);
    }

    @FXML
    private void handleAddMember(ActionEvent event) {
        Views.showAddMember(stage);
    }

    @FXML
    private void handleAddBook(ActionEvent event) {
        Views.showAddBook(stage);
    }

    @FXML
    private void handleAddBookCopy(ActionEvent event) {
        Views.showAddBookCopy(stage);
    }

    @FXML
    private void handleCheckoutBook(ActionEvent event) {
        Views.showCheckoutBook(stage);
    }

    @FXML
    private void handlePrintCheckout(ActionEvent event) {
        Views.showPrintCheckout(stage);
    }

    @FXML
    private void handleOverdue(ActionEvent event) {
        Views.showOverdue(stage);
    }

    public void adjustLayout() {
        switch (UserContext.getAccess()) {
            case Admin:
                pLibPane.setVisible(false);
                pAdminPane.setLayoutX(114);
                lTitle.setText("Welcome, Administrator");
                break;
            case Librarian:
                pAdminPane.setVisible(false);
                pLibPane.setLayoutX(114);
                lTitle.setText("Welcome, Librarian");
                break;
            case Both:
                lTitle.setText("Welcome");
                break;
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

}
