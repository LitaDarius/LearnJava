import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController {

    private Scene loginScene;

    @FXML
    private Text error_field;

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField password_field1;

    @FXML
    private PasswordField password_field2;

    @FXML
    private PasswordField admin_field;

    public void register(){
        if(name_field.getText().isEmpty()){
            error_field.setText("no name was found");
            return;
        }
        if(HandleJSON.checkIfUserExists(name_field.getText())){
            error_field.setText("user already exists");
            return;
        }
        if(!password_field1.getText().equals(password_field2.getText())){
            error_field.setText("passwords do not mach");
            return;
        }
        if(admin_field.getText().isEmpty()){
            if(HandleJSON.addUser(name_field.getText(),PasswordHandler.getHashedPassword(name_field.getText(),password_field1.getText()),"user")){
                error_field.setText("user added successfully");
            }
            else
                error_field.setText("an error occurred");
        }


    }
    public void goBack(ActionEvent actionEvent){


        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        thisStage.setScene(loginScene);
    }

    public void getScene(Scene s){
        loginScene=s;
    }
}
