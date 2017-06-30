package Store;

import arrayList.SimpleList;

/**
 *Created by Saego on 30.06.2017.
 */
public class UserStore<E extends Base> implements Store<E>{

    private SimpleList<E> usersList = new SimpleList<E>();

    public void add(E object) {
        this.usersList.add(object);
    }

    public void remove(int position) {
        try {
            this.usersList.remove(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(E object) {
        this.usersList.remove(object);
    }

    public void set(int position, E object) {
        try {
            this.usersList.set(position, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set(E object, E newObject) {
        try {
            this.usersList.set(object, newObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getObjects() {
        return this.usersList.getObjects();
    }
}
