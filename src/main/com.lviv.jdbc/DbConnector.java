import java.sql.*;
import java.util.Collections;

public class DbConnector {
    private static Connection connection;

    public static final String url = "jdbc:mysql://localhost:3306/forlearning?user=root&password=12345";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }


    public static String runSimpleQuery() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM man WHERE man_id = 1";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String firstName = null;
        while (resultSet.next()) {
            firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            int countOfChildren = resultSet.getInt(4);
            System.out.println(firstName + " " + lastName + " " + countOfChildren);
        }

        return firstName;
    }

    public static void runPreparedStatement() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM man WHERE first_name = ? AND count_of_children = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, "Vladimir");
        preparedStatement.setInt(2, 2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int countOfChildren = resultSet.getInt("count_of_children");
            System.out.println(firstName + " " + lastName + " " + countOfChildren);
        }
    }

    public static void runUpdatePreparedStatement() throws SQLException, ClassNotFoundException {
        String query = "UPDATE man SET first_name = ? WHERE count_of_children = 2";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, "Vitalik");
        preparedStatement.executeUpdate();
    }

    public static void runPreparedStatementWithJoins() throws SQLException, ClassNotFoundException {
        String queryForJoin = "SELECT * FROM man m INNER JOIN address a " +
                "ON m.address_id = a.address_id";
        PreparedStatement preparedStatement = getConnection().prepareStatement(queryForJoin);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String address = resultSet.getString("street");
            System.out.println(firstName + " " + address);
        }
    }

    public static void runPreparedStatementWithINClause(int... array) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM man WHERE man_id IN(%s)";
        int length = array.length;
        String joinString = String.join(",", Collections.nCopies(length, "?"));
        String finishedQuery = String.format(query, joinString);
        PreparedStatement preparedStatement = getConnection().prepareStatement(finishedQuery);

        for (int i = 0; i < length; ++i) {
            preparedStatement.setObject(i + 1, array[i]);
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int countOfChildren = resultSet.getInt("count_of_children");
            System.out.println(firstName + " " + lastName + " " + countOfChildren);
        }
    }

    public static void useCallableStatement() throws SQLException, ClassNotFoundException {
        String callProcedure = "{ CALL getAllMenInfo(?) }";
        CallableStatement callableStatement = getConnection().prepareCall(callProcedure);
        callableStatement.setInt(1, 3);
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            System.out.println(first_name + " " + last_name);

        }

        callableStatement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println(DbConnector.runSimpleQuery());
//        DbConnector.runPreparedStatement();
//        DbConnector.runUpadtePreparedStatement();
//        DbConnector.runPreparedStatementWithJoins();
//        DbConnector.runPreparedStatementWithINClause(1, 2, 5);
        DbConnector.useCallableStatement();
    }
}
