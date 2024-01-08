import java.util.TimerTask;

class ReminderTask extends TimerTask
{
    private String habitName;

    public ReminderTask(String habitName)
    {
        this.habitName = habitName;
    }

    @Override
    public void run()
    {
        System.out.println("Reminder: Don't forget to complete your habit - " + habitName);
    }
}