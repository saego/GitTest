package Map;

import java.util.Calendar;

/**
 * Created by Saego on 01.08.2017.
 */
class User {
    private String name;
    private Calendar birthday;
    private int children;

    /**
     * Default constructor.
     * @param name - user's name.
     * @param birthday - data of user's birthday.
     * @param children - quantity of children.
     */
    User(String name, Calendar birthday, int children) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
    }
///*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + children;
        return result;
    }//*/
}
