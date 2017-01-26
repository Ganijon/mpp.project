

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void handlecancel(ActionEvent event){
        
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
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
    
    private Book b;
    private BookCopy copy;
    @FXML 
    private TextField tfTitle;
    
    @FXML 
    private TextField tfISBN;
    
   
    
    @FXML
    public void handlesubmit(ActionEvent event){
        copy = new BookCopy();
        b = new Book(tfTitle.getText(), tfISBN.getText(),7,copy);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
    private UserAccount userAccount;
}
