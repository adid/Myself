package Important_Days;

import Login.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ShowToday
{
    private User user;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> topics = new ArrayList<>();

    public ShowToday(User user) {
        this.user = user;
    }

    public void run() throws IOException, ParseException {
        ImportantDaysHandler.loadFileToArray(user,dates,"dates");
        ImportantDaysHandler.loadFileToArray(user,topics,"topics");

        int minSize = Math.min(dates.size(), topics.size());

        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < minSize; i++) {
            String inputDateStr = dates.get(i);

            // Parse the input date string to LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(inputDateStr, formatter);

            // Check if the day and month components match (ignoring the year)
            if (currentDate.getMonth() == inputDate.getMonth() && currentDate.getDayOfMonth() == inputDate.getDayOfMonth()) {
                System.out.println("Today is " + topics.get(i));
                System.out.println("------------------------------------------");
            }
        }

        dates.clear();
        topics.clear();

        ImportantDaysHandler.loadFileToArray(user,dates,"TemporaryDates");
        ImportantDaysHandler.loadFileToArray(user,topics,"TemporaryTopics");

        for (int i = 0; i <Math.min(dates.size(), topics.size()); i++) {
            String inputDateStr = dates.get(i);

            // Parse the input date string to LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(inputDateStr, formatter);

            if (currentDate.isEqual(inputDate)) {
                System.out.println("Today is " + topics.get(i));
                System.out.println("------------------------------------------");
            }
            else if(inputDate.isBefore(currentDate)){
                try {
                    dates.remove(i);
                    topics.remove(i);
                    i--;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        ImportantDaysHandler.writeToFile(user,dates,"TemporaryDates");
        ImportantDaysHandler.writeToFile(user,topics,"TemporaryTopics");
    }
}
