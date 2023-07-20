public class MyArrayList <T extends Comparable<T>> implements MyList<T> {
    private Object[] hiddenArray;
    private int size = 0;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 1) throw new IllegalArgumentException();
        hiddenArray = new Object[initialCapacity];
    }

    private void increaseCapacity() {
        Object[] temp = hiddenArray;
        hiddenArray = new Object[hiddenArray.length * 2];
        for (int i = 0; i < temp.length; i++) {
            hiddenArray[i] = temp[i];
        }
    }

    public MyArrayList() {
        hiddenArray = new Object[2];
    }

    public void add(T item) {
        if (size >= hiddenArray.length) increaseCapacity();
        hiddenArray[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        for(int i = size; i > index; i--) {
            hiddenArray[i] = hiddenArray[i - 1];
        }
        hiddenArray[index] = item;
        size++;
    }

    public T remove(int index) {
        T r = (T) hiddenArray[index];
        for (int i = index; i < size; i++) {
            hiddenArray[i] = hiddenArray[i + 1];
        }
        size--;
        return r;
    }

    @Override
    public boolean remove(T item) {
        for(int i = 0; i < size; i++) {
            if(hiddenArray[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public T get(int index) {

        return (T) hiddenArray[index];
    }



    public boolean contains(Object o) {
        for(int i = 0; i < size; i++) {
            if(hiddenArray[i].equals(o)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        hiddenArray = new Object[2];
    }

    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(hiddenArray[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o){
        for(int i = size - 1; i >= 0; i--){
            if(hiddenArray[i].equals(o)) return i;
        }
        return -1;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                T fElement = (T) hiddenArray[j];
                T sElement = (T) hiddenArray[j + 1];
                if(fElement.compareTo(sElement) >= 0) {
                    hiddenArray[j] = sElement;
                    hiddenArray[j + 1] = fElement;
                }
            }
        }
    }

    @Override
    public String toString() {
        String a = "";
        for (int i = 0; i < size; i++) {
            a += hiddenArray[i].toString() + " ";
        }
        return a;
    }
}
