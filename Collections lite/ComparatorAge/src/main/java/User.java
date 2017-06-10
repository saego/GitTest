/**
 Created by Saego on 10.06.2017.
 */
public class User implements Comparable<User>{
    private String name;
    private Integer age;

    /**
     * Constructor.
     * @param name - user's name.
     * @param age - user's age.
     */
    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter.
     * @return - age.
     */
    private Integer getAge() {
        return age;
    }

    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }
}
