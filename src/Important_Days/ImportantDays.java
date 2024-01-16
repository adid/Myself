package Important_Days;

import Login.User;
import MainMenu.MainMenu;
import Schedule.CreateSchedule;
import Schedule.EditSchedule;
import Schedule.ViewSchedule;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ImportantDays
{
    private User user;
    public ImportantDays(User user) {
        this.user = user;
    }

    public void run() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Use the commands to continue:");
            System.out.println("1. View All Important days");
            System.out.println("2. Add an Important day (Repeats Every Year)");
            System.out.println("3. Add an Important day (Only once to happen)");

            System.out.println("-----------------------------");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            if (input == 1)
            {
                ViewImportantDays viewImportantDays = new ViewImportantDays(user);
                viewImportantDays.run();
            }
            else if (input == 2)
            {
                AddImportantDay addImportantDay = new AddImportantDay(user);
                addImportantDay.run();
            }

            else if (input == 3)
            {
                AddTemporaryImportantDays addImportantDay = new AddTemporaryImportantDays(user);
                addImportantDay.run();
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

