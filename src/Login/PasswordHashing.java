package Login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordHashing
{

    public static String hashPassword(String password) {
        try
        {
            MessageDigest md ;
            md = MessageDigest.getInstance("SHA-256");

            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes)
            {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Error hashing the password", e);
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter your password: ");
//        String password = scanner.nextLine();
//
//        // Hash the password
//        String hashedPassword = hashPassword(password);
//
//        System.out.println("Original Password: " + password);
//        System.out.println("Hashed Password: " + hashedPassword);
//    }

}
