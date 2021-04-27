import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class LoginStageController {

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Text error_field;

    @FXML
    private Button login_button;

    public LoginStageController(){

    }

    public void tryLogin(){
        //HandleJSON.checkIfUserExists(name_field.getText());
        error_field.setText(HandleJSON.addUser(name_field.getText(),PasswordHandler.getHashedPassword(password_field.getText(),name_field.getText()))+"");
        //JSON parser object to parse read file
        /*JSONParser jsonParser = new JSONParser();
        URL file = this.getClass().getResource("login.json");

        try (FileReader reader = new FileReader( new File(file.getFile())))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
      //error_field.setText("failed to login");
    }

    private void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("name");
        System.out.println(firstName);



        PasswordHandler ps=new PasswordHandler();
        error_field.setText(ps.getHashedPassword(password_field.getText(),name_field.getText()));*/
       /* if(firstName.equals(name_field.getText())){
            error_field.setText("user found");
        }*/
    }
}