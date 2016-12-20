
import java.sql.SQLException;

/*Создать сущности:
- Водитель(имя, фамилия, стаж вождения, категория прав, марки машины, которые может водить,
	города, которые обслуживает, грузы, которые может возить, плата за доставку груза).
- Грузовая машина(марка, грузоподъемность, наличие прицепа, в ремонте или нет, расход топлива на км.).
- Города(название, количество жителей, расстояние от автобазы).
- Груз(название, вес упаковки, хрупкий или нет, стоимость доставки упаковки).

Создать приложение, которое позволяет подобрать водителя для доставки определенного груза.
 Use Jdbc.*/
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Driver driver = null;
        Truck truck;
        City city;
        Baggage baggage;
        AutoBaseJdbc autoBaseJdbc = new AutoBaseJdbc("jdbc:mysql://localhost:3306", "root",
                "12345");

        autoBaseJdbc.createDataBase("autoBaseJdbc");
        autoBaseJdbc.createTableAutoBaseJdbc();
        autoBaseJdbc.insertDriverInTable(10001, "Vova", "Guba", 12, "ABC", 20000);
        autoBaseJdbc.insertDriverInTable(10002, "Vova", "Gura", 11, "BC", 18000);
        autoBaseJdbc.insertDriverInTable(10003, "Julia", "Lutsiv", 7, "ABCD", 12000);
        autoBaseJdbc.insertDriverInTable(10004, "Oleg", "Danuljuk", 3, "BC", 9000);
        autoBaseJdbc.insertDriverInTable(10005, "Igor", "Liker", 2, "ABCDF", 8000);
        autoBaseJdbc.insertDriverInTable(10006, "Vova", "Noshak", 7, "ABCDF", 12000);
        autoBaseJdbc.insertDriverInTable(10007, "Taras", "Lublinets", 20, "ABC", 33000);
        autoBaseJdbc.insertDriverInTable(10008, "Julia", "Koruto", 12, "ABCD", 20000);
        autoBaseJdbc.insertDriverInTable(10009, "Vova", "Nekoruto", 7, "BC", 11000);
        autoBaseJdbc.insertDriverInTable(100010, "Taras", "Poznanchyk", 9, "ABC", 17000);
        autoBaseJdbc.insertDriverInTable(100011, "Oleg", "Orkestr", 12, "BCDF", 19000);
        autoBaseJdbc.insertDriverInTable(100012, "Julia", "Danuljuk", 15, "ABCDF", 23000);

        autoBaseJdbc.insertTruckInTable(1230001, "Volvo-333", 35, true, true, 45, 10001);
        autoBaseJdbc.insertTruckInTable(1230002, "Mersedes-41", 25, true, true, 42, 10002);
        autoBaseJdbc.insertTruckInTable(1230003, "Renault-23", 17, true, true, 38, 10003);
        autoBaseJdbc.insertTruckInTable(1230004, "Scania-4g", 23, false, true, 37, 10004);
        autoBaseJdbc.insertTruckInTable(1230005, "Daf-3l", 33, false, false, 41, 10005);
        autoBaseJdbc.insertTruckInTable(1230006, "Renault-q1", 33, true, true, 48, 10006);
        autoBaseJdbc.insertTruckInTable(1230007, "Mersedes-2w", 30, false, true, 43, 10007);
        autoBaseJdbc.insertTruckInTable(1230008, "Daf", 41, true, true, 47, 10008);
        autoBaseJdbc.insertTruckInTable(1230009, "Volvo-2f", 33, false, false, 40, 10009);
        autoBaseJdbc.insertTruckInTable(12300010, "Scania", 45, true, true, 40, 100010);
        autoBaseJdbc.insertTruckInTable(12300011, "Mersedes", 20, false, true, 39, 100011);
        autoBaseJdbc.insertTruckInTable(12300012, "Daf-qw", 12, true, true, 39, 100012);

        autoBaseJdbc.insertBaggageInTable(3330001, "Computer", 10, true, 72, 10001);
        autoBaseJdbc.insertBaggageInTable(3330002, "Building instruments", 23.87, false, 23, 10002);
        autoBaseJdbc.insertBaggageInTable(3330003, "Block", 12.7, false, 20, 10003);
        autoBaseJdbc.insertBaggageInTable(3330004, "Telephone", 33.03, false, 33, 10004);
        autoBaseJdbc.insertBaggageInTable(3330005, "Laptop", 4.1, true, 53, 10005);
        autoBaseJdbc.insertBaggageInTable(3330006, "Cosmetic", 7.7, false, 33, 10006);
        autoBaseJdbc.insertBaggageInTable(3330007, "Information security system", 7.89, true, 100, 10007);

        autoBaseJdbc.insertCityInTable(9990001, "Lviv", 923000, 7, 10001);
        autoBaseJdbc.insertCityInTable(9990002, "Kuiv", 5000000, 653, 10002);
        autoBaseJdbc.insertCityInTable(9990003, "Chernigiv", 773700, 933, 10003);
        autoBaseJdbc.insertCityInTable(9990004, "Cherkasy", 433777, 841, 10004);
        autoBaseJdbc.insertCityInTable(9990005, "Ternopil", 353000, 300, 10005);
        autoBaseJdbc.insertCityInTable(9990006, "Rivne", 423757, 333, 10006);
        autoBaseJdbc.insertCityInTable(9990007, "Chernivci", 444444, 433, 10007);

        autoBaseJdbc.createNewTable("CREATE TABLE BASE ( baseId INT PRIMARY KEY AUTO_INCREMENT );");
        autoBaseJdbc.deleteTable("base");

        System.out.println(autoBaseJdbc.findMarkOfTruck("Volvo-333", true));
        autoBaseJdbc.updateTable();
        autoBaseJdbc.selectWithJoins();
        ((AutoBaseJdbc) autoBaseJdbc).closeConnection();
    }
}