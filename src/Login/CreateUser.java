package Login;
import java.io.Console;
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

    public boolean isStrongPassword(String password) {

        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.length() >= 6;
    }


    public void createUserFile()  {
        String path = "C:\\SPL\\Data\\"+ user.getUsername();
        File folder= new File(path);
        folder.mkdir();
    }
    public void createPasswordFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Password.txt";
        File passFile= new File(path);

        FileWriter myWriter = new FileWriter(passFile);
        myWriter.write(user.getPassword());
        myWriter.close();
    }


    public void createInfoFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\UserInfo.txt";
        File infoFile= new File(path);

        FileWriter writer = new FileWriter(infoFile);
        writer.write(userInfo.getUsername());
        writer.append("\n");
        writer.append(userInfo.getFirstName());
        writer.append("\n");
        writer.append(userInfo.getLastName());
        writer.append("\n");
        writer.append(userInfo.getDateOfBirth());
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
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Current_Balance.txt";
        File balanceFile= new File(path);

        Double balance= 0.00;

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(balance));
        myWriter.close();
    }

    public void createLoanFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Loan_Balance.txt";
        File balanceFile= new File(path);

        Double balance= 0.00;

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(balance));
        myWriter.close();
    }

    public void createImportantDaysFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days";
        File folder= new File(path);
        folder.mkdir();
        String dates = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\dates.txt";
        String topics = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\topics.txt";
        String tempdates = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\TemporaryDates.txt";
        String temptopics = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\TemporaryTopics.txt";



        File datefile= new File(dates);
        File topicfile= new File(topics);
        File tempdatefile= new File(tempdates);
        File temptopicfile= new File(temptopics);

        FileWriter myWriter0 = new FileWriter(datefile);
        FileWriter myWriter1 = new FileWriter(topicfile);
        FileWriter myWriter2 = new FileWriter(tempdatefile);
        FileWriter myWriter3 = new FileWriter(temptopicfile);
    }

    public void createTransactionFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions";
        File folder= new File(path);
        folder.mkdir();

        String path0 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Transaction_no.txt";
        String path1 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Borrow.txt";
        String path2 = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Lend.txt";

        File noFile= new File(path0);
        File dateFile= new File(path1);
        File typeFile= new File(path2);

        FileWriter myWriter0 = new FileWriter(noFile);
        FileWriter myWriter1 = new FileWriter(dateFile);
        FileWriter myWriter2 = new FileWriter(typeFile);
    }

    public boolean checkUser() {
        String path = "C:\\SPL\\Data";

        // Check if the username already exists
        String userDirectoryPath = path + "\\" + user.getUsername();
        File userDirectory = new File(userDirectoryPath);
        if (userDirectory.exists() && userDirectory.isDirectory()) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }
        return true;
    }

    public boolean checkPassword(){
        String password = user.getPassword();
        if (!isStrongPassword(password)) {
            System.out.println("Password must be of atleast 6 characters and contain at least one uppercase letter, one lowercase letter, and one digit.");
            return false;
        }
        return true;
    }

    public void createScheduleFile() throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule";
        File folder= new File(path);
        folder.mkdir();
    }

    public void writeToFile(String day) throws IOException {
        String directoryPath = "C:\\SPL\\Data\\" + user.getUsername() + "\\Schedule\\";
        String path = directoryPath + day + ".txt";
        File dayFile = new File(path);
        FileWriter myWriter0 = new FileWriter(dayFile);
    }

    void createDayFiles(){
        try {
            writeToFile("Saturday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Sunday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Monday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Tuesday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Wednesday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Thursday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writeToFile("Friday");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createAccount() throws IOException {
        if (checkUser() ){
            createUserFile();
            createPasswordFile();
            createInfoFile();
            createBalanceFile();
            createLoanFile();
            createTransactionFile();
            createImportantDaysFile();
            createScheduleFile();
            createDayFiles();
            return true;
        }
        return false;
    }
}
