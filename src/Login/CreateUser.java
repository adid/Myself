package Login;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUser
{
    public User user;
    public UserInfo userInfo;

    public CreateUser(User user, UserInfo userInfo)
    {
        this.user= user;
        this.userInfo= userInfo;
    }

    public boolean checkAccount(User user) {
        String path = "C:\\SPL\\Data";
    }

    public void createUserFile(){
        String path = "C:\\SPL\\Data"+ user.getUsername();
        File folder= new File(path);
        folder.mkdir();
    }
    public void createPasswordFile() throws IOException {
        String path = "C:\\SPL\\Data"+ user.getUsername()+"\\Password.txt";
        File passFile= new File(path);

        FileWriter myWriter = new FileWriter(passFile);
        myWriter.write(user.getPassword());
        myWriter.close();
    }
    public void createInfoFile() throws IOException {
        String path = "C:\\SPL\\Data"+ user.getUsername()+"\\UserInfo.txt";
        File infoFile= new File(path);

        FileWriter writer = new FileWriter(infoFile);
        writer.write("Adid");
        writer.append("210042172");
        writer.close();
    }

    public void createAccount() throws IOException {
        createUserFile();
        createPasswordFile();
        createInfoFile();
    }
}
