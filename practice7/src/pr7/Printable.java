package pr7;

import java.util.LinkedList;
import java.util.List;

public interface Printable {
    List<Integer> list = new LinkedList<>();
    default String print() {
        return "zalupa";
    };
}
