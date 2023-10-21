import Login.LoginSystem;

public class Main {
    public static void main(String[] args) {
        boolean session = true;

        while (session) {
            LoginSystem loginSystem = new LoginSystem();
            loginSystem.run();
            session = loginSystem.getSession();
        }

        System.out.println("Program closed.");
    }
}
