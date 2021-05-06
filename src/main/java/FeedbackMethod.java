import java.io.*;
//commmmmmmmmmmmm

public class FeedbackMethod {
    public void write(String Name,String message) {

        final String FILE_NAME = "out.txt";
        try {
            FileWriter fstream = new FileWriter(FILE_NAME, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.append("Name:"+Name + "\n\r");
            out.append("\nFeedback:"+message + "\n");
            out.close();
        }
        catch(IOException e1) {
            System.out.println("Error");
        }
    }
}

