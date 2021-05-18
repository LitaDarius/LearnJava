import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FeedbackController {
    @FXML
    TextField feed;
    @FXML
    TextField namef;

    public void sendFeedback(ActionEvent actionEvent) {
        FeedbackMethod object = new FeedbackMethod();
        object.write(namef.getText(), feed.getText());
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        thisStage.close();
    }


}
