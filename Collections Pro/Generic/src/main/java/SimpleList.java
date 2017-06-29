/**
 *Created by Saego on 27.06.2017.
 */
class SimpleList <E> {

    private Object[] objects;
    private int index = 0;

    SimpleList() {
        this.objects = new Object[10];
    }

    void add(E object) {
        if (index == this.objects.length) {
            Object[] tempObjects = new Object[(this.objects.length * 3) / 2 + 1];
            System.arraycopy(this.objects, 0, tempObjects, 0, this.objects.length);
            this.objects = tempObjects;
        }
        this.objects[index++] = object;
    }

    void remove(int position) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        } else {
            int i = position;
            while (this.objects[i] != null) {
                this.objects[position] = this.objects[position + 1];
                i++;
            }
            Object[] tempObjects = new Object[this.objects.length - 1];
            System.arraycopy(this.objects, 0, tempObjects, 0, tempObjects.length);
            this.objects = tempObjects;
        }
    }

    void set(int position, E newObject) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        }
        this.objects[position] = newObject;
    }

    void set(E object, E newObject) throws Exception {
        int position = getIndexofObject(object);
        if (position == this.objects.length){
            throw new Exception("No such element");
        }
        else {
            this.objects[position] = newObject;
        }
    }

    E get(int position) throws Exception {
        if ((position >= this.objects.length) || (this.objects[position] == null)) {
            throw new Exception("No such element");
        } else {
            return (E) this.objects[position];
        }
    }

    private int getIndexofObject(E object) {
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
}

