
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJSON {



    @Test
    void addUserTest(){
        HandleJSON.addUser("testul","testpass","user");
        Assertions.assertEquals(true,"user".equals(HandleJSON.giveUserType("testul")));
    }

    @Test
    void addUserTwice(){
        HandleJSON.addUser("testu","testpass","user");
        Assertions.assertEquals(false,HandleJSON.addUser("testu","testpass","user"));
    }


}
