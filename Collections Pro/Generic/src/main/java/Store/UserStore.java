package Store;

import arrayList.SimpleList;

/**
 *Created by Saego on 30.06.2017.
 */
public class UserStore<E extends Base> implements Store<E>{

    private SimpleList<E> usersList = new SimpleList<E>();

    /**
     * Add new element to end of collection.
     * @param object - new element.
     */
    public void add(E object) {
        this.usersList.add(object);
    }

    /**
     * Add new element to current position of collection.
     * @param position - position to add.
     * @param object - new element.
     */
    void add(int position, E object){
        this.usersList.add(position, object);
    }

    /**
     * Remove element by position in collection.
     * @param position - position to remove.
     */
    public void remove(int position) {
        try {
            this.usersList.remove(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove element by value.
     * @param object - value of element to remove.
     */
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

    /**
     * Update element by position.
     * @param object - old value.
     * @param newObject - new value.
     */
    public void set(E object, E newObject) {
        try {
            this.usersList.set(object, newObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get list of objects.
     * @return - list to array.
     */
    public Object[] getObjects() {
        return this.usersList.getObjects();
    }
}
