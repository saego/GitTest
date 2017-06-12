/**
 *Created by Saego on 12.06.2017.
 */
public class User{

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
     * Get user's name.
     * @return - name.
     */
    String getName() {
        return name;
    }

    /**
     * Get user's age.
     * @return - age.
     */
    public Integer getAge() {
        return age;
    }

    public int compareTo(User o) {
        return this.name.length() - o.getName().length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return (name != null ? name.equals(user.name) : user.name == null) && (age != null ? age.equals(user.age) : user.age == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
