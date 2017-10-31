package ua.sql.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String address;
    private float salary;
    private Date joinDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setJoinDate(Date join_date) {
        this.joinDate = join_date;
    }

    @Override
    public String toString() {
        return "ua.sql.model.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", join_date=" + joinDate +
                '}';
    }
}
