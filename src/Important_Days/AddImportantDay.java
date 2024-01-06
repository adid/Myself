package Important_Days;

import Login.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddImportantDay
{
    private User user;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> topics = new ArrayList<>();

    public AddImportantDay(User user) {
        this.user = user;
    }

    public void run() throws IOException {
        ImportantDaysHandler.loadFileToArray(user,dates,"dates");
        ImportantDaysHandler.loadFileToArray(user,topics,"topics");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mention your important Date (DD/MM/YYYY): ");
        dates.add(scanner.nextLine());

        System.out.print("Speciality of that Date: ");
        topics.add(scanner.nextLine());

        ImportantDaysHandler.writeToFile(user,dates,"dates");
        ImportantDaysHandler.writeToFile(user,topics,"topics");
    }
}
