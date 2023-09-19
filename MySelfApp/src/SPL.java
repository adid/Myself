import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SPL {
    public static void main(String[] args) {
        // Database connection parameters=jdbc:mysql://127.0.0.1:3306/?user=root
        //String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";


        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String dbUser = "root";
        String dbPassword = "bluemonk21";

        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {

            System.out.println("Welcome to the Login System");

            while (true) {
                System.out.println("Select an option:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        login(scanner, connection);
                        break;
                    case 2:
                        register(scanner, connection);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void login(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the provided username and password exist in the database
        String sql = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Invalid username or password.");
            }
        }
    }

    private static void register(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();

        // Check if the username already exists
        String checkUsernameSql = "SELECT * FROM users WHERE user_name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkUsernameSql)) {
            preparedStatement.setString(1, newUsername);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Username already exists. Registration failed.");
            } else {
                // Insert the new user into the database
                String insertUserSql = "INSERT INTO users (user_name,user_password) VALUES (?, ?)";

                try (PreparedStatement insertStatement = connection.prepareStatement(insertUserSql)) {
                    insertStatement.setString(1, newUsername);
                    insertStatement.setString(2, newPassword);
                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. Please try again.");
                    }
                }
            }
        }
    }
}
