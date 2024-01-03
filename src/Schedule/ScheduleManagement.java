package Schedule;

import Finance.Finance_Management;
import Login.User;
import Login.UserInfoPrint;

import java.util.Scanner;

public class ScheduleManagement
{
    private User user;
    public ScheduleManagement(User user) {
        this.user = user;
    }

public void run() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Use the commands to continue:");
        System.out.println("1. View Schedule");
        System.out.println("2. Edit Schedule");
        System.out.println("3. Create or Replace Schedule");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int input = scanner.nextInt();

        if (input == 1) {
            //To be completed
        } else if (input == 2) {
            //To be completed
        } else if (input == 3) {
            //To be completed
        } else if (input == 4) {
            System.out.println("Exiting Myself App...");
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
}
