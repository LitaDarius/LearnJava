import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
public class SearchTopicsController implements Initializable{

        @FXML
        public TextField searchtop;
        @FXML
       public TextField result;
        @FXML
        ComboBox hello;


        public void searchtopic(){
            SearchTopics object = new SearchTopics();
            object.search(searchtop.getText());
            if(searchtop.getText().isEmpty()){
                result.setText("No topic found!");
                return;
            }

            else{
                result.setText("Topic Found!");
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



    }


