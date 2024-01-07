package Important_Days;

import Login.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewImportantDays
{
    private User user;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> topics = new ArrayList<>();

    public ViewImportantDays(User user) {
        this.user = user;
    }

    public void run() throws IOException {
        ImportantDaysHandler.loadFileToArray(user,dates,"dates");
        ImportantDaysHandler.loadFileToArray(user,topics,"topics");

        int minSize = Math.min(dates.size(), topics.size());

        for (int i = 0; i < minSize; i++) {
            System.out.println("Date: " + dates.get(i) + ", Topic: " + topics.get(i));
        }
    }
}
