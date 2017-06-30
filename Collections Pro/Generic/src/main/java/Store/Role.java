package Store;

/**
 *Created by Saego on 30.06.2017.
 */
public class Role extends Base {
    private String id;
    private String profession;

    public Role(String id, String id1, String profession) {
        super(id);
        this.id = id1;
        this.profession = profession;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        return profession != null ? profession.equals(role.profession) : role.profession == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role" +
                "id: '" + id + '\'' +
                ", profession: '" + profession + '\''
                ;
    }
}
