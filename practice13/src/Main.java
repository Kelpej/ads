import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(4);
        System.out.println(list);
        new Random().ints(10).forEach(list::add);
        System.out.println(list);
        var sublist = list.subList(4);
        System.out.println(sublist);
        System.out.println(list.get(0));
        list.remove(10);
        System.out.println(list);
        list.remove(Integer.valueOf(4));
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
