
public class Driver implements AutoBase{
    private int driverId ;
    private String firstName ;
    private String lastName ;
    private double experianceYear;
    private String driveLicenseCategory;
    private double payForWork;

    public Driver(int driverId, String firstName, String lastName, double experianceYear, String driveLicenseCategory, double payForWork) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.experianceYear = experianceYear;
        this.driveLicenseCategory = driveLicenseCategory;
        this.payForWork = payForWork;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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

    public double getExperianceYear() {
        return experianceYear;
    }

    public void setExperianceYear(double experianceYear) {
        this.experianceYear = experianceYear;
    }

    public String getDriveLicenseCategory() {
        return driveLicenseCategory;
    }

    public void setDriveLicenseCategory(String driveLicenseCategory) {
        this.driveLicenseCategory = driveLicenseCategory;
    }

    public double getPayForWork() {
        return payForWork;
    }

    public void setPayForWork(double payForWork) {
        this.payForWork = payForWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;

        Driver driver = (Driver) o;

        if (getDriverId() != driver.getDriverId()) return false;
        if (Double.compare(driver.getExperianceYear(), getExperianceYear()) != 0) return false;
        if (Double.compare(driver.getPayForWork(), getPayForWork()) != 0) return false;
        if (!getFirstName().equals(driver.getFirstName())) return false;
        if (!getLastName().equals(driver.getLastName())) return false;
        return getDriveLicenseCategory().equals(driver.getDriveLicenseCategory());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getDriverId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        temp = Double.doubleToLongBits(getExperianceYear());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDriveLicenseCategory().hashCode();
        temp = Double.doubleToLongBits(getPayForWork());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experianceYear=" + experianceYear +
                ", driveLicenseCategory='" + driveLicenseCategory + '\'' +
                ", payForWork=" + payForWork +
                "}\n";
    }
}
