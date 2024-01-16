package Important_Days;

import Login.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddTemporaryImportantDays
{
    private User user;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> topics = new ArrayList<>();

    public AddTemporaryImportantDays(User user) {
        this.user = user;
    }

    public void run() throws IOException {
        ImportantDaysHandler.loadFileToArray(user,dates,"TemporaryDates");
        ImportantDaysHandler.loadFileToArray(user,topics,"TemporaryTopics");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mention your important Date (DD/MM/YYYY): ");
        dates.add(scanner.nextLine());

        System.out.print("Speciality of that Date: ");
        topics.add(scanner.nextLine());

        ImportantDaysHandler.writeToFile(user,dates,"TemporaryDates");
        ImportantDaysHandler.writeToFile(user,topics,"TemporaryTopics");
    }
}
