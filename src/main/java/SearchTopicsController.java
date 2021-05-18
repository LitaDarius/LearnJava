import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SearchTopicsController implements Initializable{

    @FXML
    public TextField searchtop;
    @FXML
    public TextField result;
    @FXML
    ComboBox hello;

    public TestsController testul;


    public void searchtopic(){
        SearchTopics object = new SearchTopics();
        object.search(searchtop.getText());
        if(searchtop.getText().isEmpty()){
            result.setText("No topic found!");
            return;
        }
        else if(SearchTopics.search(searchtop.getText())){
            hello.getItems().clear();
            File folder = new File("topics");
            for(File fileEntry:folder.listFiles()){
                if(fileEntry.isDirectory()&&fileEntry.getName().contains(searchtop.getText())){
                    hello.getItems().add(fileEntry.getName());//add to combobox
                }
            }
        }
        else{
            result.setText("No topic found!");
        }



    }

  



    @Override
    public void initialize(URL location,ResourceBundle resources){
        File folder = new File("topics");
        for(File fileEntry:folder.listFiles()){
            if(fileEntry.isDirectory()){
                hello.getItems().add(fileEntry.getName());//add to combobox
            }
        }
    }

    public void getController(TestsController t){
        testul=t;
    }


    public void sendTest(javafx.event.ActionEvent actionEvent) {
        testul.setupTests(hello.getValue().toString());
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        thisStage.close();
    }
}


