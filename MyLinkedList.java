public class MyLinkedList<E> {
    private class Node {
        E data;
        Node next;
        Node prev;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(E item) {
        size++;
        if (head == null) {
            head = new Node(item);
            tail = head;
            return;
        }

        tail.next = new Node(item);
        tail.next.prev = tail;
        tail = tail.next;

    }

    public E get(int index) {
        Node start;
        if (size / 2 > index) {
            start = head;
            for (int i = 0; i < index; i++) {
                start = start.next;
            }
        } else {
            start = tail;
            for (int i = 0; i < size - index - 1; i++) {
                start = start.prev;
            }
        }

        return start.data;
    }

    public E remove(int index) {
        size--;
        E ret;
        if (index == 0) {
            ret = head.data;
            head = head.next;
            head.prev = null;
            return ret;
        }

        if (index == size) {
            ret = tail.data;
            tail = tail.prev;
            tail.next = null;
            return ret;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return current.data;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "";
        Node a;
        for (a = head; a != tail; a = a.next) {
            result += a.data + " ";
        }
        result += a.data;
        return result;
    }

    public String toStringReverse() {
        String result = "";
        Node a;
        for (a = tail; a != head; a = a.prev) {
            result += a.data + " ";
        }
        result += a.data;
        return result;
    }
}
