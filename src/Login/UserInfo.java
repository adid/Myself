package Login;
import java.util.Date;

public class UserInfo {

    private String username;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String sex;
    private String maritalStatus;
    private String nationality;

    private int income;

    private String currency;

    public UserInfo(String username, String firstName, String lastName, Date dateOfBirth, String placeOfBirth, String address,
                           String phoneNumber, String email, String sex, String maritalStatus, String nationality,int income, String currency)
    {
        this.username= username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.income= income;
        this.currency= currency;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getCurrency() {
        return currency;
    }

public void setCurrency(String currency) {
        this.currency = currency;
    }
}

