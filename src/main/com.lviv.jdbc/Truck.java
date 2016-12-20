/**
 * Created by Vitalik on 09.11.2016.
 */
public class Truck implements AutoBase{
    private int truckId;
    private String markOfTruck;
    private double truckCapacityTonn;
    private boolean conectingToTruck;
    private boolean crashed;
    private double gaslitresBy100km;
    private int driverId;

    public Truck(int truckId, String markOfTruck, double truckCapacityTonn, boolean conectingToTruck, boolean crashed, double gaslitresBy100km, int driverId) {
        this.truckId = truckId;
        this.markOfTruck = markOfTruck;
        this.truckCapacityTonn = truckCapacityTonn;
        this.conectingToTruck = conectingToTruck;
        this.crashed = crashed;
        this.gaslitresBy100km = gaslitresBy100km;
        this.driverId = driverId;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public String getMarkOfTruck() {
        return markOfTruck;
    }

    public void setMarkOfTruck(String markOfTruck) {
        this.markOfTruck = markOfTruck;
    }

    public double getTruckCapacityTonn() {
        return truckCapacityTonn;
    }

    public void setTruckCapacityTonn(double truckCapacityTonn) {
        this.truckCapacityTonn = truckCapacityTonn;
    }

    public boolean isConectingToTruck() {
        return conectingToTruck;
    }

    public void setConectingToTruck(boolean conectingToTruck) {
        this.conectingToTruck = conectingToTruck;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public double getGaslitresBy100km() {
        return gaslitresBy100km;
    }

    public void setGaslitresBy100km(double gaslitresBy100km) {
        this.gaslitresBy100km = gaslitresBy100km;
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
        if (!(o instanceof Truck)) return false;

        Truck truck = (Truck) o;

        if (getTruckId() != truck.getTruckId()) return false;
        if (Double.compare(truck.getTruckCapacityTonn(), getTruckCapacityTonn()) != 0) return false;
        if (isConectingToTruck() != truck.isConectingToTruck()) return false;
        if (isCrashed() != truck.isCrashed()) return false;
        if (Double.compare(truck.getGaslitresBy100km(), getGaslitresBy100km()) != 0) return false;
        if (getDriverId() != truck.getDriverId()) return false;
        return getMarkOfTruck().equals(truck.getMarkOfTruck());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTruckId();
        result = 31 * result + getMarkOfTruck().hashCode();
        temp = Double.doubleToLongBits(getTruckCapacityTonn());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isConectingToTruck() ? 1 : 0);
        result = 31 * result + (isCrashed() ? 1 : 0);
        temp = Double.doubleToLongBits(getGaslitresBy100km());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDriverId();
        return result;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", markOfTruck='" + markOfTruck + '\'' +
                ", truckCapacityTonn=" + truckCapacityTonn +
                ", conectingToTruck=" + conectingToTruck +
                ", crashed=" + crashed +
                ", gaslitresBy100km=" + gaslitresBy100km +
                ", driverId=" + driverId +
                "}\n";
    }
}
