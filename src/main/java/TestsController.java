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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


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

    String tests;
    private TestsController tc;

    public void giveController(TestsController tes){
        tc=tes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTests("");
    }

    public void setupTests(String str){
        v=new VBox();
        File f;
        if(str.isEmpty())
             f=new File("topics");
        else
             f=new File("topics/"+str);
        String s="";




        if(!f.exists()){
            System.out.println("file not found");
        }
        listFilesForFolder(f,s,v);



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
            URL temp=this.getClass().getResource("home.fxml");
           // System.out.println(temp);
            FXMLLoader l = new FXMLLoader(temp);
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
            URL temp=this.getClass().getResource("stats.fxml");
          //  System.out.println(temp);
            FXMLLoader l = new FXMLLoader(temp);
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

    public void openTopics(){
        Parent root = null;
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("searchtop.fxml"));
            root=l.load();

            SearchTopicsController t=l.getController();
           FXMLLoader loader=(FXMLLoader) scroll_pane.getScene().getUserData();
           System.out.println(loader);
           t.getController(tc);


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

    public void getName(String n){
        name.setText(n);
    }
}
