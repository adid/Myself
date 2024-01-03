package Schedule;

import Login.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateSchedule {
    private User user;

    public CreateSchedule(User user) {
        this.user = user;
    }

    public void createScheduleFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule";
        File folder= new File(path);
        folder.mkdir();

        String path0 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Saturday.txt";
        String path1 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Sunday.txt";
        String path2 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Monday.txt";
        String path3 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Tuesday.txt";
        String path4 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Wednesday.txt";
        String path5 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Thursday.txt";
        String path6 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\Friday.txt";

        File saturday= new File(path0);
        File sunday= new File(path1);
        File monday= new File(path2);
        File tuesday= new File(path3);
        File wednesday= new File(path4);
        File thursday= new File(path5);
        File friday= new File(path6);

        FileWriter myWriter0 = new FileWriter(saturday);
        FileWriter myWriter1 = new FileWriter(sunday);
        FileWriter myWriter2 = new FileWriter(monday);
        FileWriter myWriter3 = new FileWriter(tuesday);
        FileWriter myWriter4 = new FileWriter(wednesday);
        FileWriter myWriter5 = new FileWriter(thursday);
        FileWriter myWriter6 = new FileWriter(friday);
    }
}
