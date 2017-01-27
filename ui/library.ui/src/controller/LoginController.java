package controller;


import app.Views;
import app.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lblError;

    @FXML
    private void handleLoginAction(ActionEvent event) {

        if (UserContext.Login(tfUserName.getText(), tfPassword.getText()) == false) {
            lblError.setText("Incorrect User Name or Password");
            return;
        } else {
           Views.showWelcome(stage);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private Stage stage;
}
