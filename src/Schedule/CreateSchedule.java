package Schedule;

import Login.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateSchedule {
    private User user;
    private ArrayList<String> schedule = new ArrayList<>();

    public CreateSchedule(User user) {
        this.user = user;
    }

    public void writeToFile(ArrayList<String> schedule ,String day) throws IOException {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Schedule\\";
        String path = directoryPath + day + ".txt";
        File dayFile = new File(path);

        try (FileWriter writer = new FileWriter(dayFile)) {
            writer.write(day);
            for (String scd : schedule) {
                writer.append("\n");
                writer.append(scd);
            }
        }
    }


    public void dailySchedule(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("00.00-01.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("01.00-02.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("02.00-03.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("03.00-04.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("04.00-05.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("05.00-06.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("06.00-07.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("07.00-08.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("08.00-09.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("09.00-10.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("10.00-11.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("11.00-12.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("12.00-13.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("13.00-14.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("14.00-15.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("15.00-16.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("16.00-17.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("17.00-18.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("18.00-19.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("19.00-20.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("20.00-21.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("21.00-22.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("22.00-23.00: ");
        schedule.add(scanner.nextLine());
        System.out.print("23.00-24.00: ");
        schedule.add(scanner.nextLine());
    }

    public void run() throws IOException {

        System.out.println("Saturday: ");
        dailySchedule();
        writeToFile(schedule,"Saturday");
        schedule.clear();

        System.out.println("Sunday: ");
        dailySchedule();
        writeToFile(schedule,"Sunday");
        schedule.clear();

        System.out.println("Monday: ");
        dailySchedule();
        writeToFile(schedule,"Monday");
        schedule.clear();

        System.out.println("Tuesday: ");
        dailySchedule();
        writeToFile(schedule,"Tuesday");
        schedule.clear();

        System.out.println("Wednesday: ");
        dailySchedule();
        writeToFile(schedule,"Wednesday");
        schedule.clear();

        System.out.println("Thursday: ");
        dailySchedule();
        writeToFile(schedule,"Thursday");
        schedule.clear();

        System.out.println("Friday: ");
        dailySchedule();
        writeToFile(schedule,"Friday");
        schedule.clear();
    }
}
