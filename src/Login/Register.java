package Login;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;

public class Register {
    public void register() {
        Scanner scanner = new Scanner(System.in);

        // Get user input for username and password
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        String password = null;
        String confirmPassword;
        boolean validPassword = false;

        while (!validPassword) {
            System.out.print("Enter a password: ");
            password = scanner.nextLine();

            System.out.print("Confirm password: ");
            confirmPassword = scanner.nextLine();

            if (password.equals(confirmPassword) && isStrongPassword(password)) {
                validPassword = true;
            } else {
                System.out.println("Passwords do not match or password is not strong enough. Please try again.");
            }
        }

        // Get user information
        System.out.println("Enter user information:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of Birth (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();

        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthStr);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            scanner.close();
            return;
        }

        System.out.print("Place of Birth: ");
        String placeOfBirth = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Get user's sex
        System.out.println("Sex:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        int sexChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String sex = (sexChoice == 1) ? "Male" : "Female";

        // Get user's marital status
        System.out.println("Marital Status:");
        System.out.println("1. Married");
        System.out.println("2. Unmarried");
        int maritalStatusChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String maritalStatus = (maritalStatusChoice == 1) ? "Married" : "Unmarried";

        System.out.print("Nationality: ");
        String nationality = scanner.nextLine();
        System.out.print("Income: ");
        int income = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get user's preferred currency
        System.out.println("Currency:");
        System.out.println("1. BDT");
        System.out.println("2. $");
        System.out.println("3. Euro");
        int currencyChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String currency = "";
        switch (currencyChoice) {
            case 1:
                currency = "BDT";
                break;
            case 2:
                currency = "$";
                break;
            case 3:
                currency = "Euro";
                break;
        }

        // Create a user and user info
        User user = new User(username, password);
        UserInfo userInfo = new UserInfo(username, firstName, lastName, dateOfBirth, placeOfBirth, address, phoneNumber, email, sex, maritalStatus, nationality, income, currency);

        // Create a CreateUser instance
        CreateUser createUser = new CreateUser(user, userInfo);

        // Attempt to create an account
        try {
            createUser.createAccount();
            System.out.println("Account created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating account: " + e.getMessage());
        }

        scanner.close();
    }

    public static boolean isStrongPassword(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }
}