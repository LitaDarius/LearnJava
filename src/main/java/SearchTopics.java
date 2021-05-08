
    import java.io.*;
    import java.util.*;

    class SearchTopics{

        public void findFile(String name,File file)
        {
            File[] list = file.listFiles();
            if(list!=null)
                for (File fil : list)
                {
                    if (fil.isDirectory())
                    {
                        findFile(name,fil);
                    }
                    else if (name.equalsIgnoreCase(fil.getName()))
                    {
                        System.out.println(fil.getParentFile());
                    }
                }
        }
      /*  public static void main(String[] args)
        {
           SearchTopics ff = new SearchTopics();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the file to be searched.. " );
            String name = scan.next();
            //System.out.println("Enter the directory where to search ");
            String directory = "TOPICS";
            ff.findFile(name,new File(directory));
        }*/

}
