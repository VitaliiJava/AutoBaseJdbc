
public class City implements AutoBase{
    private int cityId;
    private String cityName;
    private int countOfPeople;
    private double widthForBaseKm;
    private int driverId;

    public City(int cityId, String cityName, int countOfPeople, double widthForBaseKm, int driverId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countOfPeople = countOfPeople;
        this.widthForBaseKm = widthForBaseKm;
        this.driverId = driverId;
    }

    public int getcityId() {
        return cityId;
    }

    public void setcityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public double getWidthForBaseKm() {
        return widthForBaseKm;
    }

    public void setWidthForBaseKm(double widthForBaseKm) {
        this.widthForBaseKm = widthForBaseKm;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        if (getcityId() != city.getcityId()) return false;
        if (getCountOfPeople() != city.getCountOfPeople()) return false;
        if (Double.compare(city.getWidthForBaseKm(), getWidthForBaseKm()) != 0) return false;
        if (getDriverId() != city.getDriverId()) return false;
        return getCityName() != null ? getCityName().equals(city.getCityName()) : city.getCityName() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getcityId();
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + getCountOfPeople();
        temp = Double.doubleToLongBits(getWidthForBaseKm());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDriverId();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", countOfPeople=" + countOfPeople +
                ", widthForBaseKm=" + widthForBaseKm +
                ", driverId=" + driverId +
                "}\n";
    }
}
