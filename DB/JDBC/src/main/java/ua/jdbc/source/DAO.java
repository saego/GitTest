package ua.jdbc.source;

import java.util.List;

public interface DAO {
    List<Employee> getAll();
    Employee loadById(int id);
}
