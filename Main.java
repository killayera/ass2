import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>(2);
        a.add(7);
        a.add(5);
        a.add(16);
        a.add(3);
        a.add(13);
        a.remove(4);
        System.out.println(a.lastIndexOf(16)); //5 3 7 13 16
    }
}
