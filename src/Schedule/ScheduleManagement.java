package Schedule;

import Finance.Finance_Management;
import Login.User;
import Login.UserInfoPrint;
import MainMenu.MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class ScheduleManagement
{
    private User user;
    public ScheduleManagement(User user) {
        this.user = user;
    }

public void run() throws IOException {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Use the commands to continue:");
        System.out.println("1. View Schedule");
        System.out.println("2. Edit Schedule");
        System.out.println("3. Create or Replace Schedule");
        System.out.println("-----------------------------");
        System.out.println("4. Back to Main Menu");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int input = scanner.nextInt();

        if (input == 1)
        {
            ViewSchedule viewSchedule = new ViewSchedule(user);
            viewSchedule.run();
        }
        else if (input == 2)
        {
            EditSchedule editSchedule = new EditSchedule(user);
            editSchedule.run();
        }
        else if (input == 3)
        {
            CreateSchedule createSchedule= new CreateSchedule(user);
            try {
                createSchedule.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (input == 4)
        {
            MainMenu mainMenu = new MainMenu(user);
            mainMenu.run();
        }
        else if (input == 5)
        {
            System.out.println("Exiting Myself App...");
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
}
