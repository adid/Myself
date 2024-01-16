
import Finance.FinancialManagement;
import Important_Days.ImportantDays;
import Important_Days.ShowToday;
import Login.*;
import Schedule.ScheduleManagement;
import Schedule.SchedulePrint;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu
{
    private User user;

    public MainMenu(User user) {
        this.user = user;
    }


    public void run() throws IOException, ParseException {
        System.out.println("******************************************");
        System.out.println("Welcome " + user.getUsername() + "!");
        System.out.println("******************************************");
        ShowToday showToday = new ShowToday(user);
        showToday.run();
        System.out.println("******************************************");
        SchedulePrint schedulePrint = new SchedulePrint(user);
        schedulePrint.run();
        System.out.println("******************************************");

        boolean loggedIn = true;

        Scanner scanner = new Scanner(System.in);

        while (loggedIn) {
            System.out.println("Use the commands to continue:");
            System.out.println("1. View Account Info");
            System.out.println("2. Manage your Finances");
            System.out.println("3. Schedule Manager");
            System.out.println("4. Track Important Dates");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    UserInfoPrint userInfoPrint = new UserInfoPrint(user);
                    userInfoPrint.printUserInfo();
                    break;
                case 2:
                    FinancialManagement financeManagement = new FinancialManagement(user);
                    financeManagement.run();
                    break;
                case 3:
                    ScheduleManagement scheduleManagement = new ScheduleManagement(user);
                    scheduleManagement.run();
                    break;
                case 4:
                    ImportantDays importantDays = new ImportantDays(user);
                    importantDays.run();
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