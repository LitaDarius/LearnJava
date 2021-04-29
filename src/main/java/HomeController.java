import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeController {
    @FXML
    private Text name;

    public void getName(String n){
        name.setText(n);
    }
}
