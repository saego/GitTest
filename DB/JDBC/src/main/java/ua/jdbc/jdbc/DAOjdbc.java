package ua.jdbc.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.jdbc.source.DAO;
import ua.jdbc.source.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOjdbc implements DAO{
    private static final Logger LOGGER = LoggerFactory.getLogger(DAOjdbc.class);
    private String url = "jdbc:postgresql://localhost:5432/company";
    private String user = "ruslan";
    private String password = "7716";
    private List<Employee> employees;
    private String query;

    public DAOjdbc() {
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
                this.employees.add(createEmployee(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Can't connect to server: " + this.url, e);
            throw new RuntimeException(e);
        }
        return this.employees;
    }

    public Employee loadById(int id){
        try(Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return createEmployee(resultSet);
            }
            else throw new RuntimeException(id + " is not valid");
        }
        catch (SQLException e){
            LOGGER.error("Can't connect to: " + this.url, e);
            throw new RuntimeException(e);
        }
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

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setAddress(resultSet.getString("address"));
        employee.setSalary(resultSet.getFloat("salary"));
        employee.setJoin_date(resultSet.getDate("join_date"));
        return employee;
    }
}
