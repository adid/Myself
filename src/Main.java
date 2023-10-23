import Login.LoginSystem;
import Login.Register;
import Login.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a styled welcome header
        System.out.println("******************************************");
        System.out.println("*        Welcome to Myself App!          *");
        System.out.println("*                                        *");
        System.out.println("******************************************");

        boolean loggedIn = false;

        Scanner scanner = new Scanner(System.in);

        while (!loggedIn) {
            System.out.println("Use the commands to continue:");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            if (input == 2) {
                Register register = new Register();
                register.register();
            } else if (input == 1) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("******************************************");
                System.out.println("*          Log In to Your Account         *");
                System.out.println("******************************************");

                System.out.print("Enter username: ");
                String username = scanner1.nextLine();
                System.out.print("Enter password: ");
                String password = scanner1.nextLine();

                User temp = new User(username, password);

                LoginSystem loginSystem = new LoginSystem(temp);

                if (loginSystem.checkAccount() && loginSystem.checkPassword()) {
                    loggedIn = true;
                    User user = loginSystem.login();

                    // Styled welcome message
                    System.out.println("******************************************");
                    System.out.println("*    Welcome, " + user.getUsername() + "!");
                    System.out.println("*  You can now manage your finances.   *");
                    System.out.println("******************************************");

                    Finance_Management financeManager = new Finance_Management();
                    financeManager.run();

                    System.out.println("Logging out...");
                } else {
                    System.out.println("******************************************");
                    System.out.println("*          Login Failed! Try again.       *");
                    System.out.println("******************************************");
                }
            } else if (input == 3) {
                System.out.println("Exiting Myself App...");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
