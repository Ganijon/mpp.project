package app;

import controller.WelcomeController;
import controller.OverdueController;
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
    private static final Logger LOGGER;
    private static Stage stage;
    
    static {
        LOGGER = Logger.getLogger(Views.class.getName());
    }
    
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
    public static void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "LoginView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showWelcome() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "WelcomeView.fxml"));
            Parent root = (Parent) loader.load();
            WelcomeController controller = loader.getController();
            controller.adjustLayout();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddMember() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddMemberView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddBook() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddBookView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showAddBookCopy() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "AddCopyView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showCheckout() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "CheckoutView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showPrintCheckout() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "PrintCheckoutView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static void showOverdue() {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(PATH + "OverdueView.fxml"));
            Parent root = (Parent) loader.load();
            OverdueController controller = loader.getController();
            controller.adjustLayout();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
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
