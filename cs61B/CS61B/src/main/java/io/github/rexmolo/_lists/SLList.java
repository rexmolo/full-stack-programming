package io.github.rexmolo._lists;

public class SLList<T> {

    private class StuffNode {
        public T item;
        public StuffNode next;

        public StuffNode(T i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    public StuffNode first;
    public int size;

    public SLList(T x) {
        first = new StuffNode(x, null);
        size = 1;
    }

    public void addFirst(T x) {
        first = new StuffNode(x, first);
        size += 1;
    }

    public T getFirst(){
        return first.item;
    }

    public void addLast(T x) {
        size += 1;
        StuffNode p = first;

        while (p.next != null)
            p = p.next;
        p.next = new StuffNode(x, null);
    }
    

    public static void main(String[] args) {
        SLList<String> sl = new SLList<String>("one");
        sl.addFirst("two");
        System.out.println(sl.getFirst());
    }


}
