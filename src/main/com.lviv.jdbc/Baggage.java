/**
 * Created by Vitalik on 09.11.2016.
 */
public class Baggage implements AutoBase{
    private int baggageId;
    private String baggageName;
    private double baggageWeightTonn;
    private boolean glassOn;
    private double baggageCost;
    private int driverId;

    public Baggage(int baggageId, String baggageName, double baggageWeightTonn, boolean glassOn, double baggageCost, int driverId) {
        this.baggageId = baggageId;
        this.baggageName = baggageName;
        this.baggageWeightTonn = baggageWeightTonn;
        this.glassOn = glassOn;
        this.baggageCost = baggageCost;
        this.driverId = driverId;
    }

    public int getbaggageId() {
        return baggageId;
    }

    public void setbaggageId(int baggageId) {
        this.baggageId = baggageId;
    }

    public String getbaggageName() {
        return baggageName;
    }

    public void setbaggageName(String baggageName) {
        this.baggageName = baggageName;
    }

    public double getbaggageWeightTonn() {
        return baggageWeightTonn;
    }

    public void setbaggageWeightTonn(double baggageWeightTonn) {
        this.baggageWeightTonn = baggageWeightTonn;
    }

    public boolean getglassOn() {
        return glassOn;
    }

    public void setglassOn(boolean glassOn) {
        this.glassOn = glassOn;
    }

    public double getbaggageCost() {
        return baggageCost;
    }

    public void setbaggageCost(double baggageCost) {
        this.baggageCost = baggageCost;
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
        if (!(o instanceof Baggage)) return false;

        Baggage baggage = (Baggage) o;

        if (getbaggageId() != baggage.getbaggageId()) return false;
        if (Double.compare(baggage.getbaggageWeightTonn(), getbaggageWeightTonn()) != 0) return false;
        if (getglassOn() != baggage.getglassOn()) return false;
        if (Double.compare(baggage.getbaggageCost(), getbaggageCost()) != 0) return false;
        if (getDriverId() != baggage.getDriverId()) return false;
        return getbaggageName() != null ? getbaggageName().equals(baggage.getbaggageName()) : baggage.getbaggageName() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getbaggageId();
        result = 31 * result + (getbaggageName() != null ? getbaggageName().hashCode() : 0);
        temp = Double.doubleToLongBits(getbaggageWeightTonn());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getglassOn() ? 1 : 0);
        temp = Double.doubleToLongBits(getbaggageCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDriverId();
        return result;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "bagageId=" + baggageId +
                ", bagageName='" + baggageName + '\'' +
                ", bagageWeightTonn=" + baggageWeightTonn +
                ", glass_on=" + glassOn +
                ", bagageCost=" + baggageCost +
                ", driverId=" + driverId +
                "}\n";
    }
}
