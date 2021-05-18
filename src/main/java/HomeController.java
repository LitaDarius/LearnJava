import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Text name;

    public void getToTests(ActionEvent actionEvent){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("test.fxml"));
            root=l.load();
            TestsController t=l.getController();
            t.getName(name.getText());
            t.giveController(t);
        } catch (IOException e) {
            System.out.println("missing files");
            e.printStackTrace();
            System.exit(0);
        }
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene nextStage=new Scene(root);

        thisStage.setScene(nextStage);

    }

    public void getToStats(ActionEvent actionEvent){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("stats.fxml"));
            root=l.load();
            StatsController t=l.getController();
            t.getName(name.getText());
        } catch (IOException e) {
            System.out.println("missing files");
            e.printStackTrace();
            System.exit(0);
        }
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene nextStage=new Scene(root);

        thisStage.setScene(nextStage);

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


    public void feedback(){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("feed.fxml"));
            root=l.load();

        } catch (IOException e) {
            System.out.println("missing files");
            e.printStackTrace();
            System.exit(0);
        }

        Scene scene=new Scene(root);
        Stage t=new Stage();
        t.setScene(scene);
        t.show();
    }

    public void getName(String n){
        name.setText(n);
    }
}
