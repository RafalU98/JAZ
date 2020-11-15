package pl.edu.pjwstk.jaz.Zadanie2;

public class RegisterRequest {

    private String name;
    private String lastName;
    private String username;
    private String password;
    private String secondPassword;
    private String userEmail;
    private String dateOfBirth;

    public void RegisterRequest(String name, String lastName, String username, String password,
                                String secondPassword, String userEmail, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.secondPassword = secondPassword;
        this.userEmail = userEmail;
        this.dateOfBirth = dateOfBirth;
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

    public String getSecPassword() {
        return secondPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
