package Store;

import arrayList.SimpleList;

/**
 *Created by Saego on 30.06.2017.
 */
public class RoleStore<E extends Base> implements Store<E> {

    private SimpleList<E> rolesList = new SimpleList<E>();

    public void add(E object) {
        this.rolesList.add(object);
    }

    public void remove(int position) {
        try {
            this.rolesList.remove(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(E object) {
        this.rolesList.remove(object);
    }

    public void set(int position, E object) {
        try {
            this.rolesList.set(position, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set(E object, E newObject) {
        try {
            this.rolesList.set(object, newObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getObjects() {
        return this.rolesList.getObjects();
    }
}
