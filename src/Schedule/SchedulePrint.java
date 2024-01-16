package Schedule;

import Login.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class SchedulePrint
{
    private User user;
    ArrayList<String> activities = new ArrayList<>();

    public SchedulePrint(User user) {
        this.user = user;
    }

    void loadFileToArray(ArrayList<String> activities, String day)
    {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\";
        String path = directoryPath + day + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                activities.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());

        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();
        currentHour+=1;

        loadFileToArray(activities,dayName);

        if(currentHour>activities.size() || activities.get(currentHour) == null)
        {
            System.out.println("Please Create a schedule");
        }
        else System.out.println("Activity: " + activities.get(currentHour));
    }
}
