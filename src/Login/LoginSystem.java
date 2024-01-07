package Login;

import java.io.*;

public class LoginSystem
{
    User user;

    public LoginSystem(User user)
    {
        this.user=user;
    }
    public boolean checkAccount()
    {
        String path = "C:\\SPL\\Data";
        File folder = new File(path);

        String userDirectoryPath = path + "\\" + user.getUsername();
        File userDirectory = new File(userDirectoryPath);
        if (userDirectory.exists() && userDirectory.isDirectory()) {
            return true;
        }
        System.out.println("User doesn't exist");
        return false;
    }

    public boolean checkPassword()
    {
        String fileName = "C:\\SPL\\Data\\" + user.getUsername() + "\\Password.txt";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            //System.out.println(line+" "+user.getPassword());
            if (line != null && line.equals(user.getPassword()) )
            {
                return true;
            }
            else
            {
                System.out.println("Passwords do not match or password is not strong enough. Please try again.");
                return false;
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return false;
    }

    public User login()
    {
        return new User(user.getUsername(), user.getPassword());
    }
}