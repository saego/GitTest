package ua.sql.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ua.sql.model.Employee;

import java.util.List;

public class EmployeeController {

    private PlatformTransactionManager txManager;

    public List<Employee> getAllEmployees(){
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));

    }
}
