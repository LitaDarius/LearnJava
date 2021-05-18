import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*import com.fasterxml.jackson.databind.ObjectMapper;
import com.levo.jsonex.model.Page;
import com.levo.jsonex.model.PageInfo;
import com.levo.jsonex.model.Post;*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchClients{




        public static void main(String[] args) throws IOException
        {
            File f1=new File("login.json");
            String[] words=null;
            FileReader fr = new FileReader(f1);  // File Reader object
            BufferedReader br = new BufferedReader(fr);
            String s;
            String input="als";
            int count=0;
            while((s=br.readLine())!=null)
            {
               words=s.split("");
                for (String word : words)
                {
                    if (word.equals(input))
                    {
                        System.out.println(word);
                        count++;
                    }
                }
            }
            if(count==0)
            {
                System.out.println("The given word is not present in the file");
            }

            fr.close();
        }


    }






