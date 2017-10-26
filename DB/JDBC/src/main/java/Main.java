/**
 * Created by Saego on 25/10/2017.
 */

public class Main {
    public static void main(String[] args){
        DAO dao = new DAO();
        dao.getAll().forEach(System.out::println);
    }




}
