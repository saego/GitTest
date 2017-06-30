import java.util.Arrays;

/**
 *Created by Saego on 27.06.2017.
 */
class SimpleList <E> {

    private Object[] objects;
    private int index = 0;

    SimpleList() {
        this.objects = new Object[10];
    }

    /**
     * Add new element to collection.
     * @param object - new element.
     */
    void add(E object) {
        if (index == this.objects.length) {
            Object[] tempObjects = new Object[(this.objects.length * 3) / 2 + 1];
            System.arraycopy(this.objects, 0, tempObjects, 0, this.objects.length);
            this.objects = tempObjects;
        }
        this.objects[index++] = object;
    }

    void add(int position, E object){
        if (this.objects.length - 1 == index){
            Object[] tempObjects = new Object[(this.objects.length * 3) / 2 + 1];
            System.arraycopy(this.objects, 0, tempObjects, 0, this.objects.length);
            this.objects = tempObjects;
        }
        System.arraycopy(this.objects, position - 1, this.objects, position, index + 1 - position);
        this.objects[position] = object;
        index = index + 1;
    }
    /**
     * Remove element from collection.
     * @param position - position of element to remove.
     * @throws Exception - incorrect position.
     */
    void remove(int position) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        } else {
            int i = position;
            while (this.objects[i] != null) {
                this.objects[i] = this.objects[i + 1];
                i++;
            }
            Object[] tempObjects = new Object[this.objects.length - 1];
            System.arraycopy(this.objects, 0, tempObjects, 0, tempObjects.length);
            this.objects = tempObjects;
            index = index - 1;
        }
    }

    /**
     * Set new value of element.
     * @param position - position of element should be changed.
     * @param newObject - new value of element.
     * @throws Exception - if there is no such position.
     */
    void set(int position, E newObject) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        }
        this.objects[position] = newObject;
    }

    /**
     * Set new value of element.
     * @param object - value of element should be changed.
     * @param newObject - new value of element.
     * @throws Exception - if there is no such position.
     */
    void set(E object, E newObject) throws Exception {
        int position = getIndexOfObject(object);
        if (position == this.objects.length){
            throw new Exception("No such element");
        }
        else {
            this.objects[position] = newObject;
        }
    }

    /**
     * Get value of element by position.
     * @param position - position for get.
     * @return - element.
     * @throws Exception - if there is no such position.
     */
    E get(int position) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        } else {
            return (E) this.objects[position];
        }
    }

    /**
     * Size of collection.
     * @return - size without null.
     */
    int size(){
        return index;
    }

    Object[] getObjects(){
        Object[] show = new Object[size()];
        System.arraycopy(this.objects, 0, show, 0, show.length);
        return show;
    }

    /**
     * Get index of element by value.
     * @param object - value of element to search.
     * @return - position of element or value bigger than array.length.
     */
    private int getIndexOfObject(E object) {
        int pos = 0;
        for (Object obj :
                this.objects) {
            if (obj.equals(object)) {
                break;
            }
            pos++;
        }
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleList<?> that = (SimpleList<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(objects, that.objects);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(objects);
    }

    @Override
    public String toString() {
        return "SimpleList{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}

