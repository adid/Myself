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

    public boolean checkAccount() {
        String path = "C:\\SPL\\Data";
        File folder = new File(path);

        // Check if the username already exists
        String userDirectoryPath = path + "\\" + user.getUsername();
        File userDirectory = new File(userDirectoryPath);
        if (userDirectory.exists() && userDirectory.isDirectory()) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }

        // Check if the password meets the criteria
        String password = user.getPassword();
        if (!isStrongPassword(password)) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
            return false;
        }

        return true;
    }

    public boolean isStrongPassword(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
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
