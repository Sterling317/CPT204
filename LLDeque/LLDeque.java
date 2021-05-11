package lab5.LLDeque;

public class LLDeque<T> {

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * @return the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // LAB EXERCISE 5.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    public LLDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
    }


    // LAB EXERCISE 5.2 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     *
     * @param item is a type T object added to the deque.
     */
    public void addFirst(T item) {
        Node node = new Node(sentinel, item, sentinel.next);
//        node.next = sentinel.next;
//        node.prev = sentinel;
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }


    // LAB EXERCISE 5.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }


    // LAB EXERCISE 5.4 ITERATIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     *
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T iterGet(int index) {
        if (size == 0 || index < 0 || index > size) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }


    // EXERCISE 5.1 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item is a type T object added to the deque.
     */
    public void addLast(T item) {
//        Node p = sentinel.next;
//        while (p.next != sentinel) {
//            p = p.next;
//        }
//        Node node = new Node(null, item, null);
//        p.next = node;
//        node.prev = p;
//        node.next = sentinel;
//        sentinel.prev = node.next;
        Node p = sentinel.prev;
        Node node = new Node(null,item,null);
        p.next = node;
        node.prev = p;
        node.next = sentinel;
        sentinel.prev = node;
        size++;
    }


    // EXERCISE 5.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {
        if (sentinel.next == null) {
            return null;
        }
        Node p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size--;
        return p.item;
    }


    // EXERCISE 5.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     *
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {
        if (sentinel.next == null || sentinel.next.item == null) {
            return null;
        }
//        Node p = sentinel.next;
//        while (p.next.next != sentinel) {
//            p = p.next;
//        }
//        p.next = sentinel;
//        sentinel.prev = p.next;
//        size--;
        Node p = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return p.item;
//        if (sentinel.next == null || sentinel.next.item == null) {
//            return null;
//        }
//
//        Node delNode = sentinel.prev;
//        sentinel.prev = sentinel.prev.prev;
//        sentinel.prev.next = sentinel;
//        return delNode.item;

    }


    // EXERCISE 5.4 RECURSIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     *
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T recGet(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        T temp = null;
        if (index == 0){
            Node recNode = sentinel.next;
            return recNode.item;
        }
        sentinel = sentinel.next;
        temp = recGet(index - 1);
        sentinel = sentinel.prev;
        return temp;

    }


    public static void main(String[] args) {
        LLDeque<String> deque = new LLDeque<>();
//        deque.addFirst("b");
//        deque.addFirst("a");
//        deque.delFirst();
//        deque.printDeque();
//        deque.addLast("d");
//        deque.printDeque();
//        deque.delLast();
//        deque.printDeque();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
//        System.out.println(deque.delFirst());
        System.out.println(deque.recGet(2));
        System.out.println(deque.delFirst());
        deque.printDeque();
        System.out.println(deque.delLast());
        deque.printDeque();
        System.out.println(deque.recGet(0));
    }

}
