import java.util.*;

public class MyLinkedList<E> {
    private int size;
    private int modCount;

    Node<E> first;
    Node<E> last;

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(next, node.next) && Objects.equals(previous, node.previous) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, previous, value);
        }
    }

    public MyLinkedList() {
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
        modCount++;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    void linkBefore(E e, Node<E> succ) {
        assert succ != null;
        final Node<E> pred = succ.previous;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.previous = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.value;
        final Node<E> next = f.next;
        f.value = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.previous = null;
        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.value;
        final Node<E> prev = l.previous;
        l.value = null;
        l.previous = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.value;
        final Node<E> next = x.next;
        final Node<E> prev = x.previous;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.previous = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previous = prev;
            x.next = null;
        }

        x.value = null;
        size--;
        modCount++;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (Node<E> node = first; node.next != null; node = node.next) {
            if (node.value.equals(o))
                return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> node = first; node != null; node = node.next)
            result[i++] = node.value;
        return result;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean remove(Object o) {
        if (o == null || !contains(o))
            return false;
        for (Node<E> node = first; node != null; node = node.next) {
            if (o.equals(node.value))
                unlink(node);
        }
        return true;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.previous = null;
            x.value = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    public E get(int index) {
        assert isElementIndex(index);
        return node(index).value;
    }

    public E set(int index, E element) {
        assert isElementIndex(index);
        return node(index).value = element;
    }

    public void add(int index, E element) {
        assert isElementIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    public Object remove(int index) {
        assert isElementIndex(index);
        return unlink(node(index));
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public MyLinkedList<E> subList(int fromIndex) {
        assert isElementIndex(fromIndex);
        return subList(fromIndex, size);
    }

    public MyLinkedList<E> subList(int fromIndex, int toIndex) {
        assert isElementIndex(fromIndex) && isElementIndex(toIndex);
        MyLinkedList<E> sublist = new MyLinkedList<>();
        for (Node<E> node = node(fromIndex); !node.equals(node(toIndex)) && node.next != null; node = node.next) {
            sublist.add(node.value);
        }
        return sublist;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}