import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatsController  {
    @FXML
    private Text name;
    @FXML
    private ScrollPane scroll_pane;

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

    public void goHome(javafx.event.ActionEvent actionEvent) {
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("home.fxml"));
            root=l.load();
            HomeController h=l.getController();
           // System.out.println(name.getText());
            h.getName(name.getText());
        } catch (IOException e) {
            System.out.println("missing files");
            e.printStackTrace();
            System.exit(0);
        }
        Stage thisStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene nextStage=new Scene(root);
        thisStage.setScene(nextStage);
    }

    public void getName(String n){
        name.setText(n);
        VBox v=new VBox();
        Label name_label=new Label("Name:"+name.getText());
        name_label.setFont(new Font("Arial",30));

        Label type_label=new Label("Type: "+HandleJSON.giveUserType(name.getText()));
        type_label.setFont(new Font("Arial",30));

        Label tests_label=new Label("Tests: "+HandleJSON.giveUserTests(name.getText()));
        tests_label.setFont(new Font("Arial",30));



        v.getChildren().addAll(name_label,type_label,tests_label);

        // HandleJSON.giveUserInfo(name.getText(),v);
        // v.getChildren().add(new Label("ceva"));
        scroll_pane.setContent(v);
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
