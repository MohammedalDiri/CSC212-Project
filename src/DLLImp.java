public class DLLImp<T> implements DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private DLLNode<T> tail;
    private int ListSize;

    public DLLImp() {
        head = current = null;
        ListSize = 0;
    }

    @Override
    public int size() {
        return ListSize;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public boolean last() {
        return current.next == null;
    }

    @Override
    public boolean first() {
        return current == head; // Or current.prev == null
    }

    @Override
    public void findFirst() {
        current = head;
    }

    @Override
    public void findNext() {
        current = current.next;
    }

    @Override
    public void findPrevious() {
        current = current.prev;
    }

    @Override
    public T retrieve() {
        return current.data;
    }

    @Override
    public void update(T val) {
        current.data = val;
    }

    @Override
    public void insert(T val) {
        if (head == null)
            head = tail = current = new DLLNode<T>(val);
        else {
            DLLNode<T> tmp = new DLLNode<T>(val);
            tmp.next = current.next;
            tmp.prev = current;
            if (current.next != null)
                current.next.prev = tmp;

            current.next = tmp;
            current = tmp;
            if (current.next == null)
                tail = current;
        }
        ListSize++;
    }

    @Override
    public void remove() {
        if (current == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            current.prev.next = current.next;
            if (current.next != null)
                current.next.prev = current.prev;
            else
                tail = tail.prev;
        }
        if (last())
            current = head;
        else
            current = current.next;

        ListSize--;
    }

    public DLLNode<T> getLast() {
        return tail;
    }

    public static <T> void display(DLL<T> L) {
        if (L.empty())
            return;
        L.findFirst();
        while (!L.last()) {
            System.out.println(L.retrieve() + " ");
            L.findNext();
        }
        System.out.println(L.retrieve());
        System.out.println("num of existing elements=" + L.size());
    }
}
