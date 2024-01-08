import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

class HabitTracker implements Serializable {
    private List<Habit> habits = new ArrayList<>();
    private Timer reminderTimer;
    private static final long serialVersionUID = 1L;
    public void addHabit(String habitName, int goalDays, Set<String> reminderDays, String reminderTime) {
        Habit newHabit = new Habit(habitName, goalDays, reminderDays, reminderTime);
        habits.add(newHabit);
        //scheduleReminders(newHabit);
        System.out.println("Habit added: " + habitName);
    }

    private void scheduleReminders(Habit habit) {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime reminderDateTime = LocalDateTime.now();

        try
        {
            reminderDateTime = reminderDateTime.with(LocalDateTime.parse(habit.getReminderTime(), timeFormat));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return;
        }

        for (String reminderDay : habit.getReminderDays()) {
            DayOfWeek targetDayOfWeek = DayOfWeek.valueOf(reminderDay.toUpperCase());
            LocalDateTime nextReminder = getNextReminderDateTime(reminderDateTime, targetDayOfWeek);

            reminderTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Reminder: Time to work on your habit - " + habit.getName());
                }
            }, Duration.between(LocalDateTime.now(), nextReminder).toMillis(), 7 * 24 * 60 * 60 * 1000);
        }
    }

    private LocalDateTime getNextReminderDateTime(LocalDateTime reminderTime, DayOfWeek targetDayOfWeek)
    {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextReminder = reminderTime.with(targetDayOfWeek);

        if (now.isAfter(nextReminder) || now.equals(nextReminder)) {
            nextReminder = nextReminder.plusWeeks(1);
        }

        return nextReminder;
    }

    public void markHabitCompleted(String habitName) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habit.markCompleted();
                System.out.println("Habit marked as completed: " + habitName);
                return;
            }
        }
        System.out.println("Habit not found: " + habitName);
    }

    public void displayHabitTracker()
    {
        System.out.println("Habit Tracker:");

        for (Habit habit : habits)
        {
            String status = habit.isCompleted() ? "[X] " : "[ ] ";
            System.out.println(status + habit.getName());
        }
    }

    public void saveToFile(String fileName)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(this);
            System.out.println("Habit tracker saved to file: " + fileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static HabitTracker loadFromFile(String fileName)
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return (HabitTracker) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return new HabitTracker();
        }
    }
}