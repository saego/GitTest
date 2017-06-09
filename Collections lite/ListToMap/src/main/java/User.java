/**
 *Created by Saego on 09.06.2017.
 */
public class User {
    private int id;
    private String name;
    private String city;

    /**
     *
     * @param id - client id.
     * @param name - client's name.
     * @param city - where does it live.
     */
    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id && name.equals(user.name) && city.equals(user.city);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
