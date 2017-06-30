package Store;

/**
 *Created by Saego on 30.06.2017.
 */
public class User extends Base{
   private String name;
   private String id;
   private int age;

    public User(String id, String name, String id1, int age) {
        super(id);
        this.name = name;
        this.id = id1;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return id != null ? id.equals(user.id) : user.id == null;
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
