package Important_Days;

import Login.User;

import java.io.*;
import java.util.ArrayList;

public class ImportantDaysHandler
{
    public static void writeToFile(User user, ArrayList<String> important, String what) throws IOException {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\";
        String path = directoryPath + what + ".txt";
        File dayFile = new File(path);

        try (FileWriter writer = new FileWriter(dayFile)) {
            writer.write("");
            for (String scd : important) {
                writer.append(scd);
                writer.append("\n");
            }
        }
    }

    public static void loadFileToArray(User user, ArrayList<String> important, String what)
    {
        String directoryPath = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Important Days\\";
        String path = directoryPath + what + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                important.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
