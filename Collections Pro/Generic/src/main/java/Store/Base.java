package Store;

/**
 *Created by Saego on 30.06.2017.
 */
public abstract class Base {
   private String id;

    Base(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
