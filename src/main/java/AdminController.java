import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField topic_name;
    @FXML
    private ComboBox existent_topics;
    @FXML
    private TextField userf;
    @FXML
    private TextField userfound;

    public void addTopic(){
        File f=new File("topics/"+topic_name.getText());
        f.mkdir();
    }
    public void searchC(){
        SearchClient o=new SearchClient();
        o.checkifExists(userf.getText());
        if(userf.getText().isEmpty()){
            userfound.setText("No user found!");
            return;
        }
        else if(SearchClient.checkifExists(userf.getText()))
        {
            userfound.setText("User found: "+userf.getText()+";  role:   "+HandleJSON.giveUserType(userf.getText())+ ";  Tests:"+HandleJSON.giveUserTests(userf.getText()));
            return;
        }
        else{
            userfound.setText("No user found!");
            return;

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File folder=new File("topics");
    }
}
