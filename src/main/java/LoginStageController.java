import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class LoginStageController {

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Text error_field;

    @FXML
    private Button login_button;

    public LoginStageController(){

    }

    public void tryLogin(){
      error_field.setText("failed to login");
    }

}