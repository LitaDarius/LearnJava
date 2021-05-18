import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FeedbackController {
    @FXML
    TextField feed;
    @FXML
    TextField namef;

    public void sendFeedback() {
        FeedbackMethod object = new FeedbackMethod();
        object.write(namef.getText(), feed.getText());

    }


}
