package MainMenu;

import Finance.Finance_Management;
import Login.*;

import java.util.Scanner;

public class MainMenu
{
    private User user;

    public MainMenu(User user) {
        this.user = user;
    }


    public void run()
    {
        System.out.println("******************************************");
        System.out.println("Welcome " + user.getUsername() + "!");
        System.out.println("******************************************");

        boolean loggedIn = true;

        Scanner scanner = new Scanner(System.in);

        while (loggedIn) {
            System.out.println("Use the commands to continue:");
            System.out.println("1. View Account Info");
            System.out.println("2. Manage your Finance");
            System.out.println("3. Schedule Manager");
            System.out.println("4. Track Important Dates");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            if (input == 1) {
                UserInfoPrint userInfoPrint = new UserInfoPrint(user);
                userInfoPrint.printUserInfo();
            }
            else if (input == 2) {
                Finance_Management financeManagement = new Finance_Management(user);
                financeManagement.run();
            }
            else if (input == 3) {
                //To be completed
            }
            else if (input == 4) {
                //To be completed
            }
            else if (input == 5) {
                System.out.println("Exiting Myself App...");
                System.exit(0);
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
