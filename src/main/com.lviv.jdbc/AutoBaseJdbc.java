
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoBaseJdbc {
    private Connection connection;
    private PreparedStatement ps;

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AutoBaseJdbc(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDataBase(String dataBaseName) {
        try {
            ps = connection.prepareStatement("DROP DATABASE IF EXISTS " + dataBaseName);
            ps.execute();

            ps = connection.prepareStatement("CREATE DATABASE " + dataBaseName);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewTable(String tableNameFields) {
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();

            ps = connection.prepareStatement(tableNameFields);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable(String tableName) {
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection.prepareStatement("DROP TABLE " + tableName);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableAutoBaseJdbc() {
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection.prepareStatement("CREATE TABLE driver (\n" +
                    "    driverId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    firstName VARCHAR(50) NOT NULL,\n" +
                    "    lastName VARCHAR(50) NOT NULL,\n" +
                    "    experianceYear DOUBLE,\n" +
                    "    driveLicenseCategory VARCHAR(50) NOT NULL,\n" +
                    "    payForWork DOUBLE\n" +
                    ");");
            ps.execute();
            ps = connection.prepareStatement("CREATE TABLE truck (\n" +
                    "    truckId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    markOfTruck VARCHAR(50) NOT NULL,\n" +
                    "    truckCapacityTonn DOUBLE,\n" +
                    "    conectingToTruck BOOLEAN,\n" +
                    "    crashed BOOLEAN,\n" +
                    "    gaslitresBy100km DOUBLE,\n" +
                    "    driverId INT,\n" +
                    "    CONSTRAINT fk_truck_driver FOREIGN KEY (driverId)\n" +
                    "        REFERENCES driver (driverId)\n" +
                    "        ON DELETE SET NULL ON UPDATE SET NULL\n" +
                    ");");
            ps.execute();
            ps = connection.prepareStatement("CREATE TABLE baggage (\n" +
                    "    baggageId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    baggageName VARCHAR(50) NOT NULL,\n" +
                    "    baggageWeightTonn DOUBLE,\n" +
                    "    glassOn BOOLEAN,\n" +
                    "    baggageCost DOUBLE,\n" +
                    "    driverId INT,\n" +
                    "    CONSTRAINT fk_baggage_driver FOREIGN KEY (driverId)\n" +
                    "        REFERENCES driver (driverId)\n" +
                    "        ON DELETE SET NULL ON UPDATE SET NULL\n" +
                    ");");
            ps.execute();
            ps = connection.prepareStatement("CREATE TABLE city (\n" +
                    "    cityId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    cityName VARCHAR(50) NOT NULL,\n" +
                    "    countOfPeople INT,\n" +
                    "    widthForBaseKm DOUBLE,\n" +
                    "    driverId INT,\n" +
                    "    CONSTRAINT fk_city_driver FOREIGN KEY (driverId)\n" +
                    "        REFERENCES driver (driverId)\n" +
                    "        ON DELETE SET NULL ON UPDATE SET NULL\n" +
                    ");");
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver insertDriverInTable(int driverId, String firstName, String lastName, double experianceYear,
                                      String driveLicenseCategory, double payForWork) {
        Driver driver = new Driver(driverId, firstName, lastName, experianceYear, driveLicenseCategory, payForWork);
        try {
            ps = connection.prepareStatement("INSERT INTO autoBaseJdbc.driver (driverId, " +
                    "firstName, " +
                    "lastName, " +
                    "experianceYear, " +
                    "driveLicenseCategory, " +
                    "payForWork) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, driverId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setDouble(4, experianceYear);
            ps.setString(5, driveLicenseCategory);
            ps.setDouble(6, payForWork);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public Truck insertTruckInTable(int truckId, String markOfTruck, double truckCapacityTonn, boolean conectingToTruck,
                                    boolean crashed, double gaslitresBy100km, int driverId) {
        Truck truck = new Truck(truckId, markOfTruck, truckCapacityTonn, conectingToTruck, crashed, gaslitresBy100km,
                driverId);
        try {
            ps = connection
                    .prepareStatement("INSERT INTO autoBaseJdbc.truck (truckId, markOfTruck, truckCapacityTonn," +
                            " conectingToTruck, crashed, gaslitresBy100km, driverId) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, truckId);
            ps.setString(2, markOfTruck);
            ps.setDouble(3, truckCapacityTonn);
            ps.setBoolean(4, conectingToTruck);
            ps.setBoolean(5, crashed);
            ps.setDouble(6, gaslitresBy100km);
            ps.setInt(7, driverId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return truck;
    }

    public Baggage insertBaggageInTable(int baggageId, String baggageName, double baggageWeightTonn, boolean glassOn, double baggageCost, int driverId) {
        Baggage baggage = new Baggage(baggageId, baggageName, baggageWeightTonn, glassOn, baggageCost, driverId);
        try {
            ps = connection
                    .prepareStatement("INSERT INTO autoBaseJdbc.baggage (baggageId, baggageName, baggageWeightTonn, glassOn, baggageCost, driverId) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, baggageId);
            ps.setString(2, baggageName);
            ps.setDouble(3, baggageWeightTonn);
            ps.setBoolean(4, glassOn);
            ps.setDouble(5, baggageCost);
            ps.setInt(6, driverId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baggage;
    }

    public City insertCityInTable(int cityId, String cityName, int countOfPeople, double widthForBaseKm, int driverId) {

        City city = new City(cityId, cityName, countOfPeople, widthForBaseKm, driverId);
        try {
            ps = connection
                    .prepareStatement("INSERT INTO autoBaseJdbc.city (cityId, cityName, countOfPeople, widthForBaseKm, driverId) VALUES ( ?, ?, ?, ?, ?)");
            ps.setInt(1, cityId);
            ps.setString(2, cityName);
            ps.setInt(3, countOfPeople);
            ps.setDouble(4, widthForBaseKm);
            ps.setInt(5, driverId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    public List<AutoBase> findAll(AutoBase autoBase) {
        List<AutoBase> objects = new ArrayList<>();
        ResultSet results = null;
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection.prepareStatement("select * from driver");
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (results.next()) {
                AutoBase o = new Driver(results.getInt("driverId"),
                        results.getString("firstName"),
                        results.getString("lastName"),
                        results.getDouble("experianceYear"),
                        results.getString("driveLicenseCategory"),
                        results.getDouble("payForWork"));
                objects.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public List<Truck> findByGasBetween(int from, int until) {
        List<Truck> trucks = new ArrayList<>();
        ResultSet results = null;

        if (from < 0 || until < 0) {
            from = Math.abs(from);
            until = Math.abs(until);
        }
        if (from > until) {
            int temp = until;
            until = from;
            from = temp;
        }

        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection
                    .prepareStatement("select * from truck where gaslitresBy100km between ? and ?");
            ps.setInt(1, from);
            ps.setInt(2, until);
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (results.next()) {
                Truck tr = new Truck(results.getInt("truckId"),
                        results.getString("markOfTruck"),
                        results.getDouble("truckCapacityTonn"),
                        results.getBoolean("conectingToTruck"),
                        results.getBoolean("crashed"),
                        results.getDouble("gaslitresBy100km"),
                        results.getInt("driverId"));
                trucks.add(tr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public List<Truck> findMarkOfTruck(String markOfCar, boolean connectionToTruck) {
        List<Truck> trucks = new ArrayList<>();
        ResultSet results = null;
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection
                    .prepareStatement("select * from truck where markOfTruck = ? and conectingToTruck = ?");
            ps.setString(1, markOfCar);
            ps.setBoolean(2, connectionToTruck);
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (results.next()) {
                Truck tr;
                tr = new Truck(results.getInt("truckId"),
                        results.getString("markOfTruck"),
                        results.getDouble("truckCapacityTonn"),
                        results.getBoolean("conectingToTruck"),
                        results.getBoolean("crashed"),
                        results.getDouble("gaslitresBy100km"),
                        results.getInt("driverId"));
                trucks.add(tr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trucks;
    }

    public void updateTable() throws SQLException, ClassNotFoundException {
        String query = "UPDATE driver SET driveLicenseCategory = ? WHERE experianceYear BETWEEN 2 AND 3";
        String queryDriver = "Select driveLicenseCategory from driver WHERE experianceYear BETWEEN 2 AND 3";
        ResultSet results = null;
        String count = null;
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection.prepareStatement(queryDriver);
            results = ps.executeQuery();
            ps = connection.prepareStatement(query);
            while (results.next()) {
                count = results.getString("driveLicenseCategory");
                ps.setString(1, count + "R");
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectWithJoins() throws SQLException, ClassNotFoundException {
        String queryForJoin = "SELECT \n" +
                "        d.driverId,\n" +
                "        d.firstName,\n" +
                "        d.lastName,\n" +
                "        d.payForWork,\n" +
                "        d.experianceYear,\n" +
                "        tr.markOfTruck,\n" +
                "        tr.truckCapacityTonn,\n" +
                "        tr.conectingToTruck,\n" +
                "        tr.crashed,\n" +
                "        tr.gaslitresBy100km,\n" +
                "        b.baggageName,\n" +
                "        b.baggageWeightTonn,\n" +
                "        b.glassOn,\n" +
                "        b.baggageCost,\n" +
                "        c.cityName,\n" +
                "        c.widthForBaseKm\n" +
                "    FROM\n" +
                "        truck tr\n" +
                "            INNER JOIN\n" +
                "        driver d ON tr.driverId = d.driverId\n" +
                "            INNER JOIN\n" +
                "        city c ON d.driverId = c.driverId\n" +
                "            INNER JOIN\n" +
                "        baggage b ON d.driverId = b.driverId" +
                "    WHERE\n" +
                "        d.experianceYear >= 12;";
        ResultSet results = null;
        try {
            ps = connection.prepareStatement("USE autoBaseJdbc");
            ps.execute();
            ps = connection.prepareStatement(queryForJoin);
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (results.next()) {
                int driverId = results.getInt("driverId");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                double experianceYear = results.getDouble("experianceYear");
                double payForWork = results.getDouble("payForWork");
                String markOfTruck = results.getString("markOfTruck");
                double truckCapacityTonn = results.getDouble("truckCapacityTonn");
                boolean conectingToTruck = results.getBoolean("conectingToTruck");
                boolean crashed = results.getBoolean("crashed");
                double gaslitresBy100km = results.getDouble("gaslitresBy100km");
                String baggageName = results.getString("baggageName");
                double baggageWeightTonn = results.getDouble("baggageWeightTonn");
                boolean glassOn = results.getBoolean("glassOn");
                double baggageCost = results.getDouble("baggageCost");
                String cityName = results.getString("cityName");
                double widthForBaseKm = results.getDouble("widthForBaseKm");
                System.out.println(driverId + " " +
                        firstName + " " +
                        lastName + " " +
                        experianceYear + " " +
                        payForWork + " " +
                        markOfTruck + " " +
                        truckCapacityTonn + " " +
                        conectingToTruck + " " +
                        crashed + " " +
                        gaslitresBy100km + " " +
                        baggageName + " " +
                        baggageWeightTonn + " " +
                        glassOn + " " +
                        baggageCost + " " +
                        cityName + " " +
                        widthForBaseKm + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

