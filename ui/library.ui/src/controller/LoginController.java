package controller;


import app.Views;
import app.UserAccounts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lblError;

    @FXML
    private void handleLoginAction(ActionEvent event) {

        if (UserAccounts.Login(tfUserName.getText(), tfPassword.getText()) == false) {
            lblError.setText("Incorrect User Name or Password");
        } else {
           Views.showWelcome();
        }
    }
}
