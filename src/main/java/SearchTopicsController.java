import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
public class SearchTopicsController {

        @FXML
        TextField searchtop;
        @FXML
        TextField result;


        public void searchtopic(){
            SearchTopics object = new SearchTopics();
            //object.getFileList("C:\\Users\\Alexandra\\Desktop\\TOPICS",searchtop.getText());
            object.search(searchtop.getText());
            if(searchtop.getText().isEmpty()){
                result.setText("No topic found!");
                return;
            }

            else{
                result.setText("Topic Found!");
            }


        }



    }


