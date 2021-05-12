import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestFrame {


    public static void start(File f) {

        Stage primaryStage=new Stage();
        int[] k=new int[1];
        k[0]=0;
        Scanner s=null;

        primaryStage.setTitle("Test ");
        //File f=new File("src/scratch.txt");
        try {
            s=new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while(s.hasNext())
    new TestFrame().test(s,k);

        System.out.println(k[0]);

    }

    public void test(Scanner s,int[] k){

        Stage primaryStage=new Stage();
        Label labelfirst= new Label(s.nextLine());
        Label labelresponse= new Label();

        int[] correct=new int [1];
        correct[0]=0;

        Button button= new Button("Submit");

        RadioButton radio1, radio2, radio3, radio4;
        radio1=new RadioButton(s.nextLine());
        radio2= new RadioButton(s.nextLine());
        radio3= new RadioButton(s.nextLine());
        radio4= new RadioButton(s.nextLine());

        correct[0]=s.nextInt();
        if(s.hasNext())
        System.out.println(s.nextLine()+" "+correct[0]+" "+k[0]);


        ToggleGroup question1= new ToggleGroup();

        radio1.setToggleGroup(question1);
        radio2.setToggleGroup(question1);
        radio3.setToggleGroup(question1);
        radio4.setToggleGroup(question1);

        button.setDisable(true);

        radio1.setOnAction(e -> button.setDisable(false) );
        radio2.setOnAction(e -> button.setDisable(false) );
        radio3.setOnAction(e -> button.setDisable(false) );
        radio4.setOnAction(e -> button.setDisable(false) );

        button.setOnAction(e ->
                {

                    if (radio1.isSelected()&&correct[0]==1)
                    {
                        k[0]++;
                        labelresponse.setText("Correct answer");
                        button.setDisable(true);
                        primaryStage.close();
                    }

                    else if(radio2.isSelected()&&correct[0]==2)
                    {
                        k[0]++;
                        labelresponse.setText("Correct answer");
                        button.setDisable(true);
                        primaryStage.close();
                    }
                    else if(radio3.isSelected()&&correct[0]==3)
                    {
                        k[0]++;
                        labelresponse.setText("Correct answer");
                        button.setDisable(true);
                        primaryStage.close();
                    }
                    else if(radio4.isSelected()&&correct[0]==4)
                    {
                        k[0]++;
                        labelresponse.setText("Correct answer");
                        button.setDisable(true);
                        primaryStage.close();
                    }
                    else{
                        labelresponse.setText("Wrong answer");
                        button.setDisable(true);
                        primaryStage.close();
                    }
                }
        );

        VBox layout= new VBox(5);

        layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, radio4, button, labelresponse);

        Scene scene1= new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.showAndWait();
    }




}
