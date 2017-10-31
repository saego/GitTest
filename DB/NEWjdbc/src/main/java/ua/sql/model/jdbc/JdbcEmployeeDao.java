package ua.sql.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.sql.model.Employee;
import ua.sql.model.EmployeeDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

    private DataSource dataSource;

    private  static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDao.class);
    private String url = "jdbc:postgresql://localhost:5432/company";
    private String user = "ruslan";
    private String password = "7716";
    public JdbcEmployeeDao() {
        loadDriver();
    }

    @Override
    public Employee load(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM company.public.employee WHERE id = ?")
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return createEmployee(resultSet);
            }
            else {
                throw new RuntimeException("Invalid id");
            }

        } catch (SQLException e) {
            LOGGER.error("Can't connect to model" + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll(){

        List<Employee> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()
        ){

            String sql = "SELECT * FROM company.public.employee";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                result.add(createEmployee(resultSet));
            }

        } catch (SQLException e) {
            LOGGER.error("Can't connect to model" + e);
            throw new RuntimeException(e);
        }

        return result;
    }

    private void loadDriver() {
        try {
            LOGGER.info("Loading driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver load successful");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can't find driver");
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
        employee.setJoinDate(resultSet.getDate("join_date"));
        return employee;
    }
}

