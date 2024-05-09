public class DLLCompImp<T extends Comparable<T>> implements DLLComp<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private DLLNode<T> tail ;
    private int ListSize;
    private boolean increasing;
    private boolean isSorted = false;

    public DLLCompImp() {
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
        return current == tail ;
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

    private T LastElement() {
        return tail.data;
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
        if(head == null)
            head = tail = current = new DLLNode<T>(val);
        else{
            DLLNode<T> tmp = new DLLNode<T>(val);
            tmp.next = current.next;
            tmp.prev = current;
            if(current.next != null)
                current.next.prev = tmp;

            current.next = tmp;
            current = tmp;
            if(current.next == null)
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


    @Override
    public void sort(boolean increasing) { // In this method merge sort will be used, as each element in the list will be inserted into an array where the sort will be done.
        if (head == null || head.next == null) // If the list is empty ot there's only on element then no sorting shall happen.
        {}
        else {
            this.increasing = increasing; // this will help with the two following methods.
            isSorted = true; // this will help with the two following methods.

            T[] Dl = (T[]) new Comparable[ListSize];
            int index = 0;
            findFirst();
            while (!empty()) {
                Dl[index++] = retrieve();
                remove(); // This loop inserts each element into the array and removes it from the list to then insert it back to the list sorted.
            }

            mergesort(Dl, 0, Dl.length - 1); //The list gets sorted.
            if (increasing)
                for (int i = 0; i < Dl.length; i++)
                    this.insert(Dl[i]); // If the list is wanted in increasing order then it will be inserted normally.
            else
                for (int i = Dl.length - 1; i >= 0; i--)
                    this.insert(Dl[i]); // else if the list is wanted in decreasing order then it will be inserted in reverse.
        }
    }

    @Override
    public T getMax() { // This method requires list must not be empty.
        if (isSorted) // If the list is sorted check the order.
            if (!increasing) // If in increasing order return the first element else return the last element.
                return head.data;
            else
                return LastElement();

        else {
            T max = head.data;
            DLLNode<T> tmp = head.next;

            while (tmp != null) {
                if (tmp.data.compareTo(max) > 0)
                    max = tmp.data;

                tmp = tmp.next;
            }
            return max;
        }
    }

    @Override
    public T getMin() {
        if (isSorted) // If the list is sorted check the order.
            if (increasing) // If in decreasing order return the first element else return the last element.
                return head.data;
            else
                return LastElement();

        else {
            T min = head.data;
            DLLNode<T> tmp = head.next;

            while (tmp != null) {
                if (tmp.data.compareTo(min) < 0)
                    min = tmp.data;

                tmp = tmp.next;
            }
            return min;
        }

    }

    private void mergesort(T[] a, int l, int r) //Helper method for the merge
    {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        mergesort(a, l, m);
        mergesort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private void merge(T[] A, int l, int m, int r) //Helper method for the merge
    {
        T[] B = (T[]) new Comparable[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (A[i].compareTo(A[j]) <= 0)
                B[k++] = A[i++];
            else
                B[k++] = A[j++];
        }

        if (i > m)
            while (j <= r)
                B[k++] = A[j++];
        else
            while (i <= m)
                B[k++] = A[i++];

        for (k = 0; k < B.length; k++)
            A[k + l] = B[k];
    }


    public DLLNode<T> getLast()
    {return tail ;}
}
