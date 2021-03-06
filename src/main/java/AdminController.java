import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField topic_name;
    @FXML
    private ComboBox existent_topics;
    @FXML
    private Text user_info;
    @FXML
    private TextField userf;
    @FXML
    private Text login_number;

    public void addTopic(){
        File f=new File("topics/" +topic_name.getText());
        f.mkdir();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File folder=new File("topics");

        for ( File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                existent_topics.getItems().add(fileEntry.getName());    //add items to comboBox
            }
        }
        int nrOfLogins=DateHandle.getLogins();
        //System.out.println(nrOfLogins);
        login_number.setText("Number of logins:"+nrOfLogins);
    }

    public void delTopic(){
        File f=new File("topics/" +existent_topics.getValue().toString());
        if(f.delete())
             System.out.println(existent_topics.getValue()+" was deleted");
        else
            System.out.println("file could not be deleted. It needs to be empty");
    }

    public void showUserInfo(){
        if(HandleJSON.checkIfUserExists(userf.getText())){
            user_info.setText("name:"+userf.getText()+"  type:"+HandleJSON.giveUserType(userf.getText())+"  tests:"+HandleJSON.giveUserTests(userf.getText()));
        }else{
            user_info.setText("user not found");
        }

    }

    public void logout(ActionEvent actionEvent){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("LoginStage.fxml"));
            root=l.load();

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
