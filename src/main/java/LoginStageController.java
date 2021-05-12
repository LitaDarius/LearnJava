import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


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

    public void tryLogin(ActionEvent actionEvent){
        //HandleJSON.checkIfUserExists(name_field.getText());
        //error_field.setText(HandleJSON.addUser(name_field.getText(),PasswordHandler.getHashedPassword(password_field.getText(),name_field.getText()))+"");
       // System.out.println(name_field.getText()+" "+password_field.getText()+" "+PasswordHandler.getHashedPassword(name_field.getText(),password_field.getText()));
        if(HandleJSON.checkUserAndPass(name_field.getText(),PasswordHandler.getHashedPassword(name_field.getText(),password_field.getText()))){
            //error_field.setText("true");

            Parent root = null;
            try {
                FXMLLoader l = new FXMLLoader(getClass().getResource("home.fxml"));
                root=l.load();
                HomeController h=l.getController();
                System.out.println(name_field.getText());
                h.getName(name_field.getText());
            } catch (IOException e) {
                System.out.println("missing files");
                e.printStackTrace();
                System.exit(0);
            }
            Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene nextStage=new Scene(root);
            thisStage.setScene(nextStage);

        }
        else error_field.setText("failed to login");

    }


    public void register(ActionEvent actionEvent){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("register.fxml"));
            root=l.load();
            RegisterController reg=l.getController();
            reg.getScene(error_field.getScene());

        } catch (IOException e) {
            System.out.println("missing files");
            e.printStackTrace();
            System.exit(0);
        }
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene nextStage=new Scene(root);

        thisStage.setScene(nextStage);

    }
}