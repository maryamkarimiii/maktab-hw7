package ir.maktab.hw7.modle;

public class Patient extends User{
    private boolean insurance;
    private String address;
    private String userName;
    private String password;

    public Patient(String firstName, String lastName, String nationalCode, boolean insurance, String address) {
        super(firstName, lastName, nationalCode);
        this.insurance = insurance;
        this.address = address;
    }
    public Patient(){}

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

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
}