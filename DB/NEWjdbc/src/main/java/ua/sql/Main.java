package ua.sql;

import ua.sql.model.jdbc.JdbcEmployeeDao;

public class Main {
    public static void main(String[] args) {
        JdbcEmployeeDao jdbcEmployeeDao = new JdbcEmployeeDao();
        jdbcEmployeeDao.getAll().forEach(System.out::println);
        System.out.println("_______________");
        System.out.println(jdbcEmployeeDao.load(11));
    }

}
