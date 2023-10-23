import Login.LoginSystem;
import Login.Register;
import Login.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Myself App!");

        System.out.println("Use the commands to continue \n");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("Exit");

        User user;
        boolean loggedIn = false;

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == 2) {
            Register register= new Register();
            register.register();

        }
        else if (input == 1) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner1.nextLine();
            System.out.print("Enter password: ");
            String password = scanner1.nextLine();

            User temp= new User(username,password);

            LoginSystem loginSystem= new LoginSystem(temp);

            if(loginSystem.checkAccount() && loginSystem.checkPassword()) {
                loggedIn= true;
                user= loginSystem.login();
            }

            else{
                System.out.println("Login Failed");
            }
        }

        // If user is logged in, show the following options:

        if (loggedIn) {
            System.out.println("What would you like to do?");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View transaction history");
            System.out.println("5. Log out");
        } else {
            System.out.println("Please log in or register to continue.");
        }

        // Take user input
        // If user input is 1, check balance
        // If user input is 2, deposit
        // If user input is 3, withdraw
        // If user input is 4, view transaction history
        // If user input is 5, log out
        // Otherwise, print "Invalid input"

//        System.out.println("Thank you for using the ATM!");

    }
}