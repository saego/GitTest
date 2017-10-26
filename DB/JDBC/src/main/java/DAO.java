import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import source.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


class DAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(DAO.class);
    private String url = "jdbc:postgresql://localhost:5432/company";
    private String user = "ruslan";
    private String password = "7716";
    private List<Employee> employees;
    private String query;

    public DAO() {
        loadDriver();
    }

    public List<Employee> getAll(){
        this.employees = new ArrayList<>();
        LOGGER.info("Connecting to server: " + this.url);
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             Statement statement = connection.createStatement()){
            LOGGER.info("Connection successful to: " + this.url);
            this.query = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setAddress(resultSet.getString("address"));
                employee.setSalary(resultSet.getFloat("salary"));
                employee.setJoin_date(resultSet.getDate("join_date"));
                this.employees.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error("Can't connect to server: " + url, e);
            throw new RuntimeException(e);
        }
        return this.employees;
    }

    private void loadDriver() {
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
