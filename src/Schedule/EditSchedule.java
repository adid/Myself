package Schedule;

import Login.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EditSchedule
{
    private User user;
    private String day = null;
    ArrayList<String> daySchedule = new ArrayList<>();
    public EditSchedule(User user) {
        this.user = user;
    }
    public void loadSchedule(String day) throws IOException, ParseException {
        ViewSchedule viewSchedule = new ViewSchedule(user);
        viewSchedule.loadFileToArray(daySchedule, day);
        runAgain();
    }
    public void run() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Day:");
            System.out.println("1. Saturday");
            System.out.println("2. Sunday");
            System.out.println("3. Monday");
            System.out.println("4. Tuesday");
            System.out.println("5. Wednesday");
            System.out.println("6. Thursday");
            System.out.println("7. Friday");
            System.out.println("----------");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            if (input == 1)
            {
                day= "Saturday";
                loadSchedule(day);
            }
            else if (input == 2)
            {
                day= "Sunday";
                loadSchedule(day);
            }
            else if (input == 3)
            {
                day="Monday";
                loadSchedule(day);
            }
            else if (input == 4)
            {
                day="Tuesday";
                loadSchedule(day);
            }
            else if (input == 5)
            {
                day="Wednesday";
                loadSchedule(day);
            }
            else if (input == 6)
            {
                day="Thursday";
                loadSchedule(day);
            }
            else if (input == 7)
            {
                day="Friday";
                loadSchedule(day);
            }
            else if (input == 0)
            {
                ScheduleManagement scheduleManagement = new ScheduleManagement(user);
                scheduleManagement.run();
            }
            else
            {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void writeToFile(ArrayList<String> schedule ,String day) throws IOException {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\";
        String path = directoryPath + day + ".txt";
        File dayFile = new File(path);

        try (FileWriter writer = new FileWriter(dayFile)) {
            writer.write("");
            for (String scd : schedule) {
                writer.append(scd);
                writer.append("\n");
            }
        }
    }

    void updateSchedule(int time, String activity) throws IOException {
        daySchedule.set(time, activity);
        writeToFile(daySchedule,day);
    }
    public void runAgain() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Time:");
            System.out.println("1. 00.00-01.00");
            System.out.println("2. 01.00-02.00");
            System.out.println("3. 02.00-03.00");
            System.out.println("4. 03.00-04.00");
            System.out.println("5. 04.00-05.00");
            System.out.println("6. 05.00-06.00");
            System.out.println("7. 06.00-07.00");
            System.out.println("8. 07.00-08.00");
            System.out.println("9. 08.00-09.00");
            System.out.println("10. 09.00-10.00");
            System.out.println("11. 10.00-11.00");
            System.out.println("12. 11.00-12.00");
            System.out.println("13. 12.00-13.00");
            System.out.println("14. 13.00-14.00");
            System.out.println("15. 14.00-15.00");
            System.out.println("16. 15.00-16.00");
            System.out.println("17. 16.00-17.00");
            System.out.println("18. 17.00-18.00");
            System.out.println("19. 18.00-19.00");
            System.out.println("20. 19.00-20.00");
            System.out.println("21. 20.00-21.00");
            System.out.println("22. 21.00-22.00");
            System.out.println("23. 22.00-23.00");
            System.out.println("24. 23.00-24.00");
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("0. Back to Schedule Management");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0)
            {
                ScheduleManagement scheduleManagement = new ScheduleManagement(user);
                scheduleManagement.run();
            }
            else if (input>24 || input <0)
            {
                System.out.println("Invalid input. Please try again.");
            }

            System.out.println("Activity: ");
            String activity = scanner.nextLine();
            updateSchedule(input,activity);
        }
    }

}
