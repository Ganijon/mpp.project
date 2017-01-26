
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Pane pLibPane;

    @FXML
    private Pane pAdminPane;
    
    @FXML
    private void handleMember (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMemberScreen.fxml"));
                Parent root = (Parent) loader.load();
                AddMemberController controller = loader.getController();
                controller.setStage(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void handlebook (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBookScreen.fxml"));
                Parent root = (Parent) loader.load();
                AddBookController controller = loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    @FXML
    private void handlecopy (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCopyScreen.fxml"));
                Parent root = (Parent) loader.load();
                AddCopyController controller = loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    @FXML
    private void handleCheckoutBook (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMemberScreen.fxml"));
                Parent root = (Parent) loader.load();
                HomeController controller = loader.getController();
                controller.setStage(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    @FXML
    private void handleCheckoutPrint (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PrintCheckoutScreen.fxml"));
                Parent root = (Parent) loader.load();
                PrintCheckoutController controller = loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    @FXML
    private void handleOverdue (ActionEvent event){
         try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMemberScreen.fxml"));
                Parent root = (Parent) loader.load();
                OverdueController controller = loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public void setUserAccount(UserAccount ua) {
        this.userAccount = ua;

        if (userAccount.getAccess() == Access.Admin) {
            pLibPane.setVisible(false);
        } else if (userAccount.getAccess() == Access.Librarian) {
            pAdminPane.setVisible(false);
        } else if (userAccount.getAccess() == Access.Both) {
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
    private UserAccount userAccount;
}
