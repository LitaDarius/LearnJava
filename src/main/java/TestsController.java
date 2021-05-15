import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.awt.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TestsController implements Initializable {

    @FXML
    private Text name;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private Label result_label;

    private VBox v;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         v=new VBox();
         File f=new File("categories");
         String s="";




         if(!f.exists()){
             System.out.println("file not found");
         }
         listFilesForFolder(f,s,v);

        int i;
       /* for(i=0;i<100;i++){
            v.getChildren().add(new Button(i+""));
        }*/

        scroll_pane.setContent(v);
    }

    public void listFilesForFolder(final File folder,String path,VBox v) {

        path=path+"/";
        path=path+folder.getName();
        for ( File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry,path,v);
            } else {
                Button b=new Button(path+"/"+fileEntry.getName());
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        int res=TestFrame.start(fileEntry,name.getText());
                        result_label.setText("correct answers: "+res);
                        //label.setText("Accepted");
                    }
                });
                v.getChildren().add(b);
                //System.out.println(path+"/"+fileEntry.getName());
            }
        }
    }



    public void goHome(javafx.event.ActionEvent actionEvent) {
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("home.fxml"));
            root=l.load();
            HomeController h=l.getController();
          //  System.out.println(name.getText());
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

    public void getToStats(ActionEvent actionEvent){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("Stats.fxml"));
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

    public void getName(String n){
        name.setText(n);
    }
}
