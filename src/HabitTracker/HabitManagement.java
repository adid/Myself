import java.util.*;


public class HabitManagement
{
    public  void run( )
    {
        HabitTracker habitTracker = HabitTracker.loadFromFile("habit_tracker.ser");
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nOptions:");
            System.out.println("1. Add Habit");
            System.out.println("2. Mark Habit as Completed");
            System.out.println("3. Display Habit Tracker");
            System.out.println("4. Save Habit Tracker to File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice)
            {
                    case 1:
                        System.out.print("Enter habit name: ");
                        String habitName = scanner.nextLine();
    //                    habitTracker.addHabit(habitName);
                        Set<String> reminderDays = new HashSet<>();
                        System.out.print("Enter reminder days (comma-separated): ");
                        String[] daysArray = scanner.nextLine().split(",");
                        reminderDays.addAll(Arrays.asList(daysArray));
                        System.out.print("Enter reminder time (HH:mm): ");
                        String reminderTime = scanner.nextLine();
                        System.out.print("Enter habit goal days: ");
                        int goalDays = scanner.nextInt();
                        habitTracker.addHabit(habitName, goalDays, reminderDays, reminderTime);
                        break;

                    case 2:
                        System.out.print("Enter habit name to mark as completed: ");
                        habitName = scanner.nextLine();
                        habitTracker.markHabitCompleted(habitName);
                        break;

                    case 3:
                        habitTracker.displayHabitTracker();
                        break;

                    case 4:
                        habitTracker.saveToFile("habit_tracker.ser");
                        break;

                    case 5:
                        System.out.println("Exiting the Habit Tracker. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}






/*
	to complete :

	 1. habitt tracking app project development
 	 2. Solve the C problem
 */
