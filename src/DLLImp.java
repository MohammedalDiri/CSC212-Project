public class DLLImp<T> implements DLL<T>{
    private DLLNode<T> head;
    private DLLNode<T> current;
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
    public void findPrevious() { current = current.prev ; }

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
        if(head == null)
            head = current = new DLLNode<T>(val);
        else{
            DLLNode<T> tmp = new DLLNode<T>(val);
            tmp.next = current.next;
            tmp.prev = current;
            if(current.next != null)
                current.next.prev = tmp;

            current.next = tmp;
            current = tmp;
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
        }
        if (last())
            current = head;
        else
            current = current.next;

        ListSize--;
    }
}
