import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

public class SearchClient {
    public static boolean checkifExists(String name)  {
        FileReader r;
        try {
            r = new FileReader("login.json");
        } catch (FileNotFoundException e) {
            return false;
        }
        JSONParser parser=new JSONParser();

        try {
            Object allObjects=parser.parse(r);

            JSONArray arr=(JSONArray)allObjects;
            int i;
            for(i=0;i<arr.size();i++){
                JSONObject tmp=(JSONObject) arr.get(i);
                if(name.equals(tmp.get("name").toString())){
                    // System.out.println(true+"1");

                    return true;
                }
            }
            // System.out.println(false+"2");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (ClassCastException e){
            try {
                Object allObjects=parser.parse(r);
                JSONObject tmp=(JSONObject) allObjects;

                //  System.out.println(true+"3");
                return name.equals(tmp.get("name").toString());
                //System.out.println(false+"4");


            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
        return false;
    }
}
