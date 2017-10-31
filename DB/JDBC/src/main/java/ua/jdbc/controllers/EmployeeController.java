package ua.jdbc.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ua.jdbc.jdbc.DAOjdbc;
import ua.jdbc.source.Employee;

import java.util.List;

public class EmployeeController {
    private PlatformTransactionManager txManager;
    private DAOjdbc daOjdbc;

    public List<Employee> getAll(){
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Employee> employees = daOjdbc.getAll();
            txManager.commit(status);
            return employees;
        }
        catch (Exception e){
            txManager.rollback(status);
            throw new RuntimeException(e);
        }
    }

    public Employee getById(int id){
            Employee employee = daOjdbc.loadById(id);
            return employee;

    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDaOjdbc(DAOjdbc daOjdbc) {
        this.daOjdbc = daOjdbc;
    }
}
