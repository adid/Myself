package Login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
        System.out.print("Sex: ");
        String sex = scanner.nextLine();
        System.out.print("Marital Status: ");
        String maritalStatus = scanner.nextLine();
        System.out.print("Nationality: ");
        String nationality = scanner.nextLine();
        System.out.print("Income: ");
        int income = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Currency: ");
        String currency = scanner.nextLine();

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