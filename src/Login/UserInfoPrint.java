package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserInfoPrint
{
    private User user;
    ArrayList<String> userInfo = new ArrayList<>();

    public UserInfoPrint(User user) {
        this.user = user;
    }

    public void loadUserInfo() {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\UserInfo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                userInfo.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printUserInfo(){
        loadUserInfo();
        System.out.print("Username: ");
        System.out.println(userInfo.get(0));
        System.out.print("First Name: ");
        System.out.println(userInfo.get(1));
        System.out.print("Last Name: ");
        System.out.println(userInfo.get(2));
        System.out.print("Date of Birth: ");
        System.out.println(userInfo.get(3));
        System.out.print("Place of Birth: ");
        System.out.println(userInfo.get(4));
        System.out.print("Address: ");
        System.out.println(userInfo.get(5));
        System.out.print("Phone Number: ");
        System.out.println(userInfo.get(6));
        System.out.print("Email: ");
        System.out.println(userInfo.get(7));
        System.out.print("Sex: ");
        System.out.println(userInfo.get(8));
        System.out.print("Marital Status: ");
        System.out.println(userInfo.get(9));
        System.out.print("Nationality: ");
        System.out.println(userInfo.get(10));
        System.out.print("Income: ");
        System.out.println(userInfo.get(11));
        System.out.print("Currency: ");
        System.out.println(userInfo.get(12));
    }
}
