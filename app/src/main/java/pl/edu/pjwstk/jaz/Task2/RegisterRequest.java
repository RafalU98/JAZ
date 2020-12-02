package pl.edu.pjwstk.jaz.Zadanie2;

public class RegisterRequest {

    private final String name;
    private final String lastName;
    private final String username;
    private final String password;

    public RegisterRequest(String name, String lastName, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
