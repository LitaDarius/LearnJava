import java.io.File;
import java.io.FilenameFilter;

public class SearchTopics {

    TestsController cont;

    public static boolean search(String SearchT) {



        File[] fileList = getFileList("topics",SearchT);
        int i=0;
        for(File file : fileList) {
            if(file.getName()!=null){
                i++;
            }
            System.out.println(file.getName());
        }
        if(i==0){
            System.out.println("err");
        }
        return true;

    }

    public static File[] getFileList(String dirPath,String SearchT) {
        File dir = new File(dirPath);

        File[] fileList = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains(SearchT);
            }
        });
        return fileList;
    }

    public void giveController(TestsController t){
        cont=t;
    }
}