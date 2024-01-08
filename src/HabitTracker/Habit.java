import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

class Habit implements Serializable
{
    private String name;
    private boolean completed;
    int goalDays;
    Set<String> reminderDays;
    private String reminderTime;

    public Habit(String name, int goalDays, Set<String> reminderDays, String reminderTime) {
        this.name = name;
        this.completed = false;
        this.goalDays = goalDays;
        this.reminderDays = reminderDays;
        this.reminderTime = reminderTime;
    }

    public Set<String> getReminderDays()
    {

        return reminderDays;
    }
    public String getReminderTime() {
        return reminderTime;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {

        return "Habit{" +
                "name='" + name + '\'' +
                ", completed=" + completed +
                ", goalDays=" + goalDays +
                ", reminderDays=" + reminderDays +
                ", reminderTime='" + reminderTime + '\'' +
                '}';
    }
    public void getReminder(Timer reminderTimer) {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();

        for (String reminderDay : getReminderDays()) {
            DayOfWeek targetDayOfWeek = DayOfWeek.valueOf(reminderDay.toUpperCase());
            LocalDateTime nextReminder = getNextReminderDateTime(now, targetDayOfWeek);

            reminderTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Reminder: Time to work on your habit - " + getName());
                }
            }, Duration.between(LocalDateTime.now(), nextReminder).toMillis(), 7 * 24 * 60 * 60 * 1000);
        }
    }



    private LocalDateTime getNextReminderDateTime(LocalDateTime now, DayOfWeek targetDayOfWeek) {
        LocalDateTime nextReminder = now.with(targetDayOfWeek);

        if (now.isAfter(nextReminder) || now.equals(nextReminder)) {
            nextReminder = nextReminder.plusWeeks(1);
        }

        return nextReminder.with(LocalDateTime.parse(getReminderTime(), DateTimeFormatter.ofPattern("HH:mm")));
    }
}

