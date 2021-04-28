/*import java.io.*;

class Feedback{

        try {


            InputStreamReader isr = new InputStreamReader(System.in);
            OutputStreamWriter osw;
            osw = new OutputStreamWriter(System.out);
            BufferedReader br = new BufferedReader(isr);.
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("Please write your name\r\n");
            bw.flush();
            String line = br.readLine();

            if(nameOk(line))
            {
                // If user input valid name
                String text1 = "Name:\n" +line + "\r\n";

                bw.write(text1);
                bw.flush();

                FileWriter fw = new FileWriter("out.txt",true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(text1);
                pw.close();
            }else {


                String text = line + " not a name \r\n";
                bw.write(text);
                bw.flush();

            }
            bw.write("Please write your Feedback.\r\n");
            bw.flush();
            String line2=br.readLine();
            if(feedbackOk(line))
            {
                // If user input valid feedback
                String text2 = "Feedback:\n" +line2 + "\r\n";

                // Print the text
                bw.write(text2);
                bw.flush();

                FileWriter fw = new FileWriter("out.txt",true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(text2);
                pw.close();
            }else {

                String text = line2 + " not a name \r\n";
                bw.write(text);
                bw.flush();

            }
        }catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }


    private static boolean nameOk(String namee,String feedbackComm)
    {
        boolean ret = true;

        if(namee==null || feedbackComm==null )
        {
            ret = false;
        }

        return ret;
    }

}
*/


