package ua.jdbc;

import ua.jdbc.jdbc.DAOjdbc;

/**
 * Created by Saego on 25/10/2017.
 */

public class Main {
    public static void main(String[] args){
        DAOjdbc DAOjdbc = new DAOjdbc();
        System.out.println("-----All employees-----");
        DAOjdbc.getAll().forEach(System.out::println);
        int id = 2;
        System.out.println("-----Employee by id-----");
        System.out.println(DAOjdbc.loadById(id));
    }




}
