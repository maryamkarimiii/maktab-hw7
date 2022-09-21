package ir.maktab.hw7.modle;

public class Doctor {
    private String firstName;
    private String lastName;
    private String GMCNumber;
    private String specialist;

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

    public String getGMCNumber() {
        return GMCNumber;
    }

    public void setGMCNumber(String GMCNumber) {
        this.GMCNumber = GMCNumber;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", GMCNumber='" + GMCNumber + '\'' +
                ", specialist='" + specialist + '\'' +
                '}';
    }
}
