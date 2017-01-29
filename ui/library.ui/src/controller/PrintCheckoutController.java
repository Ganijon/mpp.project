package controller;


import dao.CheckoutDao;
import model.Checkout;
import app.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrintCheckoutController {

    @FXML
    private TextField tfMemberId;

    @FXML
    private TextArea taRecords;

    private Checkout model;

    @FXML
    private void handleFindRecords(ActionEvent e) {
        String memberId = tfMemberId.getText();
        model = new CheckoutDao().find(memberId);
        if (model == null) {
            taRecords.setText("No records were found. Try another Member ID.");
        } else {
            taRecords.setText("Checkout History:\n" + model.toString());
        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent e) {
        if (model == null) {
            Views.showErrorAlert("No records were found");
        } else {
            System.out.print("CHECKOUT HISTORY: " + model);
            Views.showSuccessAlert("Following was sent to Console: \nCHECKOUT HISTORY:" + model);
            Views.showWelcome();
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent e) {
        Views.showWelcome();
    }
}
