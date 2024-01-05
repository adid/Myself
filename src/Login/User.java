package Login;

import static Login.PasswordHashing.hashPassword;

public class User {
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username = username;
        //this.password = password;
        this.password = PasswordHashing.hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PasswordHashing.hashPassword(password);
    }
}