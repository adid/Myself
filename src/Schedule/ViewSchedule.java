package Schedule;

import Login.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ViewSchedule
{
    private User user;
    ArrayList<String> saturday = new ArrayList<>();
    ArrayList<String> sunday = new ArrayList<>();
    ArrayList<String> monday = new ArrayList<>();
    ArrayList<String> tuesday = new ArrayList<>();
    ArrayList<String> wednesday = new ArrayList<>();
    ArrayList<String> thursday = new ArrayList<>();
    ArrayList<String> friday = new ArrayList<>();

    public ViewSchedule(User user) {
        this.user = user;
    }

    void loadFileToArray(ArrayList<String> dayList, String day)
    {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\";
        String path = directoryPath + day + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                dayList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){

        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\";
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory())
        {
            System.out.println("Schedule not Available. Please Create one");
            return;
        }

        loadFileToArray(saturday, "Saturday");
        loadFileToArray(sunday, "Sunday");
        loadFileToArray(monday, "Monday");
        loadFileToArray(tuesday, "Tuesday");
        loadFileToArray(wednesday, "Wednesday");
        loadFileToArray(thursday, "Thursday");
        loadFileToArray(friday, "Friday");

        if(saturday.isEmpty() || sunday.isEmpty() || monday.isEmpty() || tuesday.isEmpty() || wednesday.isEmpty() || thursday.isEmpty() || friday.isEmpty())
        {
            System.out.println("Schedule not Available. Please Create one");
            return;
        }

        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Day" ,saturday.get(0),sunday.get(0),monday.get(0),tuesday.get(0),wednesday.get(0),thursday.get(0),friday.get(0));

        for(int i=1; i<25; i++){
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", (i-1) +".00 -" + i + ".00" ,saturday.get(i),sunday.get(i),monday.get(i),tuesday.get(i),wednesday.get(i),thursday.get(i),friday.get(i));
        }
    }
}
