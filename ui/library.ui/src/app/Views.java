package app;

import controller.CheckoutController;
import controller.AddCopyController;
import controller.WelcomeController;
import controller.OverdueController;
import controller.PrintCheckoutController;
import controller.AddMemberController;
import controller.LoginController;
import controller.AddBookController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Views {

    private static final String PATH = "/view/";

    public static void showLogin(Stage stage) {
        try {

            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "LoginView.fxml"));

            Parent root = (Parent) loader.load();
            LoginController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showWelcome(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "WelcomeView.fxml"));
            Parent root = (Parent) loader.load();
            WelcomeController controller = loader.getController();
            controller.setStage(stage);
            controller.adjustLayout();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddMember(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddMemberView.fxml"));
            Parent root = (Parent) loader.load();
            AddMemberController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddBook(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddBookView.fxml"));
            Parent root = (Parent) loader.load();
            AddBookController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddBookCopy(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddCopyView.fxml"));
            Parent root = (Parent) loader.load();
            AddCopyController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showCheckout(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "CheckoutView.fxml"));
            Parent root = (Parent) loader.load();
            CheckoutController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showPrintCheckout(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "PrintCheckoutView.fxml"));
            Parent root = (Parent) loader.load();
            PrintCheckoutController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showOverdue(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "OverdueView.fxml"));
            Parent root = (Parent) loader.load();
            OverdueController controller = loader.getController();
            controller.setStage(stage);
            controller.adjustLayout();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
