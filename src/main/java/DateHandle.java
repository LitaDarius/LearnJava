import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class DateHandle{
	public static void addLogin() {
		LocalDate d=LocalDate.now();
		String time;
		int nr;
		File f=new File("logins.txt");
		if(f.exists()) {
			try {
				Scanner s=new Scanner(f);
				time=s.nextLine();
				nr=s.nextInt();
				
				if(time.equals(d.toString())) {
					try {
						FileWriter fw=new FileWriter("logins.txt");
						fw.write(d.toString()+"\n"+(nr+1));
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					try {
						FileWriter fw=new FileWriter("logins.txt");
						fw.write(d.toString()+"\n"+1);
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				
				System.out.println(f.createNewFile());
				try {
					FileWriter fw=new FileWriter("logins.txt");
					fw.write(d.toString()+"\n"+1);
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static int getLogins() {
		File f=new File("logins.txt");
		try {
			Scanner s=new Scanner(f);
			s.nextLine();
			return s.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}