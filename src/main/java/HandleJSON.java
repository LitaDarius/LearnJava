import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;



public class HandleJSON {

    public static boolean addUser(String name, String hashedPassword ){ //the function returns true if it added a new user with success else false


        if(checkIfUserExists(name)){ //if user exists it will not be added
            return false;
        }
        JSONObject obj = new JSONObject(); //in this object all the user info will be stored

        JSONParser parser=new JSONParser();


        obj.put("name", name);
        obj.put("password", hashedPassword);
        obj.put("tests","");

        JSONArray a= new JSONArray();

        try {   // in chase the file contains an JSONArray

            FileReader r=new FileReader("login.json");


            Object o= parser.parse(r);

            a=(JSONArray) o;


            a.add(obj);

            System.out.println(a.get(a.size()-1));


            FileWriter file = new FileWriter(new File("login.json"));


            file.write(a.toJSONString());
            file.flush();
            return true;
        }catch (NullPointerException | IOException | ParseException e ){

            try {       //in chase the file is empty or does not exist

                FileWriter file = new FileWriter("login.json");
                a.add(obj);



                file.write(a.toJSONString());
                file.flush();
                return true;
            } catch (IOException ee) {

                e.printStackTrace();
                return false;
            }
        }catch (ClassCastException e1){
            try{        //in chase there is only one JSONObject
            FileReader r=new FileReader("login.json");


            Object o= parser.parse(r);
            JSONObject Jobj=(JSONObject) o;
            Jobj=(JSONObject) o;


            a.add(obj);
            a.add(Jobj);




            FileWriter file = new FileWriter(new File("login.json"));


            file.write(a.toJSONString());
            file.flush();
            return true;
        }catch (Exception d){
                System.out.println("strange Scenario "+d);
                return false;
            }
        }


    }



    public static boolean checkIfUserExists(String name)  {
        FileReader r= null;
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
                //System.out.println(tmp.get("name"));
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

                if(name.equals(tmp.get("name").toString())){
                  //  System.out.println(true+"3");
                    return true;
                }
                //System.out.println(false+"4");
                return false;



            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
        return false;
    }

}
