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

    @Override
    public Employee load(int id) {
        /*try (Connection connection = dataSource.getConnection();
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
            LOGGER.error("Can't connect to model", e);
            throw new RuntimeException(e);
        }*/

        //
        return null;
        //
    }

    @Override
    public List<Employee> getAll(){

        List<Employee> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ){
            String sql = "SELECT * FROM company.public.employee";
            /*ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                result.add(createEmployee(resultSet));
            }*/
            //
            System.out.println("!!!!");
            //

        } catch (SQLException e) {
            LOGGER.error("Can't connect to model", e);
            throw new RuntimeException(e);
        }

        return result;
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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

