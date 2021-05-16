import javafx.collections.ObservableArray;
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

    public void addTopic(){
        File f=new File("topics/"+topic_name.getText());
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
    }

    public void delTopic(){
        File f=new File("topics/"+existent_topics.getValue().toString());
        if(f.delete())
             System.out.println(existent_topics.getValue()+" was deleted");
        else
            System.out.println("file could not be deleted. It needs to be empty");
    }
}
