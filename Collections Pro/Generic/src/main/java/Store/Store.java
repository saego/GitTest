package Store;

/**
 *Created by Saego on 30.06.2017.
 */
public interface Store <E extends Base>{
    public void add(E object);
    public void remove(int position);
    public void remove(E object);
    public void set(int position, E object);
    public void set(E object, E newObject);
    public Object[] getObjects();
}
