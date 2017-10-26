import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import source.Employee;

import java.sql.*;

/**
 * Created by Saego on 25/10/2017.
 */

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        loadDriver();
        String url = "jdbc:postgresql://localhost:5432/company";
        String user = "ruslan";
        String password = "7716";
        LOGGER.info("Connecting to server: " + url);
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()){
            LOGGER.info("Connection successful to: " + url);
            String query = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setAddress(resultSet.getString("address"));
                employee.setSalary(resultSet.getFloat("salary"));
                employee.setJoin_date(resultSet.getDate("join_date"));
                System.out.println(employee);
            }
        } catch (SQLException e) {
            LOGGER.error("Can't connect to server: " + url, e);
        }
    }

    private static void loadDriver() {
        try {
            LOGGER.info("Loading JDBC DRIVER: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can't find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }


}
