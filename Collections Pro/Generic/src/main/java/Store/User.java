package Store;

/**
 *Created by Saego on 30.06.2017.
 */
public class User extends Base{
   private String name;
   private String id;
   private int age;

    User(String id, String name, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return age == user.age && (name != null ? name.equals(user.name) : user.name == null) && (id != null ? id.equals(user.id) : user.id == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return
                "name: '" + name + '\'' +
                ", id: '" + id + '\'' +
                ", age: " + age
               ;
    }
}
