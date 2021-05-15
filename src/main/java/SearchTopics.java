import java.io.File;
import java.io.FilenameFilter;

public class SearchTopics {
    public void search(String SearchT) {

        File[] fileList = getFileList("C:\\Users\\Alexandra\\Desktop\\TOPICS",SearchT);
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


    }

    public static File[] getFileList(String dirPath,String SearchT) {
        File dir = new File(dirPath);

        File[] fileList = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(SearchT);
            }
        });
        return fileList;
    }
}