package ua.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.jdbc.controllers.EmployeeController;

/**
 * Created by Saego on 25/10/2017.
 */

public class Main {
    private EmployeeController employeeController;

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        employeeController.getAll().forEach(System.out::println);
        System.out.println(employeeController.getById(3));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
