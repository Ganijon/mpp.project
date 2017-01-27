
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Views {

    public static void showWelcome(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("WelcomeView.fxml"));
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

    public static void showLogin(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("LoginView.fxml"));
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

    public static void showAddMember(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("AddMemberView.fxml"));
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

    public static void showAddBook(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("AddBookView.fxml"));
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

    public static void showAddBookCopy(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("AddCopyView.fxml"));
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

    public static void showCheckoutBook(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("CheckoutBookView.fxml"));
            Parent root = (Parent) loader.load();
            CheckoutBookController controller = loader.getController();
            controller.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showPrintCheckout(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("PrintCheckoutView.fxml"));
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

    public static void showOverdue(Stage stage, Object origin) {
        try {
            FXMLLoader loader = new FXMLLoader(origin.getClass().getResource("OverdueView.fxml"));
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
