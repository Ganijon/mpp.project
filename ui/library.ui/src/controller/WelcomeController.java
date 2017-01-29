package controller;


import app.Views;
import app.UserAccounts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class WelcomeController {

    @FXML
    private Label lTitle;

    @FXML
    private Pane pLibPane;

    @FXML
    private Pane pAdminPane;

    @FXML
    private void handleLogout(ActionEvent event) {
        UserAccounts.Logout();
        Views.showLogin();
    }

    @FXML
    private void handleAddMember(ActionEvent event) {
        Views.showAddMember();
    }

    @FXML
    private void handleAddBook(ActionEvent event) {
        Views.showAddBook();
    }

    @FXML
    private void handleAddBookCopy(ActionEvent event) {
        Views.showAddBookCopy();
    }

    @FXML
    private void handleCheckoutBook(ActionEvent event) {
        Views.showCheckout();
    }

    @FXML
    private void handlePrintCheckout(ActionEvent event) {
        Views.showPrintCheckout();
    }

    @FXML
    private void handleOverdue(ActionEvent event) {
        Views.showOverdue();
    }

    public void adjustLayout() {
        switch (UserAccounts.getAccess()) {
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
}
