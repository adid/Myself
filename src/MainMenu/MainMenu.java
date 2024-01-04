package MainMenu;

import Finance.Finance_Management;
import Login.*;

import java.util.Scanner;


public class MainMenu {
    private User user;

    public MainMenu(User user) {
        this.user = user;
    }

    public void run() {
        System.out.println("******************************************");
        System.out.println("Welcome, " + user.getUsername() + "!");
        System.out.println("******************************************");

        boolean loggedIn = true;

        Scanner scanner = new Scanner(System.in);

        while (loggedIn) {
            System.out.println("\nUse the commands to continue:");
            System.out.println("1. View Account Info");
            System.out.println("2. Manage your Finances");
            System.out.println("3. Schedule Manager (Coming Soon)");
            System.out.println("4. Track Important Dates (Coming Soon)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int input;

            try {
                input = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (input) {
                case 1:
                    UserInfoPrint userInfoPrint = new UserInfoPrint(user);
                    userInfoPrint.printUserInfo();
                    break;
                case 2:
                    Finance_Management financeManagement = new Finance_Management(user);
                    financeManagement.run();
                    break;
                case 3:
                    System.out.println("Schedule Manager is coming soon!");
                    break;
                case 4:
                    System.out.println("Tracking Important Dates is coming soon!");
                    break;
                case 5:
                    System.out.println("Exiting Myself App...");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

