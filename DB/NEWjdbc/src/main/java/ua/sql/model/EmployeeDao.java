package ua.sql.model;

import java.util.List;

public interface EmployeeDao {
    Employee load(int id);

    List<Employee> getAll();
}
