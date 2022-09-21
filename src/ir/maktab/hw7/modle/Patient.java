package ir.maktab.hw7.modle;

public class Patient extends User{
    private String address;
    private String userName;
    private String password;

    public Patient(String firstName, String lastName, String nationalCode, String address) {
        super(firstName, lastName, nationalCode);
        this.address = address;
    }

    public Patient(String nationalCode) {
        super(nationalCode);
    }

    public Patient(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}