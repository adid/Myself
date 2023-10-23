package Login;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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
            System.out.println("Password must be of atleast 6 characters and contain at least one uppercase letter, one lowercase letter, and one digit.");
            return false;
        }

        return true;
    }

    public boolean isStrongPassword(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.length() >= 6;
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
        writer.write(userInfo.getUsername());
        writer.append("\n");
        writer.append(userInfo.getFirstName());
        writer.append("\n");
        writer.append(userInfo.getLastName());
        writer.append("\n");
        writer.append(userInfo.getPlaceOfBirth());
        writer.append("\n");
        writer.append(userInfo.getAddress());
        writer.append("\n");
        writer.append(userInfo.getPhoneNumber());
        writer.append("\n");
        writer.append(userInfo.getEmail());
        writer.append("\n");
        writer.append(userInfo.getSex());
        writer.append("\n");
        writer.append(userInfo.getMaritalStatus());
        writer.append("\n");
        writer.append(userInfo.getNationality());
        writer.append("\n");
        writer.append(Double.toString(userInfo.getIncome()));
        writer.append("\n");
        writer.append(userInfo.getCurrency());
        writer.append("\n");
        writer.close();
    }

    public void createBalanceFile() throws IOException {
        String path = "C:\\SPL\\Data"+ user.getUsername()+"\\Current_Balance.txt";
        File balanceFile= new File(path);

        Double balance= 0.00;

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(balance));
        myWriter.close();
    }

    public void createAccount() throws IOException {
        createUserFile();
        createPasswordFile();
        createInfoFile();
        createBalanceFile();
    }
}
